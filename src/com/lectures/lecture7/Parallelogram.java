package com.lectures.lecture7;

public class Parallelogram extends Shape {
    @Override
    public double square() {
        return height * sideB;
    }

    public void getSquare() {

        System.out.println(toString());
        System.out.println("Площадь S = " + square());

    }

    @Override
    public String toString() {
        return "Parallelogram{" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                ", sideC=" + sideC +
                ", sideD=" + sideD +
                ", height=" + height +
                '}';
    }
}