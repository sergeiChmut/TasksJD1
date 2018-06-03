package com.lectures.lecture7;

public class Circle extends Shape {
    public Circle() {
    }

    public Circle(int i) {
        this.radius=i;
    }


    public void setRadius(int radius) {
        this.radius=radius;
    }

    @Override
    public double square() {
        return Math.PI*Math.pow(radius,2);
    }
    public void getSquare() {

        System.out.println(toString());
        System.out.println("Площадь S = "+square());

    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
