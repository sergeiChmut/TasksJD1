package com.lectures.lecture7;

public class Rectangle extends Shape {
    Rectangle (int sideA,int sideB, int sideC, int sideD) {
        this.sideA=sideA;this.sideB=sideB;this.sideC=sideC;this.sideD=sideD;
    }

    @Override
    public double square() {
        if ((sideA == sideC)||(sideA==sideD)) {
            return sideA * sideB;
        } else {
            return sideA * sideC;
        }
    }

    public void getSquare() {

        System.out.println(toString());
        System.out.println("Площадь S = "+square());

    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                ", sideC=" + sideC +
                ", sideD=" + sideD +
                '}';
    }
}
