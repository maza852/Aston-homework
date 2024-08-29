package Enemies;

import Heroes.Hero;

// Дракон имеет своё имя и спец. атаку на нескольких противников
public class Dragon extends Enemy {
    private String name;
    private static final int DEFAULT_HP = 1000;
    private static final int DEFAULT_DAMAGE = 50;
    private static final int SPECIAL_DAMAGE = 99;

    public Dragon(String name) {
        super(DEFAULT_HP);                      // вызываем конструктор родителя и передаем 1000 очков жизни
        this.name = name;                       // у дракона должно быть имя и точка
        setDamageLevel(DEFAULT_DAMAGE);         // урон по умолчанию 50 единиц
    }

    // метод море огня наносит урон SPECIAL_DAMAGE единиц всем героям переданным как аргумент
    public void useSeaOfFire(Hero... heroes) {
        if (isAlive()) {
            System.out.println("\n" + this + " says: 'I will see you burn to the ash! Ha-ha-haa.'");
            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].isAlive())
                    heroes[i].takeDamage(SPECIAL_DAMAGE);
            }
        }
    }

    @Override
    public String toString() {
        return "{" + this.getClass().getSimpleName() +
                ": " + this.name + "}";
    }
}
