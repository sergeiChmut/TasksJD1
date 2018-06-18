package com.lectures.lecture17;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Factory {
    private static final List<String> DETAILS = Arrays.asList("Голова", "Тело", "Левая рука", "Правая рука", "Левая нога", "Правая нога",
            "CPU", "RAM", "HDD");
    private LinkedList<String> detailsForDay;
    private boolean competitionEnd = false; // Окончание соревнования
    private static final int COUNT_DETAILS_FOR_DAY = 4;
    private static final int COUNT_OF_DAY = 100;
    private static final int LENGHT_OF_DAY_MS = 100;
    final Lock factoryLock = new ReentrantLock();


    LinkedList<String> getDetails(int countDetToGet, String name) throws InterruptedException {
//        synchronized (this) {
        factoryLock.lock();
        try {
            LinkedList<String> details = new LinkedList<>();
//            System.out.println(detailsForDay.size());
            while ((detailsForDay.size() != 0) && (countDetToGet != 0)) {
                details.addLast(detailsForDay.removeLast());
                countDetToGet--;
            }
            Thread.sleep(55);
            return details;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            factoryLock.unlock();
        }
        return null;
    }

    private void newDay() {
        for (int i = 0; i < COUNT_DETAILS_FOR_DAY; i++) {
            int indexRandomDetail = (int) (Math.random() * 9);
            detailsForDay.addLast(DETAILS.get(indexRandomDetail));
        }
    }

    private void firstDay() {
        detailsForDay = new LinkedList<String>();
        for (int i = 0; i < 20; i++) {
            int indexRandomDetail = (int) (Math.random() * 9);
            detailsForDay.addLast(DETAILS.get(indexRandomDetail));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Factory factory = new Factory();
        factory.firstDay();
        // "Заводим" для ученых "сборщиков"  - servant
        Servant servant1 = new Servant(factory, "Помощник Первого ученого");
        Servant servant2 = new Servant(factory, "Помощник Второго ученого");
        new Thread(servant1).start();
        new Thread(servant2).start();
        for (int i = 0; i < COUNT_OF_DAY; i++) {
            Thread.sleep(LENGHT_OF_DAY_MS);
            factory.newDay();
        }
        factory.setCompetitionEnd(true);
        Thread.sleep(200);
        if (servant1.getCountRobot() == servant2.getCountRobot()) {
            System.out.println("\nНичья!  Победила дружба!");
        } else if (servant1.getCountRobot() > servant2.getCountRobot()) {
            System.out.println("\n Победил Первый Ученый ! ");
        } else {
            System.out.println("\n Победил Второй Ученый ! ");
        }

    }
}
