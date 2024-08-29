package Enemies;

import Enemies.Enemy;

// Голем имеет особенность - если урон не был смертельным, то он регенерирует 50% от полученного урона
// или проще говоря получает только половину урона
public class Golem extends Enemy {
    private static final int DEFAULT_DAMAGE = 40;   // урон по умолчанию 40 единиц

    public Golem(int health) {
        super(health);
        setDamageLevel(DEFAULT_DAMAGE);
    }

    @Override
    public void takeDamage(int damage) {
        int realDamage = damage;

        if (this.getHealth() - damage > 0)
            realDamage = damage / 2;

        setHealth(this.getHealth() - realDamage);
        System.out.println(this + " takes " + damage + " pts of damage." + " HP = " + getHealth());

        if (isAlive())
            System.out.println(this + " is dead");
    }
}
