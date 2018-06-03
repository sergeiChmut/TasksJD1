package com.lectures.lecture10;

import java.util.*;



public class Test {
    public static void main(String[] args) {

        task1();
        task2();
        task3();
        task4();
    }


    /**
     * 1. Написать метод countUnique, который принимает целочисленный списк в качестве параметра
     *  * и возвращает количество уникальных целых чисел в этом списке.
     *  * При получении пустого списка метод должен возвращать 0.
     *  * Пример:
     *  *
     *  * [3, 7, 3, -1, 2, 3, 7, 2, 15, 15] вернёт 5.
     */
    public static void task1() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 8; i++) {
            list.add((int) (Math.random() * 10) + 1);
        }
        System.out.println("Целочисленный список :");
        ListIterator<Integer> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + "  ");
        }
        System.out.println("\nКоличество уникальных элементов : "+CollectionUtils.countUnique(list));
    }


    /**
     * 2. Написать метод isUnique, который принимает Map<String, String> и возвращает true,
     *  * если два различных ключа не соответствуют двум одинаковым значениям.
     *  * Например, в данном случае вернётся true:
     *  *
     *  * {Marty=Stepp, Stuart=Reges, Jessica=Miller, Amanda=Camp, Hal=Perkins}
     *  *
     *  * Авданном false:
     *  *
     *  * {Kendrick=Perkins, Stuart=Reges, Jessica=Miller, Bruce=Reges, Hal=Perkins} 
     *
     */
    public static void task2() {
        HashMap<String,String> map = new HashMap<>();
        map.put("Kendrick", "Perkins");
        map.put("Stuart", "Reges");
        map.put("Jessica", "Miller");
        map.put("Bruce", "Reges");
        map.put("Hal", "Perkins");
        for (Map.Entry entry:map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        System.out.println("Is Unique ? "+CollectionUtils.isUnique(map));
    }
    /**
     3. Сложить два многочлена заданной степени,
     * если коэффициенты многочленов хранятся в двух объектах HashMap в виде:
     * Ключ: номер степени
     * Значение: значение множителя
     *
     * Вывести результирующий многочлен в виде строки: ax^6 + bx^4 + cx^3 + dx + 8*
     */
    public static void task3() {
        LinkedHashMap<Integer,Integer> map1 = new LinkedHashMap<>();
        LinkedHashMap<Integer,Integer> map2 = new LinkedHashMap<>();
        int size=7;
        for(int i=1;i<=size;i++) {
            int k1=(int)((Math.random()*20)-10);
            int k2=(int)(Math.random()*10);
            map1.put(size-i,k1);
            map2.put(size-i,k2);
        }
        System.out.println("Первый многочлен : ");
        CollectionUtils.printPolynomial(map1);
        System.out.println("Второй многочлен : ");
        CollectionUtils.printPolynomial(map2);
        LinkedHashMap<Integer,Integer> summa = new LinkedHashMap<>();
        for (Map.Entry entry1:map1.entrySet()) {
            for (Map.Entry entry2:map2.entrySet()) {
                if (entry1.getKey() == entry2.getKey()) {
                    summa.put((int)entry1.getKey(), (((int)entry1.getValue()) + ((int)entry2.getValue())));
                }
            }
          
        }
        System.out.println("Сумма многочленов : ");
        CollectionUtils.printPolynomial(summa);
    }

    /**
     *4. Реализовать структуру «Черный ящик» хранящую целые числа.
     * Структура должна поддерживать операции добавления числа и возвращение К-го
     * по минимальности числа и N-ного по максимальности элемента из ящика.
     */

    public static void task4(){
        BlackBox blackBox= new BlackBox();
        int size=9;
        System.out.println("Элементы, внесенные в BlackBox : ");
        for(int i=0;i<=size;i++) {
            int element = (int) ((Math.random() * 20) - 10);
            System.out.print(element+"  ");
            blackBox.push(element);
        }
        //blackBox.getBlackBox();
        Scanner in = new Scanner(System.in);
        System.out.println("\nВведите число К-ого минимального числа");
        int numMin=in.nextInt();
        System.out.println(blackBox.numOfMin(numMin));
        System.out.println("\nВведите число N-ого максимального числа");
        int numMax=in.nextInt();
        System.out.println(blackBox.numOfMax(numMax));

    }
}
