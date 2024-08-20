// Лучник наделен 2 способностями:
// 1. shootAtKnees - 5ти кратный урон врагу.
// 2. useCombinedAttack - атака в паре с другим героем по нескольким врагам.
// здоровье по умолчанию 250 единиц
public class Archer extends Hero {
    public Archer(String name) {
        super(name);
        this.setDamageLevel(20);     // по умолчанию лучнику назначим урон 20 единиц
        setHealth(250);
    }

    // мертвый атаковать не может, потому добавлена проверка и вывод статуса героя (сомнительно, но окей)
    // мертвого врага тоже бить не надо
    @Override
    public void attackEnemy(Enemy enemy) {
        if (isAlive() && enemy.isAlive()) {
            System.out.println(String.format("Archer \"%s\" is attacking %s", this.getName(), enemy));
            enemy.takeDamage(this.getDamageLevel());

        } else
            System.out.println(this + " is dead");
    }
    // метод стрелять по коленям - наносит 5ти кратный урон врагу
    public void shootAtKnees(Enemy enemy) {
        String catchPhrase = "Your adventure road has come to an end.";
        if (isAlive() && enemy.isAlive()) {
            System.out.println("\n" + this + " says: " + catchPhrase);
            System.out.println("And shoot at knee to " + enemy);
            enemy.takeDamage( 5 * this.getDamageLevel());
        }
    }

    // метод комбинированная атака наносит урон всем врагам, переданным как аргумент
    // выполнить его можно только в паре с другим героем, так как они вместе наносят удары
    public void useCombinedAttack(Hero hero, Enemy... enemies) {
        if (hero.isAlive() && this.isAlive()) {
            System.out.println("\n" + this + " says to " + hero + " 'Let's kick ass all of them!'");
            for (int i = 0; i < enemies.length; i++) {
                if (enemies[i].isAlive()) {
                    hero.attackEnemy(enemies[i]);
                    this.attackEnemy(enemies[i]);
                }
            }
        }
    }
}
