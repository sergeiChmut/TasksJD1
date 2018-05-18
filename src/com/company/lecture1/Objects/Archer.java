package com.company.lecture1.Objects;

public class Archer extends Hero {
    public Archer(String name) {
        super(name);
    }
    @Override
    public void attackEnemy(Enemy enemy) {
        enemy.takeDamage(15);
        System.out.println("Archer attack Enemy!");
    }

}
