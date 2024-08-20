// Маг наделен 2 способностями:
// 1. лечить героев (себя тоже)
// 2. атаковать нескольких врагов разом, нанося 120 единиц урона каждому
// здоровье по умолчанию 200 единиц
public class Mage extends Hero {
    public Mage(String name) {
        super(name);
        setDamageLevel(35);      // по умолчанию маг наносит 35 единиц урона
        setHealth(200);
    }
    // мертвый атаковать не может, потому добавлена проверка и вывод статуса героя (сомнительно, но окей)
    // мертвого врага тоже бить не надо
    @Override
    public void attackEnemy(Enemy enemy) {
        if (isAlive() && enemy.isAlive()) {
            System.out.println("Mage \"" + this.getName() + "\" is attacking " + enemy);
            enemy.takeDamage(this.getDamageLevel());
        } else
            System.out.println(this + " is dead");
    }
    // метод для лечения персонажей класса Hero на + 100 здоровья
    // лечить можно только ещё живых
    public void healHero(Hero hero) {
        if (isAlive()) {
            if (hero.isAlive()) {
                int hp = hero.getHealth() + 100;
                hero.setHealth(hp);
                System.out.println("\n" + this + " is healing " + hero + " HP = " + hero.getHealth());
            } else {
                System.out.println(this + " says: " + hero + " is dead! I cannot bring back to life this one.");
            }
        }
    }

    // метод ульта "я надеваю свой плащ и волшебную шляпу"
    // бьёт по площади и наносит всем врагам 120 единиц урона
    // врагов передаем в качестве аргумента
    public void putOnMyRobeAndWizardHat(Enemy... enemies) {
        if (isAlive()) {
            System.out.println("\n" + this + " says: \"I put on my robe and wizard hat!\"");
            for (int i = 0; i < enemies.length; i++) {
                if (enemies[i].isAlive())
                    enemies[i].takeDamage(120);
            }
        }
    }
}
