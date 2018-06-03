package com.lectures.lecture6;

public class Archer extends Hero {
    public Archer(String name) {
        super(name);
    }

    public void attackEnemy(Enemy enemy) {
        enemy.takeDamage(15);
        System.out.println(name+" attack "+enemy.getName()+"!");
    }

}
