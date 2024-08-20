// Дракон имеет своё имя и спец. атаку на нескольких противников
public class Dragon extends Enemy {
    private String name;

    public Dragon(String name) {
        super(1000);        // вызываем конструктор родителя и передаем 1000 очков жизни
        this.name = name;         // у дракона должно быть имя и точка
        setDamageLevel(50);       // урон по умолчанию 50 единиц
    }

    // метод море огня наносит урон 99 единиц всем героям переданным как аргумент
    public void seaOfFire(Hero... heroes) {
        if (isAlive()) {
            System.out.println("\n" + this + " says: 'I will see you burn to the ash! Ha-ha-haa.'");
            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].isAlive())
                    heroes[i].takeDamage(99);
            }
        }
    }

    @Override
    public String toString() {
        return "{" + this.getClass().getName() +
                ": " + this.name + "}";
    }
}
