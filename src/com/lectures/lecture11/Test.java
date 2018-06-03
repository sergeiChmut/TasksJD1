package com.lectures.lecture11;

import java.util.NoSuchElementException;

/**
 * 1.	Объявите переменную со значением null. Вызовите метод у этой переменной.
 * Отловите возникшее исключение.
 * 2.	Написать код, который создаст, а затем отловит ArrayIndexOutOfBoundsException.
 * 3.	Создать собственный класс-исключение - наследник класса Exception.
 * Создать метод, выбрасывающий это исключение.
 * Вызвать этот метод и отловить исключение. Вывести stacktrace в консоль.
 * 4.	Повторить предыдущее упражнение, но наследуя свой класс от класса RuntimeException.
 * Добавить вконструктор своего класса возможность указания сообщения.
 * 5.	Бросить одно из существующих в JDK исключений, отловить его и выбросить своё собственное,указав в качестве причины отловленное.
 * 6.	Создать метод случайным образом выбрасывающий одно из 3-х видов исключений.
 * Вызвать этот метод в блоке try-catch, отлавливающем любое из 3-х.
 * 7.	Написать метод, который в 50% случаев бросает исключение.
 * Вызвать этот метод в конструкции try-catch-finally. Протестировать работу блока finally.
 */

public class Test {
    static Integer example;

    public Integer getExample() {
        return example;
    }


    public static void main(String[] args) {


        //task1();
        //task2();
        //task3();
        //task4();
        //task5();
        //task6();
        task7();

    }

    /**
     * 1.	Объявите переменную со значением null. Вызовите метод у этой переменной.
     * Отловите возникшее исключение.
     */

    private static void task1() {
        try {
            nullPointer();
        } catch (NullPointerException npe) {
            System.out.println("Ошибка! Некорректное значение");
            example = 0;
        }

    }

    private static void nullPointer() throws NullPointerException {
        Test test = new Test();
        System.out.println(5 + test.getExample());
    }

    private static void arrayIndexOut() throws ArrayIndexOutOfBoundsException {
        int[] array = new int[10];
        int a = array[11];
    }

    /**
     * 2.	Написать код, который создаст, а затем отловит ArrayIndexOutOfBoundsException.
     */
    private static void task2() {
        try {
            arrayIndexOut();
        } catch (ArrayIndexOutOfBoundsException aiout) {
            System.out.println("Такого индекса не существует");
        }
    }

    /**
     * 3 Создать собственный класс-исключение - наследник класса Exception.
     * Создать метод, выбрасывающий это исключение.
     * Вызвать этот метод и отловить исключение. Вывести stacktrace в консоль.
     */

    private static void task3() {

        try {
            printInfo();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    private static void printInfo() throws MyException {
        System.out.println("Мое первое исключение!");
        throw new MyException();
    }

    /**
     * 4.	Повторить предыдущее упражнение, но наследуя свой класс от класса RuntimeException.
     * Добавить вконструктор своего класса возможность указания сообщения.
     */

    private static void task4() {
        try {
            example("Catch MyException");
        } catch (MyRunTimeException e) {
            e.printStackTrace();
        }
    }

    public static void example(String s) throws MyRunTimeException {

        throw new MyRunTimeException(s);
    }

    /**
     * 5. Бросить одно из существующих в JDK исключений, отловить его и выбросить своё собственное,указав в качестве причины отловленное.
     */
    private static void task5() {
        try {
            jDKException();
        } catch (NoSuchFieldException e) {
            example("because catch NoSuchFieldException");
        }
    }

    public static void jDKException() throws NoSuchFieldException {
        throw new NoSuchFieldException();
    }

    /**
     * 6.Cоздать метод случайным образом выбрасывающий одно из 3-х видов исключений.
     * Вызвать этот метод в блоке try-catch, отлавливающем любое из 3-х.
     */
    private static void task6() {
        try {
            randomExeption();
        } catch (NegativeArraySizeException naz) {
            System.out.println("First catch");
        } catch (NumberFormatException nfe) {
            System.out.println("Second catch");
        } catch (ClassCastException cce) {
            System.out.println("Third catch");
        }
    }

    private static void randomExeption() {
        int r = (int) (Math.random() * 3 + 1);
        switch (r) {
            case 1:
                throw new NegativeArraySizeException();
            case 2:
                throw new NumberFormatException();
            case 3:
                throw new ClassCastException();
        }
    }

    /**
     * 7.	Написать метод, который в 50% случаев бросает исключение.
     * Вызвать этот метод в конструкции try-catch-finally. Протестировать работу блока finally.
     */
    private static void task7() {
        try {
            maybeException();
        }
        catch (NoSuchElementException excep){
            System.out.println("Catch Exception!");
            excep.printStackTrace();
        }
        finally {
            System.out.println("Это сообщение выводится в любом случае");
        }
    }

    private static void maybeException() throws NoSuchElementException {
        int r = (int) (Math.random() * 2);
        if (r==0) {
            throw new NoSuchElementException();
        }
    }



}
