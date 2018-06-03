package com.lectures.lecture9;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class lecture9 {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
    }

    /**
     * 1.	Задание. Создать список оценок учеников с помощью ListIterator, заполнить случайными оценками.
     * Удалить неудовлетворительные оценки из списка.
     */

    private static void task1() {
        ArrayList<Integer> markOfSchoolchild = new ArrayList<Integer>();
        for (int i = 0; i < 24; i++) {
            markOfSchoolchild.add((int) (Math.random() * 10) + 1);
        }
        System.out.println("Список оценок учеников :");
        ListIterator<Integer> listIterator = markOfSchoolchild.listIterator();
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + "  ");
        }
        while (listIterator.hasPrevious()) {
            if (listIterator.previous() < 4) {
                listIterator.remove();
            }
        }
        System.out.println("\nБез неудовлетворительных оценок :");
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + "  ");
        }
    }

    /**
     * 2.	Задание. Создать список оценок учеников с помощью ListIterator, заполнить случайными оценками.
     * Найти самую высокую оценку с использованием итератора.
     */
    private static void task2() {
        ArrayList<Integer> markOfSchoolchild = new ArrayList<Integer>();
        int mark = 0;
        for (int i = 0; i < 24; i++) {
            markOfSchoolchild.add((int) (Math.random() * 10) + 1);
        }
        System.out.println("\nНовый список оценок учеников :");
        ListIterator<Integer> listIterator = markOfSchoolchild.listIterator();
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + "  ");
        }
        while (listIterator.hasPrevious()) {
            if (listIterator.previous() > mark) {
                mark = listIterator.next();
            }
        }
        System.out.println("\nМаксимальная оценка :" + mark);

    }

    /**
     * 3.	Вывести учеников из списка в обратном порядке. (2 варианта решения).
     */
    private static void task3() {
        ArrayList<Integer> markOfSchoolchild = new ArrayList<Integer>();
        int mark = 0;
        for (int i = 0; i < 24; i++) {
            markOfSchoolchild.add((int) (Math.random() * 10) + 1);
        }
        System.out.println("\nНовый список оценок учеников :");
        ListIterator<Integer> listIterator = markOfSchoolchild.listIterator();
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + "  ");
        }
        Stack stack = new Stack();
        for (int i = 0; i < markOfSchoolchild.size(); i++) {
            stack.push(markOfSchoolchild.get(i));
        }
        System.out.println("\nВ обратном порядке :");
        for (int i = 0; i < markOfSchoolchild.size(); i++) {
            System.out.print(stack.pop()+ "  ");
        }
        System.out.println("\nЕще раз в обратном :");
        ListIterator<Integer> listIterator1 = markOfSchoolchild.listIterator();
        while (listIterator.hasNext()) {
        }
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous()+"  ");
        }

    }

    /**
     * 4.	Ввести с консоли число, занести его цифры в стек. Стек – самостоятельно спроектированный класс,
     * * поддерживающий 3 операции:
     * * •	Задать размер стека.
     * * •	Внести цифру в стек.
     * * •	Извлечь цифру из стека.
     * * Вывести число, у которого цифры идут в обратном порядке.
     */
    private static void task4() {
        Scanner in = new Scanner(System.in);
        System.out.println("\nВведите число : ");
        String number = in.nextLine();
        Stack stack = new Stack();
        for (int i = 0; i < number.length(); i++) {
            stack.push(number.substring(i, i + 1));
        }
        for (int i = 0; i < number.length(); i++) {
            System.out.print(stack.pop());
        }

    }
}
