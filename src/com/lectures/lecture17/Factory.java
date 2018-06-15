package com.lectures.lecture17;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Factory {
    private static final List<String> DETAILS = Arrays.asList("Голова", "Тело", "Левая рука", "Правая рука", "Левая нога", "Правая нога",
            "CPU", "RAM", "HDD");
    public LinkedList<String> detailsForDay;
    public boolean end = false;
    private final static int COUNT_DETAILS_FOR_DAY = 4;
    private final static int COUNT_OF_DAY = 100;
    private final static int LENGHT_OF_DAY_MS = 100;

    public LinkedList<String> getDetails(int countDetToGet, String name) throws InterruptedException {
        synchronized (this) {
            LinkedList<String> details = new LinkedList<>();
            while ((detailsForDay.size() != 0) && (countDetToGet != 0)) {
                details.addLast(detailsForDay.removeLast());
                countDetToGet--;
                Thread.sleep(30);
            }
            return details;
        }
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
        factory.setEnd(true);
    }
}
