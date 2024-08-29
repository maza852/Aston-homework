package BattleGrounds;
// 7ой пункт в домашнем задании
// здесь протестил придуманный доп.функционал к классам героев и врагов
// получилось немного душновато, т.к. битва затяжная, но зато весь функционал проверил (вроде бы...)
// в первом статик методе герои побеждают дракона
// во втором три на три, где могут победить злодеи
// если баловаться с уроном, то 2 предложения выше несостоятельны

import Enemies.Dragon;
import Enemies.Golem;
import Enemies.Zombie;
import Heroes.Archer;
import Heroes.Mage;
import Heroes.Warrior;

public class EpicBattleGround {
    public static void main(String[] args) {
        herosSquadAgainstTheDragon();
        //dragonVengeance();
    }
    public static void herosSquadAgainstTheDragon() {
        // отряд героев
        Warrior dragonBorn = new Warrior("Dovakin");
        Archer elf = new Archer("Vernosiel");
        Mage rudeus = new Mage("Rudeus Greyrat");

        // сильный дракон с уроном в 100!
        Dragon dragon = new Dragon("Balerion");
        dragon.setDamageLevel(100);

        System.out.printf("Our heroes: %s, %s, %s\n", dragonBorn, elf, rudeus);
        System.out.println("Against " + dragon + "\n");
        // дракон нападает на эльфийку
        dragon.attackHero(elf);
        // воин использует ульту
        dragonBorn.useRageOfSparta(dragon);
        // маг лечит эльфийку-лучника
        rudeus.healHero(elf);
        // лучник-эльфийка мстит выстрелом по коленям)
        elf.shootAtKnees(dragon);
        // дракон использует спец атаку на всех героев
        dragon.useSeaOfFire(dragonBorn, elf, rudeus);
        // маг использует свою ульту)
        rudeus.putOnMyRobeAndWizardHat(dragon);
        // дракон дважды атакует воина
        dragon.attackHero(dragonBorn);
        dragon.attackHero(dragonBorn);
        // маг лечит воина
        rudeus.healHero(dragonBorn);
        // дракон атакует мага
        dragon.attackHero(rudeus);
        // лучник использует спец атаку вместе с воином
        elf.useCombinedAttack(dragonBorn, dragon);
        // маг лечит себя
        rudeus.healHero(rudeus);
        // все три героя атакуют дракона
        rudeus.attackEnemy(dragon);
        elf.attackEnemy(dragon);
        dragonBorn.attackEnemy(dragon);
        // эльфийка снова за своё) выстрел по коленкам
        elf.shootAtKnees(dragon);
        // дракон отчаянно атакует 2х героев
        dragon.attackHero(rudeus);
        dragon.attackHero(dragonBorn);
        // лучница и маг добивают дракона совместной атакой
        elf.useCombinedAttack(rudeus, dragon);

        if (rudeus.isAlive() && elf.isAlive() && dragonBorn.isAlive())
            System.out.println("Yay! We are win!");

        if (!rudeus.isAlive() && !elf.isAlive() && !dragonBorn.isAlive())
            System.out.println("All heroes are dead :(");
    }

    // особенность: если зомби не воскреснет, то один герой остается живым! Или плохиши победят, таков рандом
    public static void dragonVengeance() {
        Warrior warrior = new Warrior("Dovakin");
        Archer archer = new Archer("Vernosiel");
        Mage mag = new Mage("Rudeus Greyrat");

        Dragon dragon = new Dragon("Bobr-kurwa");
        dragon.setDamageLevel(150);
        Zombie zombie = new Zombie();
        zombie.setDamageLevel(70);
        Golem golem = new Golem(300);

        dragon.useSeaOfFire(warrior, mag, archer);

        golem.attackHero(archer);

        mag.healHero(archer);

        zombie.attackHero(warrior);

        warrior.useRageOfSparta(zombie);

        archer.shootAtKnees(zombie);

        dragon.attackHero(warrior);

        mag.healHero(warrior);

        golem.attackHero(mag);

        mag.putOnMyRobeAndWizardHat(dragon, zombie, golem);

        archer.attackEnemy(golem);

        golem.attackHero(archer);

        mag.healHero(archer);

        zombie.attackHero(mag);

        dragon.attackHero(archer);
        zombie.attackHero(archer);
        golem.attackHero(archer);

        archer.shootAtKnees(golem);
        dragon.attackHero(archer);

        if (!mag.isAlive() && !archer.isAlive() && !warrior.isAlive())
            System.out.println("Looks like the bad guys have won");
        else
            System.out.println("At least one hero is still alive");
    }
}
