package com.lectures.lecture6;

public class Enemy implements Mortal {
    int health;
    String name;

    public String getName() {
        return name;
    }

    public Enemy(int health,String name) {
        this.health=health;
        this.name=name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public void takeDamage(int damage) {
        health-=damage;
    }
    public void rerurnAttack(Hero hero) {
        hero.takeDamage(20);
        System.out.println("Enemy attack --> " + hero.getName()+"!!");
   }
    public boolean isAlive() {
        if (health>0) {
            return true;
        }
        return false;
    }
}
