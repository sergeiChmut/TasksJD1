package com.lectures.lecture16;

import java.util.*;

/**
 * 1.	Дан список целых чисел. Найти среднее всех нечётных чисел, делящихся на 5.
 * <p>
 * 2.	Дан список строк. Найти количество уникальных строк длиной более 8 символов.
 * <p>
 * 3.	Дана Map<String, Integer>. Найти сумму всех значений, длина ключей которых меньше 7 символов.
 * <p>
 * 4.	Дан список целых чисел, вывести строку, представляющую собой конкатенацию строковых представлений этих чисел.
 * Пример: список {5, 2, 4, 2, 1}
 * Результирующая строка: "52421"
 * <p>
 * 5.	Дан класс Person с полями firstName, lastName, age.
 * Вывести полное имя самого старшего человека, у которого длина этого имени не превышает 15 символов.
 */

public class lecture16 {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
    }

    /**
     * 1.	Дан список целых чисел. Найти среднее всех нечётных чисел, делящихся на 5.
     */
    private static void task1() {
        List<Integer> numbers = new ArrayList<>();
        int lenght = 20;
        for (int i = 0; i < lenght; i++) {
            numbers.add(i, ((int) (Math.random() * 40)));
        }
        System.out.println("Список целых чисел : ");
        for (Integer num : numbers) {
            System.out.print(num + " ");
        }
        double averageOddDivide5 = numbers.stream()
                .filter(element -> element % 2 != 0)
                .filter(element -> element % 5 == 0)
                .mapToInt(element -> element)
                .average()
                .orElse(0);
        if (averageOddDivide5 == 0) {
            System.out.println("\nУ заданного списка нет нужных значений для нахождения среднего!");
        }else {
            System.out.println("\nСреднее всех нечетных делящихся на 5 : " + averageOddDivide5);
        }
    }

    /**
     * 2.	Дан список строк. Найти количество уникальных строк длиной более 8 символов.
     */
    private static void task2() {
        System.out.println("Task2 : ");
        List<String> anyString = Arrays.asList(("Дан список целых чисел, вывести строку, представляющую " +
                "собой конкатенацию строковых представлений этих чисел Вывести полное имя самого старшего человека, " +
                "у которого длина этого имени не превышает 15 символов").split(" +"));
        for (String list : anyString) {
//            System.out.println(list + " "  +list.length());
            System.out.println(list);
        }
        long countOfStringMore8Char = anyString.stream()
                .filter(string -> string.length() > 8)
                .count();
        System.out.println("Количество строк, длинной > 8 символов : " + countOfStringMore8Char);
    }

    /**
     * 3.	Дана Map<String, Integer>. Найти сумму всех значений, длина ключей которых меньше 7 символов.
     */
    private static void task3() {
        System.out.println("Task3 : ");
        Map <String, Integer> map= new HashMap<>();
        map.put("Michael", 33);
        map.put("Sergei", 35);
        map.put("Ann", 27);
        map.put("Katherina", 35);
        map.put("Dima", 32);
        int countAge = map.entrySet().stream()
                .filter(keys -> keys.getKey().length()<7)
                .mapToInt(Map.Entry::getValue)
                .sum();
        System.out.println(map);
        System.out.println(countAge);
    }

    /**
     * 4.	Дан список целых чисел, вывести строку, представляющую собой конкатенацию строковых представлений этих чисел.
     * Пример: список {5, 2, 4, 2, 1}
     * Результирующая строка: "52421"
     */
    private static void task4() {
        System.out.println("Task4 : ");
        List<Integer> numbers = Arrays.asList(5,2,4,2,1);
        String concatInt = numbers.stream()
                .map(element -> element.toString())
                .reduce("", (base, element) -> base + element);
        System.out.println("Список: ");
        for (Integer num: numbers) {
            System.out.print(num+",");
        }
        System.out.println("\n"+concatInt);
    }

    /**
     * 5.	Дан класс Person с полями firstName, lastName, age.
     * Вывести полное имя самого старшего человека, у которого длина этого имени не превышает 15 символов.
     */
    private static void task5() {
        System.out.println("Task5 : ");
        List<Person> people = new ArrayList<>();
        people.add(new Person("Sergei","Chmut", 33));
        people.add(new Person("Sergei","Borzdov", 30));
        people.add(new Person("Alexey","Esimchuk", 35));
        people.add(new Person("Alexandra","Kamluk", 42));
        people.add(new Person("Petr","Nikolaev", 53));
        people.add(new Person("Petr","Dmitrovievich", 55));
        people.add(new Person("Luda","Nasevich", 49));
        people.forEach(System.out::println);
        Optional<Person> findPerson = people.stream()
                .filter(person -> (person.getFirstName().length() + person.getLastName().length()) < 15)
                .max(new PersonAgeComparator());
        System.out.println("Полное имя старшего (длина имени < 15) : "+ findPerson.get().getFirstName()+" "
        + findPerson.get().getLastName());
    }
}
