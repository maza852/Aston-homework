package Heroes;

import Interfaces.Mortal;
import Enemies.Enemy;

public abstract class Hero implements Mortal {
    private String name;
    private int damageLevel;
    private int health;
    private static final int DEFAULT_HP = 100;      // уровень здоровья по умолчанию 100 единиц
    private static final int DEFAULT_DAMAGE = 20;   // размер урона наносимого врагу за 1 атаку по умолчанию 20 единиц

    public Hero(String name) {
        this.name = name;
        setDamageLevel(DEFAULT_DAMAGE);
        setHealth(DEFAULT_HP);
    }

    public String getName() {
        return name;
    }

    public abstract void attackEnemy(Enemy enemy);
    /*public void attackEnemy(Enemies.Enemy enemy) {
        System.out.println("Heroes.Hero '" + this.getName() + "' is attacking enemy");
        enemy.takeDamage(damage);
    }*/

    public int getDamageLevel() {
        return damageLevel;
    }

    public void setDamageLevel(int damageLevel) {
        if (damageLevel >= 0)
            this.damageLevel = damageLevel;
    }

    @Override
    public boolean isAlive() {
        return (health > 0);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health >= 0)
            this.health = health;
        else
            this.health = 0;        // при передаче отрицательного здоровья герой - мёртв :(
    }

    public void takeDamage(int damage) {
        setHealth(this.health - damage);

        System.out.println(this + " takes " + damage + " pts of damage." + " HP = " + getHealth());
        if (!isAlive())
            System.out.println(this + " is dead");
    }

    @Override
    public String toString() {
        return "{" + this.getClass().getSimpleName() +
                ": " + this.name + "}";
    }
}
