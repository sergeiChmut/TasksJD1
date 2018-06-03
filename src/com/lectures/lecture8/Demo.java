package com.lectures.lecture8;

import java.util.Objects;
@Deprecated
public class Demo {
    private String name;
    public int id;
    double summa;

    public static void main(String[] args) {
        ClassAnalyzer.analyzeClass(Demo.class);
    }
    public Demo() {
    }
    @Transaction
    public static void printHello() {
        System.out.println("Hello World!!!!");
    }


    public Demo(String name) {
        this.name = name;
    }

    public Demo(int id, double summa) {
        this.id = id;
        this.summa = summa;
    }


    public Demo(double summa) {
        this.summa = summa;
    }

    public void hi() {
        System.out.println("Hi");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Deprecated
    void demo() {
        System.out.println("TEST!");
    }

    public double getSumma() {
        return summa;
    }

    public void setSumma(double summa) {
        this.summa = summa;
    }

    private void calculate() {
        
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Demo demo = (Demo) o;
        return id == demo.id &&
                Double.compare(demo.summa, summa) == 0 &&
                Objects.equals(name, demo.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, id, summa);
    }

    @Override
    public String toString() {
        return "Demo{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", summa=" + summa +
                '}';
    }
    
    
}
