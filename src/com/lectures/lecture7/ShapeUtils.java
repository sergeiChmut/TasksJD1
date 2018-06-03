package com.lectures.lecture7;

public class ShapeUtils {

// метод на проверку является ли фигура прямоугольником
    public static boolean isRectangle(Shape shape) {
        if (shape instanceof Rectangle) {
            return true;
        }
        //int sideA=shape.getSideA();
        //int sideB=shape.getSideB();
        //int sideC=shape.getSideC();
        //int sideD=shape.getSideD();
        //int height=shape.getHeight();
        //if (((sideA==sideB)&&(sideC==sideD)&&((height==sideA)||(height==sideC)))||
          //      ((sideA==sideC)&&(sideB==sideD)&&((height==sideA)||(height==sideB)))||
           //     ((sideA==sideD)&&(sideB==sideC)&&((height==sideA)||(height==sideB)))) {
            //return true;
        //}
        return false;
    }
 // метод на проверку является ли фигура треугольником
    // является только тогда, когда любые две стороны БОЛЬШЕ третьей

    public static boolean isTriangle(Shape shape) {
        if (shape instanceof Triangle) {
            return true;
        }
        //int sideA=shape.getSideA();
        //int sideB=shape.getSideB();
        //int sideC=shape.getSideC();
        //if ((sideA<(sideB+sideC))&&(sideB<(sideA+sideC))&&(sideC<(sideA+sideB))) {
        //    return true;
        //}
        return false;
    }

}
