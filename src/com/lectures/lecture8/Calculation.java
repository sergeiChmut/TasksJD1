package com.lectures.lecture8;

public class Calculation <T extends Number> {
    private T value1;
    private T value2;

    public Calculation(T value1, T value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public T getValue1() {
        return value1;
    }

    public T getValue2() {
        return value2;
    }
    public static void calculate (Calculation calculation){

        if ((calculation.getValue1() instanceof Integer) && (calculation.getValue2() instanceof Integer)) {
            Integer x = (Integer) calculation.getValue1();
            Integer y = (Integer) calculation.getValue2();
            System.out.println("x + y = " + (x + y));
            System.out.println("x - y = " + (x - y));
            System.out.println("x * y = " + x * y);
            System.out.println("x / y = " + x / y);
        } else {
            Double x = (Double) calculation.getValue1();
            Double y = (Double) calculation.getValue2();
            System.out.println("x + y = " + (x + y));
            System.out.println("x - y = " + (x - y));
            System.out.println("x * y = " + x * y);
            System.out.println("x / y = " + x / y);
        }
    }
}
