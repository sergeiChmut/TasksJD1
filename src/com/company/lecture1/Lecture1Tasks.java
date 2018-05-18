package com.company.lecture1;

import java.util.Scanner;

public class Lecture1Tasks {

    public static void main(String[] args) {
	    System.out.println("Start lecture1 task:");
	    task1();
	    task2();
	    task2_1();
	    task3();
	    task4();
    }

    /**
     1. Запросить у пользователя 2 слова. Если они одинаковы - вывести "Отлично! Слова одинаковы".
     Если они отличаются лишь регистром - "Хорошо. Почти одинаковы"
     Если они отличаются, но одной длины - "Ну, хотя бы они одной длины"
     Использовать методы класса String: equals(String string), equalsIgnoreCase(String string), length()

     */
    private static void task1() {
        Scanner  sc = new  Scanner(System.in);
        System.out.println("Введите два слова:");
        String firstWord = sc.next();
        String secondWord = sc.next();
        if (firstWord.equals(secondWord)) {
            System.out.println("Отлично! Слова одинаковы!");
        } else if (firstWord.equalsIgnoreCase(secondWord)) {
            System.out.println("Хорошо. Почти одинаковы");
        } else if (firstWord.length() == secondWord.length()) {
            System.out.println("Ну, хотя бы они одной длины");
        } else System.out.println("Не одно из заданых условий не выполняется:-)");

    }

    /**
     * 2. Имеется целое число, вводимое пользователем с консоли. Это число - сумма денег в рублях.
     *     Вывести это число, добавив к нему слово "рубль" в правильном падеже ("рубль", "рублей", "рубля").
     *     a. Использовать конструкцию if-else.
     *     b. Модифицировать в switch в отдельном файле.
     */


    private static void task2() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите сумму денег в рублях:");
        int moneyInRubles=in.nextInt();
        int lastNumber=moneyInRubles%10;int predNum=((moneyInRubles/10)%10);
        if (lastNumber==1) {
            System.out.println(moneyInRubles+" рубль");
        } else if (((lastNumber>=5)&&(lastNumber<=9)||(lastNumber==0)||((moneyInRubles>=11)&&(moneyInRubles<=19)||((predNum==1))&&(lastNumber>=1)&&(lastNumber<=9)))) {
            System.out.println(moneyInRubles+" рублей");
        } else if ((lastNumber>=2)&&(lastNumber<=4)) {
            System.out.println(moneyInRubles+" рубля");
        }
    }


    /** Модифицированная версия задания 2
     * с использованием swith
     *
     */
    private static void task2_1() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите сумму денег в рублях:");
        int moneyInRubles=in.nextInt();
        int lastNumber=moneyInRubles%10;
        if ((moneyInRubles>=11)&&(moneyInRubles<=19)) {
            System.out.println(moneyInRubles+" рублей");
        } else switch (lastNumber) {
            case 0:
                System.out.println(moneyInRubles + " рублей");
                break;
            case 1:
                System.out.println(moneyInRubles+" рубль");
                break;
            case 2:
            case 3:
            case 4:
                System.out.println(moneyInRubles+" рубля");
                break;
                default:
                    System.out.println(moneyInRubles+" рублей");
        }
    }


    /**
     * 3. Написать программу, которая считывает год, введённый пользователем, и определяет, является ли этот год високосным.
     *     Год считается високосным, если он делится без остатка на 4. Однако, если год также делится на 100, то этот год не високосный, за исключением годов, делящихся на 400.
     *     Например:
     *     1992 - високосный
     *     1900 - не високосный
     *     2000 - високосный
     */

    private static void task3() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите год:");
        int year=in.nextInt();
        if (year<=0)  System.out.println("Некорректное число, год не может быть отрицательным!");
        else {
            if (year % 4 == 0 || (!(year % 100 == 0) && year % 400 == 0)) {
                System.out.println(year+" - высокосный");
            } else {System.out.println(year+" - невисокосный");}
        }
    }

    /**
     * 4*. Написать программу, которая считывает число, месяц и год, введённые пользователем в виде трёх целых чисел.
     *       Программа должна определять, является ли введённая дата реальной и выводить результат.
     *       Использовать следующую информацию:
     *       Январь, март, май, июль, август, октябрь, декабрь - 31 день
     *       Апрель, июнь, сентябрь, ноябрь - 30 дней
     *       Февраль - 28 дней в обычный год, 29 дней в високосный
     */

    private static void task4() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите три числа:");
        System.out.println("День DD");
        System.out.println("Месяц MM");
        System.out.println("Год YYYY");
        int leapYear = 0;
        int full = 0;
        int day = in.nextInt();
        int month = in.nextInt();
        int year = in.nextInt();
        if (year <= 0 || month <= 0 || day <= 0)
            System.out.println("Некорректная дата, числа не могут быть отрицательными!");
        else {
            if (year % 4 == 0 || (!(year % 100 == 0) && year % 400 == 0)) leapYear = 1;
            if (((year == 2018) && (month <= 5) && (day <= 6)) || (year < 2018)) {
                switch (month) {
                    case 1:
                        if (day <= 31) System.out.println(day + " января " + year);
                        else System.out.println("Количество дней для этого месяца превышено!!!");
                        break;
                    case 2:
                        if ((day <= 28 && leapYear == 0) || (day <= 29 && leapYear == 1))
                            System.out.println(day + " февраля " + year);
                        else System.out.println("Количество дней для этого месяца превышено!!!");
                        break;
                    case 3:
                        if (day <= 31) System.out.println(day + " января " + year);
                        else System.out.println("Количество дней для этого месяца превышено!!!");
                        break;
                    case 4:
                        if (day <= 30) System.out.println(day + " апреля " + year);
                        else System.out.println("Количество дней для этого месяца превышено!!!");
                        break;
                    case 5:
                        if (day <= 31) System.out.println(day + " мая " + year);
                        else System.out.println("Количество дней для этого месяца превышено!!!");
                        break;
                    case 6:
                        if (day <= 30) System.out.println(day + " июня " + year);
                        else System.out.println("Количество дней для этого месяца превышено!!!");
                        break;
                    case 7:
                        if (day <= 31) System.out.println(day + " июля " + year);
                        else System.out.println("Количество дней для этого месяца превышено!!!");
                        break;
                    case 8:
                        if (day <= 31) System.out.println(day + " августа " + year);
                        else System.out.println("Количество дней для этого месяца превышено!!!");
                        break;
                    case 9:
                        if (day <= 30) System.out.println(day + " сентября " + year);
                        else System.out.println("Количество дней для этого месяца превышено!!!");
                        break;
                    case 10:
                        if (day <= 31) System.out.println(day + " октября " + year);
                        else System.out.println("Количество дней для этого месяца превышено!!!");
                        break;
                    case 11:
                        if (day <= 30) System.out.println(day + " ноября " + year);
                        else System.out.println("Количество дней для этого месяца превышено!!!");
                        break;
                    case 12:
                        if (day <= 31) System.out.println(day + " декабря " + year);
                        else System.out.println("Количество дней для этого месяца превышено!!!");
                        break;
                    default:
                        System.out.println("Число месяцев в году превышено!!!");
                }
            }

        }
    }
}


