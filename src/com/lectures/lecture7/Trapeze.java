package com.lectures.lecture7;

public class Trapeze extends Shape implements HeightCalculation {
    public Trapeze(int sideA, int sideB, int sideC, int sideD) {
        this.sideA=sideA;
        this.sideB=sideB;
        this.sideC=sideC;
        this.sideD=sideD;

    }

    @Override
    public double square() {
        return (sideA+sideB)*heightCalculation();
    }

    @Override
    public double heightCalculation() {
        return (Math.sqrt((Math.pow(sideC,2))-((Math.pow(sideA-sideB,2)+Math.pow(sideC,2)-Math.pow(sideD,2))/(2*(sideA-sideB)))));
    }
    public void getSquare() {

        System.out.println(toString());
        System.out.println("Площадь S = "+square());

    }

    @Override
    public String toString() {
        return "Trapeze{" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                ", sideC=" + sideC +
                ", sideD=" + sideD +
                '}';
    }
}
