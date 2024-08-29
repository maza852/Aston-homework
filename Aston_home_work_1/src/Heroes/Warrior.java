package Heroes;

import Enemies.Enemy;
import Heroes.Hero;

// Воин наделен 1 способностью, но очень мощной
// useRageOfSparta даёт суммарно 20 кратный урон врагу
// здоровье по умолчанию 300 единиц
public class Warrior extends Hero {
    private static final int DEFAULT_HP = 300;
    private static final int DEFAULT_DAMAGE = 25;
    public Warrior(String name) {
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
        } else {
            System.out.println(this + " is dead");
        }
    }

    // метод ярость Спарты увеличивает наносимый врагу урон в 2 раза
    // наносит сразу 10 ударов, что убьёт 1 слабого врага (переданного как аргумент)
    public void useRageOfSparta(Enemy enemy) {
        String catchPhrase = "This is SPARTA!!!";
        System.out.println("\n" + this + " says " + catchPhrase);
        for (int i = 0; i < 10; i++) {
            if (enemy.isAlive())
                enemy.takeDamage(2 * this.getDamageLevel());
        }
    }
}
