package com.lectures.lecture7;

public class Triangle extends Shape implements HeightCalculation {

    public Triangle(int sideA, int sideB,int sideC) {
        this.sideA=sideA;
        this.sideB=sideB;
        this.sideC=sideC;
    }

    @Override
    public double square() {
       int semiperimeter = (sideA+sideB+sideC)/2;
       return Math.sqrt(semiperimeter*(semiperimeter-sideA)*(semiperimeter-sideB)*(semiperimeter-sideC));
    }


    @Override
    public String toString() {
        return "Triangle{" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                ", sideC=" + sideC +
                '}';
    }
    public void getSquare() {

        System.out.println(toString());
        System.out.println("Площадь S = "+square());

    }
    public double heightCalculation() {
        return 2*square()/sideA;
    }
}
