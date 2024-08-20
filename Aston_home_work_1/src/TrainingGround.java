public class TrainingGround {
    public static void main(String[] args) {
        testBattle();
    }

    public static void testBattle() {
        Enemy enemy = new Enemy(120);
        //showEnemyHealth(enemy);

        /*Hero hero = new Hero("Allmight");
        hero.attackEnemy(enemy);
        showEnemyHealth(enemy);*/

        Warrior warrior = new Warrior("Achilles son of Peleus");
        warrior.attackEnemy(enemy);
        //showEnemyHealth(enemy);

        Mage mage = new Mage("Gandalf the Grey");
        mage.attackEnemy(enemy);
        //showEnemyHealth(enemy);

        Archer archer = new Archer("Legolas");
        archer.attackEnemy(enemy);
        //showEnemyHealth(enemy);
    }

    /*public static void showEnemyHealth(Enemy enemy) {
        System.out.printf("Enemy has %d hp\n", enemy.getHealth());
    }*/
}
