package Heroes;

import Enemies.Enemy;
import Heroes.Hero;

// Маг наделен 2 способностями:
// 1. лечить героев (себя тоже)
// 2. атаковать нескольких врагов разом, нанося 120 единиц урона каждому
// здоровье по умолчанию 200 единиц
public class Mage extends Hero {
    private static final int DEFAULT_HP = 200;
    private static final int DEFAULT_DAMAGE = 35;
    private static final int HEAL_POINTS = 100;
    private static final int SPECIAL_DAMAGE = 120;

    public Mage(String name) {
        super(name);
        setDamageLevel(DEFAULT_DAMAGE);
        setHealth(DEFAULT_HP);
    }

    // мертвый атаковать не может, потому добавлена проверка и вывод статуса героя (сомнительно, но окей)
    // мертвого врага тоже бить не надо
    @Override
    public void attackEnemy(Enemy enemy) {
        if (isAlive()) {
            if (enemy.isAlive()) {
                System.out.printf(this + " is attacking %s\n", enemy);
                enemy.takeDamage(this.getDamageLevel());
            }
        } else
            System.out.println(this + " is dead");
    }

    // метод для лечения персонажей класса Hero на + HEAL_POINTS здоровья
    // лечить можно только ещё живых
    public void healHero(Hero hero) {
        if (isAlive()) {
            if (hero.isAlive()) {
                int hp = hero.getHealth() + HEAL_POINTS;
                hero.setHealth(hp);
                System.out.println("\n" + this + " is healing " + hero + " HP = " + hero.getHealth());
            } else {
                System.out.println(this + " says: " + hero + " is dead! I cannot bring back to life this one.");
            }
        }
    }

    // метод ульта "я надеваю свой плащ и волшебную шляпу"
    // бьёт по площади и наносит всем врагам SPECIAL_DAMAGE единиц урона
    // врагов передаем в качестве аргумента
    public void putOnMyRobeAndWizardHat(Enemy... enemies) {
        if (isAlive()) {
            System.out.println("\n" + this + " says: \"I put on my robe and wizard hat!\"");
            for (int i = 0; i < enemies.length; i++) {
                if (enemies[i].isAlive())
                    enemies[i].takeDamage(SPECIAL_DAMAGE);
            }
        }
    }
}
