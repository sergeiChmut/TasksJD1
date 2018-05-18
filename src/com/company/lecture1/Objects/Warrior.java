package com.company.lecture1.Objects;

public class Warrior extends Hero {
    public Warrior(String name) {
        super(name);
    }
    @Override
    public void attackEnemy(Enemy enemy) {
        enemy.takeDamage(10);
        System.out.println("Warrior attack Enemy!");
    }
}
