package com.lectures.lecture7;

public abstract class Shape implements GetSquare { // абстрактный класс Фигура
    int sideA;
    int sideB;
    int sideC;
    int sideD;
    int height;
    int radius;

    public int getSideA() {
        return sideA;
    }
    public int getSideB() {
        return sideB;
    }
    public int getSideC() {
        return sideB;
    }
    public int getSideD() {
        return sideD;
    }
    public int getHeight() {
        return height;
    }
    public int getRadius() {
        return radius;
    }

    public void setSideA(int sideA) {
        this.sideA = sideA;
    }

    public void setSideB(int sideB) {
        this.sideB = sideB;
    }

    public void setSideC(int sideC) {
        this.sideC = sideC;
    }

    public void setSideD(int sideD) {
        this.sideD = sideD;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    // метод расчета площади фигуры
    public abstract double square();



// метод определяющий равенство площади заданной фигуры и текущей
    public boolean equalSquare(Shape shape){

        if (this.square() == shape.square()) {
            return true;
        }
        return false;
    }
}
