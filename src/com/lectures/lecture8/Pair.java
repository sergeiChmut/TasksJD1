package com.lectures.lecture8;

import static com.lectures.lecture8.Calculation.calculate;

public class Pair<K, V> {
    private K item1;
    private V item2;

    public Pair() {
    }

    public Pair(K item1, V item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    public void setItem1(K item1) {
        this.item1 = item1;
    }

    public void setItem2(V item2) {
        this.item2 = item2;
    }

    public K getItem1() {
        return item1;
    }

    public V getItem2() {
        return item2;
    }

    public static void main(String[] args) {
        Pair<String, Integer> test = new Pair<>();
        test.setItem1("Demo");
        test.setItem2(25);
        System.out.println("Before :" + test.toString());
        PairUtils.swap(test);
        System.out.println("After :" + test.toString());
        Calculation<Number> test2 = new Calculation(10, 25);
        Calculation<Number> test3 = new Calculation(10.5, 25.89);
        calculate(test2);
        calculate(test3);


    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "item1 = " + item1 + ",\t" + item1.getClass().getTypeName() +
                ",\t item2 = " + item2 + ",\t" + item2.getClass().getTypeName() +
                '}';
    }
}
