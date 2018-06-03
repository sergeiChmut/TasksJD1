package com.lectures.lecture6;

public class Mage extends Hero {
    public Mage(String name) {
        super(name);
    }

    public void attackEnemy(Enemy enemy) {
        enemy.takeDamage(25);
        System.out.println(name+" attack "+enemy.getName()+"!");
    }



    public void heal(Warrior warrior) {
        if (warrior.health<150) {
            warrior.setHealth(150);
            System.out.println("Mage gives health for Warrior!");
        }
    }
}
