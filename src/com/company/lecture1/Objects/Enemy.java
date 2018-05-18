package com.company.lecture1.Objects;

public class Enemy {
    int Health;
    public Enemy(int health) {
        Health=health;
    }

    public int getHealth() {
        return Health;
    }

    public void setHealth(int health) {
        Health = health;
    }
    public void takeDamage(int damage) {
        Health-=damage;
    }
}
