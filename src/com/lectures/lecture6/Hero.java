package com.lectures.lecture6;

/**
 * 1. Создать класс Hero, представляющий собой героя и содержащий поле name.
 *     Добавить конструктор, принимающий имя героя и геттер для имени (сеттер не нужен).
 *     Добавить метод attackEnemy(), выводящий в консоль сообщение о том, что герой атакует врага.
 *     Создать класс TrainingGround, содержащий метод main. Протестировать создание героя и его атаку.
 */
public abstract class Hero implements Mortal {
    String name;
    int health;

    Hero(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public abstract void attackEnemy(Enemy enemy); //{
        //enemy.takeDamage(20);
        //System.out.println("Hero attack Enemy!");
   // }
    public void takeDamage(int damage) {
        health-=damage;
    }
    @Override
    public boolean isAlive() {
        if (health>0) {
            return true;
        }
        return false;
    }
}
