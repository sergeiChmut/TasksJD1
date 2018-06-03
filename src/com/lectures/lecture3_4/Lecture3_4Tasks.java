package com.lectures.lecture3_4;

import java.util.Scanner;
public class Lecture3_4Tasks {
    public static void main(String[] args) {
        System.out.println("Start lecture3_4 tasks:");
        task1();
        task2();
    }

    /**
     * 1. Создать класс, описывающий промежуток времени.
     * Сам промежуток времени должен задаваться тремя свойствами: секундами, минутами и часами.
     * Создать метод для получения полного количества секунд в объекте
     * Создать два конструктора: первый принимает общее количество секунд, второй - часы, минуты и секунды по отдельности.
     * Создать метод для вывода данных.
     * Написать программу для тестирования возможностей класса.
     *
     *
     */

    private static void task1() { //программа для тестирования возможностей класса IntervalOfTime
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число секунд:");
        int number=in.nextInt();
        IntervalOfTime anyTime = new IntervalOfTime(number);
        System.out.println("Time "+anyTime.getTime()+"Time in sec "+anyTime.getSec());
        IntervalOfTime presetTime= new IntervalOfTime(110,65,12);
        System.out.println("Preset time "+presetTime.getTime()+"Time in sec "+presetTime.getSec());

    }

    /**
     * 2. Создать класс, описывающий банкомат.
     * Набор купюр, находящихся в банкомате должен задаваться тремя свойствами:
     * количеством купюр номиналом 20, 50 и 100. Сделать методы для добавления денег в банкомат.
     * Сделать функцию, снимающую деньги, которая принимает сумму денег, а возвращает булевое значение - успешность выполнения операции.
     * При снятии денег функция должна распечатывать каким количеством купюр какого номинала выдаётся сумма.
     * Создать конструктор с тремя параметрами - количеством купюр каждого номинала.
     */



    private static void task2() {  //программа для тестирования возможностей класса Atm
        System.out.println("Задание 2, банкомат");
        Atm FirstAtm=new Atm(1,1,1);
        Atm SecondAtm= new Atm();
        FirstAtm.setCash(100,100,100);
        Scanner in = new Scanner(System.in);
        System.out.println("Введите сумму снятия наличных:");
        int cash=in.nextInt();
        if (FirstAtm.cashOut(cash)) {
            System.out.println("Транзакция прошла успешно!");
        } else {
            System.out.println("Снятие этой суммы невозможно!");
        }
    }


}
