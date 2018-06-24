package com.lectures.lecture6;
/**
 * 6. Создать класс BattleGround с методом main, в котором создать симуляцию героя, атакующего врага.
 *  *
 *  * 7*. Добавить герою показатель здоровья и возможность погибнуть.
 *  *      Добавить возможность врагу атаковать героя в ответ.
 *  *      Создать несколько видов врагов (наследников класса Enemy) с разными способностями (например, Zombie - имеет шанс воскреснуть при гибели)
 *  *      Дать героям уникальные способности.
 *  *      Продемонстрировать сражение героя с несколькими соперниками.
 */
public class BattleGround {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Task 7: Battle");
        System.out.println("Hero : Mage, Archer, Warrior");
        System.out.println("Enemy: Enemy, Zombie");
        Enemy enemy=new Enemy(200, "Enemy"); //Создаем персонажей
        Mage mage=new Mage( "Mage");
        mage.setHealth(100);
        Warrior warrior=new Warrior("Warrior");
        warrior.setHealth(200);
        Hero archer=new Archer("Archer");
        archer.setHealth(150);
        Zombie zombie=new Zombie(200,"Zombie");
        boolean good=(mage.isAlive()||warrior.isAlive()||archer.isAlive()); // условие 'на существование' персонажей добра
        boolean evil=(zombie.isAlive()||enemy.isAlive()); // условие 'на наличие' персонажей зла
        while (good&&evil) { // если добро и зло присутствуют продолжаем Борьбу
            if (mage.isAlive()) System.out.print("\n< "+mage.getName()+" health: "+mage.getHealth()+" >  "); // выводим присутствие персонажей
            if (warrior.isAlive()) System.out.print("< "+warrior.getName()+" health: "+warrior.getHealth()+" >  ");// с количеством жизней
            if (archer.isAlive()) System.out.print("< "+archer.getName()+" health: "+archer.getHealth()+" >  ");
            if (good) System.out.print("\n--------------------------------------------------------\n");
            if (enemy.isAlive()) System.out.print("< Enemy health: "+enemy.getHealth()+" >  ");
            if (zombie.isAlive()) System.out.print("< Zombie health: "+zombie.getHealth()+" >  ");
            System.out.println("\n");
            int kick=(int)(1+Math.random()*4); // случайно определяем несколько сценариев аттак
            switch (kick){
                case 1:
                    if (zombie.isAlive()&&enemy.isAlive()&&(zombie.getHealth()>enemy.getHealth())) { //логика на наличие врагов
                        warrior.attackEnemy(zombie);                                                    // для порядка аттаки
                    }else if (zombie.isAlive()&&enemy.isAlive()&&(zombie.getHealth()<=enemy.getHealth())) {
                        warrior.attackEnemy(enemy);enemy.rerurnAttack(warrior);
                    } else if (zombie.isAlive()) warrior.attackEnemy(zombie);
                    else {warrior.attackEnemy(enemy);enemy.rerurnAttack(warrior);}
                    break;
                case 2:
                    if (zombie.isAlive()&&enemy.isAlive()&&(zombie.getHealth()>enemy.getHealth())) {
                        archer.attackEnemy(zombie);
                    }else if (zombie.isAlive()&&enemy.isAlive()&&(zombie.getHealth()<=enemy.getHealth())) {
                        archer.attackEnemy(enemy);enemy.rerurnAttack(archer);
                    } else if (zombie.isAlive()) warrior.attackEnemy(zombie);
                    else {archer.attackEnemy(enemy);enemy.rerurnAttack(archer);}
                    break;
                case 3:
                    if (zombie.isAlive()) {
                        mage.attackEnemy(zombie);
                        mage.heal(warrior);
                    }
                    break;
                case 4:
                    zombie.rerurnAttack(warrior);   //варианты ударов
                    mage.attackEnemy(zombie);
                    zombie.rerurnAttack(archer);
                    mage.attackEnemy(enemy);
                    break;
                case 5:
                    enemy.rerurnAttack(warrior);
                    warrior.attackEnemy(enemy);
                    enemy.rerurnAttack(archer);
                    break;
            }
            good=(mage.isAlive()||warrior.isAlive()||archer.isAlive()); // обновляем условие на наличие персонажей добра и зла
            evil=(zombie.isAlive()||enemy.isAlive());
            Thread.sleep(100);
        }
        if (good) {
            System.out.println("Heroes won VICTORY !!!"); // результат в зависимости от наличия персонажей
        }
        if (evil) {
            System.out.println("Evil won...");
        }
    }

}
