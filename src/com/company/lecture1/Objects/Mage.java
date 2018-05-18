package com.company.lecture1.Objects;

public class Mage extends Hero{
    public Mage(String name) {
        super(name);
    }
    @Override
    public void attackEnemy(Enemy enemy) {
        enemy.takeDamage(25);
        System.out.println("Mage attack Enemy!");
    }

}
