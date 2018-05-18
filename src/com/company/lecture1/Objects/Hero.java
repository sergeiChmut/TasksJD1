package com.company.lecture1.Objects;

/**
 * 1. Создать класс Hero, представляющий собой героя и содержащий поле name.
 *     Добавить конструктор, принимающий имя героя и геттер для имени (сеттер не нужен).
 *     Добавить метод attackEnemy(), выводящий в консоль сообщение о том, что герой атакует врага.
 *     Создать класс TrainingGround, содержащий метод main. Протестировать создание героя и его атаку.
 */
public class Hero {
    String Name;
    public Hero(String name) {
        Name=name;
    }

    public String getName() {
        return Name;
    }

    public void attackEnemy(Enemy enemy) {
        enemy.takeDamage(20);
        System.out.println("Hero attack Enemy!");
    }
}
