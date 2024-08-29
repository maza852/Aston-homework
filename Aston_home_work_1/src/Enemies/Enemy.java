package Enemies;

import Interfaces.Mortal;
import Heroes.Hero;

public class Enemy implements Mortal {
    private int health;
    private int damageLevel;
    private static final int DEFAULT_HP = 100;  // по умолчанию пусть у врага будет 100 hp
    private static final int MIN_HP = 1;
    private static final int DEFAULT_DAMAGE = 10;   // уровень урона врага по умолчанию 10 единиц

    public Enemy() {
        this(DEFAULT_HP);
    }

    public Enemy(int health) {
        initialize(health);
        setDamageLevel(DEFAULT_DAMAGE);
    }

    private void initialize(int health) {
        if (health <= 0)
            setHealth(MIN_HP);   // если по ошибке создавать врага с отрицательным или нулевым здоровьем, то устанавливаем минимальное hp
        else
            setHealth(health);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health >= 0)
            this.health = health;
        else
            this.health = 0;        // при передаче отрицательного здоровья враг - мёртв :(
    }

    public void takeDamage(int damage) {
        setHealth(this.health - damage);

        System.out.println(this + " takes " + damage + " pts of damage." + " HP = " + getHealth());
        if (!isAlive())
            System.out.println(this + " is dead");
    }

    @Override
    public boolean isAlive() {
        return (health > 0);
    }

    public int getDamageLevel() {
        return damageLevel;
    }

    public void setDamageLevel(int damageLevel) {
        if (damageLevel > 0)
            this.damageLevel = damageLevel;
    }

    // атаковать может только живой персонаж
    // мертвого героя нет смысла атаковать
    public void attackHero(Hero hero) {
        if (isAlive()) {
            if (hero.isAlive()) {
                System.out.println(this + " is attacking " + hero);
                hero.takeDamage(damageLevel);
            }
        } else
            System.out.println(this + " is dead");
    }

    @Override
    public String toString() {
        return "{" + this.getClass().getSimpleName() +  "}";
    }
}
