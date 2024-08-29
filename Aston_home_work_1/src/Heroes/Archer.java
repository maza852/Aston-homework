package Heroes;

import Enemies.Enemy;
import Heroes.Hero;

// Лучник наделен 2 способностями:
// 1. shootAtKnees - 5ти кратный урон врагу.
// 2. useCombinedAttack - атака в паре с другим героем по нескольким врагам.
// здоровье по умолчанию 250 единиц
public class Archer extends Hero {
    private static final int DEFAULT_HP = 250;
    private static final int DEFAULT_DAMAGE = 20;
    public Archer(String name) {
        super(name);
        this.setDamageLevel(DEFAULT_DAMAGE);
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

    // метод стрелять по коленям - наносит 5ти кратный урон врагу
    public void shootAtKnees(Enemy enemy) {
        String catchPhrase = "Your adventure road has come to an end.";
        if (isAlive() && enemy.isAlive()) {
            System.out.println("\n" + this + " says: " + catchPhrase);
            System.out.println("And shoot at knee to " + enemy);
            enemy.takeDamage(5 * this.getDamageLevel());
        }
    }

    // метод комбинированная атака наносит урон всем врагам, переданным как аргумент
    // выполнить его можно только в паре с другим героем, так как они вместе наносят удары
    public void useCombinedAttack(Hero hero, Enemy... enemies) {
        if (hero.isAlive() && this.isAlive()) {
            System.out.println("\n" + this + " says to " + hero + " 'Let's kick some ass!'");
            for (int i = 0; i < enemies.length; i++) {
                if (enemies[i].isAlive()) {
                    hero.attackEnemy(enemies[i]);
                    this.attackEnemy(enemies[i]);
                }
            }
        }
    }
}
