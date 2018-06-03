package com.lectures.lecture6;

public class Warrior extends Hero {
    public Warrior(String name) {
        super(name);
    }

    public void attackEnemy(Enemy enemy) {
        enemy.takeDamage(10);
        System.out.println(name+" attack "+enemy.getName()+"!");
    }
}
