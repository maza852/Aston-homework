// Воин наделен 1 способностью, но очень мощной
// useRageOfSparta даёт суммарно 20 кратный урон врагу
// здоровье по умолчанию 300 единиц
public class Warrior extends Hero {
    public Warrior(String name) {
        super(name);
        setDamageLevel(25);  // по умолчанию воин наносит 25 единиц урона
        setHealth(300);
    }
    // мертвый атаковать не может, потому добавлена проверка и вывод статуса героя (сомнительно, но окей)
    // мертвого врага тоже бить не надо
    @Override
    public void attackEnemy(Enemy enemy) {
        if (isAlive() && enemy.isAlive()) {
            System.out.println("Warrior \"" + this.getName() + "\" is attacking " + enemy);
            enemy.takeDamage(this.getDamageLevel());
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
