package com.lectures.lecture17;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.LinkedList;




@AllArgsConstructor
@Data
public class Servant implements Runnable {
    Factory factory;
    public int countDetToGet;
    private String name;
    private LinkedHashSet<String> details;
    public LinkedList<String> detailsForDay;
    private int countDetails;
    private int countRobot;

    public Servant(Factory factory, String name) {
        this.factory = factory;
        this.name = name;
    }

    private int robot(Factory factory) throws InterruptedException {
        countDetToGet = (int) (Math.random() * 4 + 1);
        detailsForDay = factory.getDetails(countDetToGet, name);
        for (int i = 0; i < detailsForDay.size(); i++) {
            details.add(detailsForDay.removeFirst());
            countDetails++;
        }
        if (details.size() == 9) {
            countRobot++;
            System.out.printf("\nУра! %s собрал для него робота! Всего: %d", name, countRobot);
            details.clear();
        }
        return countRobot;
    }


    @Override
    public void run() {
        details = new LinkedHashSet<>();
        countRobot = 0;
        System.out.printf("\n%s приступил к сбору", name);
        while (!factory.end) {
            try {
                countRobot = robot(factory);
//                System.out.println(countDetails + name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("\n %s и ученый закончили и собрали %d роботов!!! (было собрано %d деталей)", name, countRobot, countDetails);
    }
}
