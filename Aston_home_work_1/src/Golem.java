// Голем имеет особенность - после получения урона сразу же восстановить здоровье на 50% от полученного урона
public class Golem extends Enemy {
    public Golem(int health) {
        super(health);
        setDamageLevel(40);     // урон по умолчанию 40 единиц
    }

    @Override
    public void takeDamage(int damage) {
        setHealth(this.getHealth() - damage);
        if (isAlive()) {
            setHealth(this.getHealth() + (int)(0.5d * (double)damage) );
            System.out.println(this + " takes " + damage + " pts of damage." + " HP = " + getHealth());
        } else {
            System.out.println(this + " takes " + damage + " pts of damage." + " HP = " + getHealth());
            System.out.println(this + " is dead");
        }
    }
}
