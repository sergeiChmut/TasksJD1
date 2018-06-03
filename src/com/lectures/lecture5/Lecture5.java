package com.lectures.lecture5;

import java.math.BigDecimal;

/**
 *  1.Определить размер массива типа Long[10], Double[10], Byte[10]
 *      Long[10]
 *      Заголовок: 8 байт
 *      Ссылочная переменная на объект массива: 4 байта
 *      Выравнивание : 4 байта - Итого: 16 байт
 *      + 10* { Ссылка на объект 4 байта+ переменная типа long 8 байт + выравнивание 4 байта }
 *      = 176 байт
 *      Double[10]
 *  *      Заголовок: 8 байт
 *  *      Ссылочная переменная на объект массива: 4 байта
 *  *      Выравнивание : 4 байта - Итого: 16 байт
 *  *      + 10* { Ссылка на объект 4 байта+ переменная типа double 8 байт + выравнивание 4 байта }
 *  *      = 176 байт
 *      Byte[10]
 *          Заголовок: 8 байт
 *  *      Ссылочная переменная на объект массива: 4 байта
 *  *      Выравнивание : 4 байта - Итого: 16 байт
 *  *      + 10* { Ссылка на объект 4 байта+ переменная типа byte 1 байт + выравнивание 3 байта }
 *  *      = 96 байт
 *
 *2. Определить размер объекта String [10].
 *  Заголовок: 8 байт
 *  Ссылочная переменная на объект массива: 4 байта
 *  Выравнивание : 4 байта - Итого: 16 байт
 *      + 10 * {на массив символов 12 байт + по 2 байта на каждый символ+выравнивание до кратности 8}
 *
 *
 * 3. Определить класс, который при инициализации принимает на вход 2 аргумента целого или вещественного типа.
 * Задать методы возвращающие результат арифметических операций над заданными полями и полями типа BigDecimal.
 */
public class Lecture5 {
    public static void main(String[] args) {
        Integer number1=35;
        Integer number2=15;
        Double number3=35.0;
        Double number4=15.5;
        Demo task1=new Demo(number1,number2);
        Demo task2=new Demo(number3,number4);
        task1.operationInt();
        task2.operationDouble();

    }

}

class Demo {
    Integer number1;
    Integer number2;
    Double number3;
    Double number4;

    public Demo(Integer number1, Integer number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    public Demo(Double number3, Double number4) {
        this.number3 = number3;
        this.number4 = number4;
    }
    public void operationInt () {
        BigDecimal x = new BigDecimal(number1);
        BigDecimal y = new BigDecimal(number2);
        System.out.println("Integer x= "+number1+",y= "+number2+"            normal                  BigDecimal");
        System.out.println("x + у =            " +(number1+number2)+"                            "+ x.add(y));
        System.out.println("x - у =            " + (number1-number2)+"                             "+x.subtract(y));
        System.out.println("x * у =            " +(number1*number2)+"                            "+x.multiply(y));
        System.out.println("х / у =            " + (number1/number2)+"                            "+x.divide(y, 6, BigDecimal.ROUND_HALF_EVEN));

    }
    public void operationDouble () {
        BigDecimal x = new BigDecimal(number3);
        BigDecimal y = new BigDecimal(number4);
        System.out.println("Double x= "+number3+",y= "+number4+"            normal                  BigDecimal");
        System.out.println("x + у =              " +(number3+number4)+"                              "+ x.add(y));
        System.out.println("x - у =              " + (number3-number4)+"                             "+x.subtract(y));
        System.out.println("x * у =              " +(number3*number4)+"                            "+x.multiply(y));
        System.out.println("х / у =             " + (number3/number4)+"                             "+x.divide(y, 6, BigDecimal.ROUND_HALF_EVEN));

    }


}
