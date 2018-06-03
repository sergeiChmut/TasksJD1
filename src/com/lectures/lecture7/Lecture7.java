package com.lectures.lecture7;

public class Lecture7 {             // тестирование возможностей созданных классов
    public static void main(String[] args) {
        Circle circle=new Circle(10);
        circle.getSquare();
        System.out.println("Is triangle?"+ShapeUtils.isTriangle(circle));
        Rectangle rectangle=new Rectangle(2,4,2,4);
        System.out.println("Равна ли площадь круга "+circle.toString());
        System.out.println("Площади прямоугольника "+rectangle.toString()+" ? : "+circle.equalSquare(rectangle));
        Rectangle rectangle2=new Rectangle(4,2,2,4);
        System.out.println("Равна ли площадь прямоугольника "+rectangle.toString());
        System.out.println("и прямоугольника "+rectangle2.toString()+" ? : "+rectangle2.equalSquare(rectangle2));
        rectangle.getSquare();
        System.out.println("Is rectangle?"+ShapeUtils.isRectangle(rectangle));
        rectangle2.getSquare();
        Shape parallelogram=new Parallelogram();
        parallelogram.setSideA(10);
        parallelogram.setSideB(10);
        parallelogram.setSideC(4);
        parallelogram.setSideD(4);
        parallelogram.setHeight(5);
        parallelogram.getSquare();
        Circle circle1=new Circle();
        circle1.setRadius(12);
        circle1.getSquare();
        Trapeze trapeze=new Trapeze(10,8,6,6);
        trapeze.getSquare();
        Triangle triangle=new Triangle(5,3,4);
        triangle.getSquare();
        System.out.println("Is triangle?"+ShapeUtils.isTriangle(triangle));
        System.out.println("Is rectangle?"+ShapeUtils.isRectangle(triangle));
        System.out.println("Высота H = "+triangle.heightCalculation());
    }
}
