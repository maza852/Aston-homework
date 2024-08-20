// Зомби имеет особенность при которой получая урон и умирая, он имеет шанс воскреснуть с 333 единицами жизни
public class Zombie extends Enemy {
    public Zombie() {
        super(666);
        setDamageLevel(25);     // урон по умолчанию 25 единиц
    }

    @Override
    public void takeDamage(int damage) {
        setHealth(this.getHealth() - damage);

        System.out.println(this + " takes " + damage + " pts of damage." + " HP = " + getHealth());

        if (!isAlive()) {
            System.out.println(this + " is dead");
            int randNumber = (int) (Math.random() * 10);
            if (randNumber > 4) {
                setHealth(333);
                System.out.println(this + " is back to 'life'!" + " HP = " + getHealth());
            }
        }
    }
}
