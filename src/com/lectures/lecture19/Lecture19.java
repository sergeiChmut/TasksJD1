package com.lectures.lecture19;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 1. Написать программу, бесконечно считывающую пользовательские числа из консоли.
 * Эти числа представляют собой количество секунд.
 * При каждом вводе числа, должна создаваться задача, которая засыпает на введённое число секунд и затем выводит "Я спал N секунд".
 * Однако нужно сделать так, чтобы все задачи выполнялись в одном и том же потоке в порядке ввода.
 * Т.е. в программе есть 2 потока: главный и поток для выполнения всех задач по очереди.
 * При вводе -1 программа должна завершать свою работу.
 * <p>
 * <p>
 * 2*. Задан массив случайных целых чисел (от 1 до 300) случайной длины (до 1 млн элементов).
 * Найти максимальный элемент в массиве двумя способами: в одном потоке и используя 10 потоков.
 * Сравнить затраченное в обоих случаях время.
 */
public class Lecture19 {
    public static void main(String[] args) {
        task1();
        task2();
//        task3();

    }

//    private static void task3() {
//        int taskProjectNumber =0;
//        for(int i = 0; i<8; i++){
//            taskProjectNumber = (int)(Math.random()*16+1);
//
//        }
//        System.out.println(taskProjectNumber);
//    }


    /**
     * 1. Написать программу, бесконечно считывающую пользовательские числа из консоли.
     * Эти числа представляют собой количество секунд.
     * При каждом вводе числа, должна создаваться задача, которая засыпает на введённое число секунд и затем выводит "Я спал N секунд".
     * Однако нужно сделать так, чтобы все задачи выполнялись в одном и том же потоке в порядке ввода.
     * Т.е. в программе есть 2 потока: главный и поток для выполнения всех задач по очереди.
     * При вводе -1 программа должна завершать свою работу.
     */
    private static void task1() {
        Scanner in = new Scanner(System.in);
        ExecutorService service = Executors.newCachedThreadPool();
        int countOfSec = 0;
        while (countOfSec != -1) {
            countOfSec = in.nextInt();
            if (countOfSec != -1) {
                int finalCountOfSec = countOfSec;
                service.submit(new Runnable() {
                    public void run() {
                        try {
                            TimeUnit.SECONDS.sleep(finalCountOfSec);
                        } catch (InterruptedException e) {
//                            e.printStackTrace();
                        }
                        System.out.printf("Я спал %d секунд\n", finalCountOfSec);

                    }
                });
            } else {
                service.shutdownNow();
            }

        }
    }

    /**
     * 2*. Задан массив случайных целых чисел (от 1 до 300) случайной длины (до 1 млн элементов).
     * Найти максимальный элемент в массиве двумя способами: в одном потоке и используя 10 потоков.
     * Сравнить затраченное в обоих случаях время.
     */
    private static void task2() {
        ExecutorService service = Executors.newFixedThreadPool(10);
        int size = (int) (Math.random() * 700000 + 500000);
        System.out.println("Размер массива "+size);
        int array[] = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 300 + 1);
//            System.out.print(element+" ");
        }
        ArrayList<int[]> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int[] arrayTemp = new int[array.length / 10];
            int arrayTemp10[] = new int[array.length - (array.length / 10) * 9];
            if (i != 9) {
                System.arraycopy(array, i, arrayTemp, 0, array.length / 10);
                arrayList.add(i, arrayTemp);
//                System.out.println(arrayTemp.length);
            } else {
                System.arraycopy(array, i, arrayTemp10, 0, array.length - (array.length / 10) * 9);
                arrayList.add(i, arrayTemp10);
//                System.out.println(arrayTemp10.length);
            }
        }
        int max = array[0];
        long startTimeOneThread = System.nanoTime(); // стартуем определение максимального элемента используя один поток
        for (int element : array) {
            if (element > max) {
                max = element;
            }
        }
        System.out.println("Максимальный элемент " + max);
        long endTimeOneThread = System.nanoTime();
        int[] max10 = new int[10];
        int max2 = array[0];
        long startTimeTenThread = System.nanoTime(); // стартуем определение максимального элемента используя десять потоков
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            service.submit(new Runnable() {
                @Override
                public void run() {
                    for (int element : arrayList.get(finalI)) {
                        if (element > max10[finalI]) {
                            max10[finalI] = element;
                        }
                    }
                }
            });
        }
        service.shutdown();
        for (int element : max10) {
            if (element > max2) {
                max2 = element;
            }
        }
        System.out.println("Максимальный элемент " + max2);
        long endTimeTenThread = System.nanoTime();
//        System.out.printf("%-25s %10d\n", "Время с одним потоком:", (endTimeOneThread - startTimeOneThread));
//        System.out.printf("%-25s %10d\n", "Время с десятью потоками:", (endTimeTenThread - startTimeTenThread));

        ArrayList<int[]> arrayList100 = new ArrayList<>(); // Готовим под сто потоков))
        for (int i = 0; i < 100; i++) {
            int[] arrayTemp = new int[array.length / 100];
            int arrayTemp10[] = new int[array.length - (array.length / 100) * 99];
            if (i != 99) {
                System.arraycopy(array, i, arrayTemp, 0, array.length / 100);
                arrayList.add(i, arrayTemp);
            } else {
                System.arraycopy(array, i, arrayTemp10, 0, array.length - (array.length / 100) * 99);
                arrayList.add(i, arrayTemp10);
            }
        }
        ExecutorService service2 = Executors.newFixedThreadPool(100);
        int[] max100 = new int[100];
        int max3 = array[0];
        long startTimeHundredThread = System.nanoTime(); // стартуем определение максимального элемента используя сто потоков
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            service2.submit(new Runnable() {
                @Override
                public void run() {
                    for (int element : arrayList.get(finalI)) {
                        if (element > max100[finalI]) {
                            max100[finalI] = element;
                        }
                    }
                }
            });
        }
        service2.shutdown();
        for (int element : max100) {
            if (element > max3) {
                max3 = element;
            }
        }
        System.out.println("Максимальный элемент " + max3);
        long endTimeHundredThread = System.nanoTime();
        System.out.printf("%-25s %10d\n", "Время с одним потоком:", (endTimeOneThread - startTimeOneThread));
        System.out.printf("%-25s %10d\n", "Время с десятью потоками:", (endTimeTenThread - startTimeTenThread));
        System.out.printf("%-25s %10d\n", "Время со ста потоками:", (endTimeHundredThread - startTimeHundredThread));

    }
}
