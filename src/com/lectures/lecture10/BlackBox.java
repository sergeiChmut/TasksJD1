package com.lectures.lecture10;

import java.util.*;

public class BlackBox {
    private TreeSet<Integer> blackBox = new TreeSet<>();

    public void push(Integer in) {
        blackBox.add(in);
    }

    public Integer numOfMin(int number) {
        if (number > blackBox.size()) {
            System.out.println("Ошибка: Номер К-ого минимального числа больше числа элементов!");
            return null;
        }
        Iterator iterator = blackBox.iterator();
        for (int i=1;i<=blackBox.size();i++) {
            iterator.next();
            if (i == number-1) {
                return (int)iterator.next();
            }
        }
        return (int)iterator.next();
    }

    public Integer numOfMax(int number) {
        if (number > blackBox.size()) {
            System.out.println("Ошибка: Номер N-ого максимального числа больше числа элементов!");
            return null;
        }
        Iterator iterator = blackBox.iterator();
        for (int i=1;i<=blackBox.size();i++) {
            iterator.next();
            if (i == blackBox.size()-number) {
                return (int)iterator.next();
            }
        }
        return (int)iterator.next();
    }
    public void getBlackBox() {
        System.out.println("");
        for (Integer list:blackBox) {
            System.out.print(list+"  ");
        }
    }

}
