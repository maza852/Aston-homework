package Enemies;

import Enemies.Enemy;

// Зомби имеет особенность при которой получая урон и умирая, он имеет шанс воскреснуть с половиной от жизни по умолчанию
public class Zombie extends Enemy {
    private static final int DEFAULT_HP = 666;
    private static final int DEFAULT_DAMAGE = 25;   // урон по умолчанию 25 единиц
    public Zombie() {
        super(DEFAULT_HP);
        setDamageLevel(DEFAULT_DAMAGE);
    }

    @Override
    public void takeDamage(int damage) {
        setHealth(this.getHealth() - damage);

        System.out.println(this + " takes " + damage + " pts of damage." + " HP = " + getHealth());

        if (!isAlive()) {
            System.out.println(this + " is dead");
            int randNumber = (int) (Math.random() * 10);
            if (randNumber > 4) {
                setHealth(DEFAULT_HP / 2);
                System.out.println(this + " is back to 'life'!" + " HP = " + getHealth());
            }
        }
    }
}
