package BattleGrounds;

import Enemies.Enemy;
import Heroes.Hero;
import Heroes.Warrior;

public class BattleGround {
    public static void main(String[] args) {
        Hero hero = new Warrior("Ultraman");
        hero.setDamageLevel(50);                         // прокачаем воину урон до 50
        Enemy enemy = new Enemy(666);

        int hitCount = 0;
        while (enemy.isAlive()) {
            hero.attackEnemy(enemy);
            //System.out.println(enemy.getHealth());
            hitCount++;
        }

        System.out.printf("Для уничтожения врага потребовалось %d ударов!\n", hitCount);
    }
}
