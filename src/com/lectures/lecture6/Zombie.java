package com.lectures.lecture6;

public class Zombie extends Enemy{
    int countLife;

    public Zombie(int health, String name) {
        super(health, name);
    }
    public void takeDamage(int damage) {
        if ((health<=0)&&(countLife<2)){
            health=100;
            System.out.println("Iam Zombie - Zombie not Die! health: 100");
            countLife++;
        }
        health-=damage;
    }


}
