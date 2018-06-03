package com.lectures;

import java.util.Scanner;

public class Lecture2Tasks {
    public static void main(String[] args) {
        System.out.println("Start lecture2 task:");
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
        task9();
        task10();

    }

    /**
     * 1. Напишите программу, которая печатает массив сначала в обычном порядке, затем в обратном.
     */
    private static void task1() {
        int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
        System.out.println("  ");
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + "  ");
        }
    }

    /**
     * 2. Напишите программу, заносящую в массив первые 100 натуральных чисел, делящихся на 13 или на 17, и печатающую его.
     */
    private static void task2() {
        int arrayOfNum[] = new int[100];
        int i = 0;
        int number = 13;
        System.out.println("\nЗадание №2:");
        while (i < 100) {
            if (number % 13 == 0 || number % 17 == 0) {
                arrayOfNum[i] = number;
                i++;
            }
            number++;
        }
        for (i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (arrayOfNum[i * 10 + j] < 100) {
                    System.out.print(" ");
                }
                System.out.print(arrayOfNum[i * 10 + j] + "  ");
            }
            System.out.print("\n");
        }
    }

    /**
     * 3. Определить сумму элементов целочисленного массива, расположенных между минимальным и максимальным значениями.
     */
    private static void task3() {
        int array[] = {10, 2, 524, 41, 5, 3, 6, 0, 1, 89};
        int maxNum = 0;
        int minNum = 0;
        int summaMinMax = 0;
        System.out.println("\nЗадание №3:\nЗаданный массив:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
            if (array[i] < array[minNum]) {
                minNum = i;
            }
            if (array[i] > array[maxNum]) {
                maxNum = i;
            }
        }
        if (minNum < maxNum) {
            for (int i = minNum + 1; i < maxNum; i++) {
                summaMinMax += array[i];
            }
        } else {
            for (int i = maxNum + 1; i < minNum; i++) {
                summaMinMax += array[i];
            }
        }
        System.out.println("Сумма элементов между минимальным и максимальным: " + summaMinMax);
    }


    /**
     * 4. Создать массив из 4 случайных целых чисел из отрезка [10;99], вывести его на экран в строку.
     * Определить и вывести на экран сообщение о том, является ли массив строго возрастающей последовательностью.
     */

    private static void task4() {
        int array[] = new int[4];
        int mark = 1;
        System.out.println("\nЗадание №4:\nСлучайный массив из отрезка 10-99:");
        for (int i = 0; i < array.length; i++) {
            array[i] = (10 + (int) ((Math.random() * 89)));
            System.out.print(array[i] + " ");
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] < array[i]) {
                System.out.println("Массив не является строго возрастающей прогрессией");
                mark = 0;
                break;
            }
        }
        if (mark == 1) {
            System.out.println("Массив является строго возрастающей прогрессией!");
        }
    }

    /**
     * 5. Создать двухмерный квадратный массив, и заполнить его "бабочкой", т.е. таким образом:
     * <p>
     * 1 1 1 1 1
     * 0 1 1 1 0
     * 0 0 1 0 0
     * 0 1 1 1 0
     * 1 1 1 1 1
     * <p>
     * Вывести его на экран, заменив 1 символом *, а 0 - пробелом.
     */
    private static void task5() {
        int size = 10;
        char array[][] = new char[size][size];
        System.out.println("\nЗадание №5:\nМассив " + size + " х " + size + " бабочкой:");
        int shift = -1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if ((j <= shift) || (j >= array[0].length - shift - 1)) {
                    array[i][j] = '0';
                } else {
                    array[i][j] = '1';
                }
            }
            if (i < array.length / 2) {
                shift++;
            } else shift--;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + "  ");
            }
            System.out.println("");
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == '1') {
                    array[i][j] = '*';
                } else array[i][j] = ' ';
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + "  ");
            }
            System.out.println("");
        }
    }

    /**
     * 6. Написать метод equals, который определяет, равны ли между собой соответствующие элементы
     * 2-х двумерных массивов.
     */
    private static void task6() {
        int arrayOne[][] = {{0, 2, 0}, {1, 2, 3}};
        int arrayTwo[][] = {{1, 2, 0}, {1, 2, 3}};
        System.out.println("\nЗадание №6:\nСравнение элементов 2-х массивов:");
        for (int i = 0; i < arrayOne.length; i++) {
            for (int j = 0; j < arrayOne[0].length; j++) {
                System.out.print(arrayOne[i][j] + "  ");
            }
            System.out.println("");
        }
        System.out.println("----------------------");
        for (int i = 0; i < arrayTwo.length; i++) {
            for (int j = 0; j < arrayTwo[0].length; j++) {
                System.out.print(arrayTwo[i][j] + "  ");
            }
            System.out.println("");
        }
        if (equals(arrayOne, arrayTwo)) {
            System.out.println("Массивы равны");
        } else {
            System.out.println("Массивы не равны");
        }

    }

    /**
     * Метод определяющий равенство 2-х элементов массивов
     */
    private static boolean equals(int[][] a1, int[][] a2) {
        if ((a1.length == a2.length) && (a1[0].length == a2[0].length)) {
            for (int i = 0; i < a1.length; i++) {
                for (int j = 0; j < a1[0].length; j++) {
                    if (a1[i][j] != a2[i][j]) {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }
        return true;
    }

    /**
     * 7. Написать программу, эмулирующую выдачу случайной карты из колоды в 52 карты.
     * Вывести результат в формате "Карта of Масть". Например, "AceofSpades".
     * Валет - Jack, Дама - Queen, Король - King, Туз - Ace, Червы - Hearts, Пики - Spades, Трефы - Clubs, Бубны - Diamonds
     */
    private static void task7() {
        String[] arrayOfName = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] arrayOfSuit = {"Heards", "Spades", "Clubs", "Diamonds"};
        String[] arrayOfCards = new String[52];
        for (int i = 0; i < arrayOfName.length; i++) {
            for (int j = 0; j < arrayOfSuit.length; j++) {
                arrayOfCards[i * 4 + j] = arrayOfName[i] + " Of " + arrayOfSuit[j];
            }
        }
        int numberCard = (int) ((Math.random() * 51));
        System.out.println("Задание №7:\nСлучайная карта из колоды:\n" + arrayOfCards[numberCard]);

    }

    /**
     * 8.* Написать программу, перемешивающую и печатающую список карт в колоде.
     * Воспользоваться результатом предыдущей задачи.
     */
    private static void task8() {
        String[] arrayOfName = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] arrayOfSuit = {"Heards", "Spades", "Clubs", "Diamonds"};
        String[] arrayOfCards = new String[52];
        String temp = new String();
        int randomNum = 0;
        for (int i = 0; i < arrayOfName.length; i++) {
            for (int j = 0; j < arrayOfSuit.length; j++) {
                arrayOfCards[i * 4 + j] = arrayOfName[i] + " Of " + arrayOfSuit[j];
            }
        }
        for (int i = 0; i < arrayOfCards.length; i++) {
            randomNum = (int) (Math.random() * 51);
            temp = arrayOfCards[i];
            arrayOfCards[i] = arrayOfCards[randomNum];
            arrayOfCards[randomNum] = temp;
        }
        System.out.println("Перемешаная колода карт:");
        for (int i = 0; i < arrayOfCards.length; i++) {
            System.out.println(arrayOfCards[i]);
        }

    }

    /**
     * 9. Имеется целое число, определить является ли это число простым, т.е. делится без остатка только на 1 и себя.
     */
    private static void task9() {
        long number = 20011103;
        long mark=0;
        //int i = 2;
        for (long i=2;i<number/2;i++){
            if (number%i == 0) {mark=i;
                System.out.println(mark);break;}
        }

        //while (!(number % i == 0) && i < number) {
        //    i++;
        //}
        if (mark == number/2) {
            System.out.println("Число " + number + " является простым!");
        } else {
            System.out.println("Число " + number + " не является простым");
        }
    }

    /**
     * 10. Написать алгоритм расчета факториала , используя циклы (for и while).
     */
    private static void task10() {
        int factorialFor = 1;
        int factorialWhile = 1;
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число для расчета факториала (<13):");
        int number = in.nextInt();
        for (int i = 1; i <= number; i++) {
            factorialFor = factorialFor * i;
        }
        int i = 1;
        while (i <= number) {
            factorialWhile = factorialWhile * i;
            i++;
        }
        System.out.println("Факториал равен:\nчерез For " + factorialFor + "\nчерез While:" + factorialWhile);

    }


}
