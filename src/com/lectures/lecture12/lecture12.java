package com.lectures.lecture12;

import java.util.*;

/**
 * 1. Написать два цикла, выполняющих многократное сложение строк, один с помощью оператора сложения и String,
 * второй с помощью StringBuilder и метода append. Сравнить скорость их выполнения.
 * <p>
 * 2. Заменить все грустные смайлы :( в строке на весёлые :)
 * <p>
 * 3. Написать функцию, принимающую 2 параметра: строку и слово - и возвращающую true, если строка начинается и заканчивается этим словом.
 * <p>
 * 4. Написать функцию, принимающую в качестве параметров имя, фамилию и отчество и возвращающую инициалы
 * в формате "Ф.И.О". Учесть, что входные параметры могут быть в любом регистре, а результирующая строка должна быть в верхнем.
 * <p>
 * 5. Подсчитать количество слов в тексте. Учесть, что слова могут разделяться несколькими пробелами.
 * <p>
 * 6. Написать функцию, заменяющую несколько последовательных одинаковых символов в строке одним.
 * <p>
 * Пример: aaabbcdeef ->abcdef
 */


public class lecture12 {
    public static void main(String[] args) {
        //task1();
        //task2();
        //task3();
        //task4();
        //task5();
        task6();
    }


    /**
     * 1. Написать два цикла, выполняющих многократное сложение строк, один с помощью оператора сложения и String,
     * второй с помощью StringBuilder и метода append. Сравнить скорость их выполнения.
     */

    public static void task1() {
        long startTime = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            long temp = System.nanoTime();
            calcString();
            System.out.println(System.nanoTime() - temp);
        }
        System.out.println(".");
        long endTime = System.nanoTime();
        long startTimeC = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            long temp = System.nanoTime();
            calcConcat();
            System.out.println(System.nanoTime() - temp);
        }
        System.out.println(".");
        long endTimeC = System.nanoTime();
        long startTimeB = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            long temp = System.nanoTime();
            calcStringBuilder();
            System.out.println(System.nanoTime() - temp);
        }
        long endTimeB = System.nanoTime();
        System.out.println("Time String+     :" + (endTime - startTime) + "\nTime StringConcat: " + (endTimeC - startTimeC) +
                "\nTime StringBuilder:" + (endTimeB - startTimeB));
    }

    public static void calcString() {
        String s1 = "";
        String s2 = "S ";
        for (int i = 0; i < 1000; i++) {
            s1 = s1 + s2;
            //System.out.println(s1);
        }
    }

    public static void calcStringBuilder() {
        String s2 = "S ";
        StringBuilder s1 = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            s1 = s1.append(s2);
            //System.out.println(s1);
        }
    }

    public static void calcConcat() {
        String s1 = "";
        String s2 = "S ";
        for (int i = 0; i < 1000; i++) {
            s1 = s1.concat(s2);
            //System.out.println(s1);
        }
    }

    /**
     * 2. Заменить все грустные смайлы :( в строке на весёлые :)
     */

    private static void task2() {
        Scanner in = new Scanner(System.in);
        System.out.println("\nВведите строку, содержащую грустные смайлы :");
        String line = in.nextLine();
        char[] lineArray = line.toCharArray();
        for (int i = 1; i < lineArray.length; i++) {
            if ((lineArray[i - 1] == ':') && (lineArray[i] == '(')) {
                lineArray[i] = ')';
            }
        }
        for (int i = 0; i < lineArray.length; i++) {
            System.out.print(lineArray[i]);
        }
    }

    /**
     * 3. Написать функцию, принимающую 2 параметра: строку и слово - и возвращающую true,
     * если строка начинается и заканчивается этим словом.
     */
    public static void task3() {
        Scanner in = new Scanner(System.in);
        System.out.println("\nВведите строку :");
        String string = in.nextLine();
        System.out.println("Введите слово для проверки :");
        String word = in.nextLine();
        System.out.println(wordInStartEndString(string, word));
    }

    public static boolean wordInStartEndString(String string, String word) {
        if ((string.indexOf(word) == 0) && ((string.indexOf(word, word.length()) == (string.length() - word.length())) ||
                (string.length() == word.length()))) {
            return true;
        }
        return false;
    }

    /**
     * 4. Написать функцию, принимающую в качестве параметров имя, фамилию и отчество и возвращающую инициалы
     * в формате "Ф.И.О". Учесть, что входные параметры могут быть в любом регистре, а результирующая строка должна быть в верхнем.
     */
    public static void task4() {
        Scanner in = new Scanner(System.in);
        System.out.println("\nВведите Имя :");
        String name = in.nextLine();
        System.out.println("Введите Фамилию :");
        String lastname = in.nextLine();
        System.out.println("Введите Отчество :");
        String thirdname = in.nextLine();
        System.out.println(initials(name, lastname, thirdname));
    }

    public static String initials(String name, String lastname, String thirdname) {
        String initialName = (name.substring(0, 1)).toUpperCase();
        String initialLastName = (lastname.substring(0, 1)).toUpperCase();
        String initialThirdName = (thirdname.substring(0, 1)).toUpperCase();
        return initialLastName + "." + initialName + "." + initialThirdName;
    }

    /**
     * 5. Подсчитать количество слов в тексте. Учесть, что слова могут разделяться несколькими пробелами.
     */
    public static void task5() {
        Scanner in = new Scanner(System.in);
        System.out.println("\nВведите строку для посчета слов :");
        String string = in.nextLine();
        System.out.println(calculateWord(string));
    }

    public static int calculateWord(String string) {
        int word = 0;
        char[] charOfString = string.toCharArray();
        for (int i = 1; i < string.length(); i++) {
            boolean indexChar = (((int) charOfString[i] > 31) && ((int) charOfString[i] < 48)) ||
                    (((int) charOfString[i] > 57) && ((int) charOfString[i] < 65)) ||
                    (((int) charOfString[i] > 90) && ((int) charOfString[i] < 97)) ||
                    (((int) charOfString[i] > 122) && ((int) charOfString[i] < 128));
            if ((charOfString[i - 1] == ' ') && (!indexChar || (((int) charOfString[i] > 191) && ((int) charOfString[i] < 256)))) {
                word++;
            }
        }
        return word;
    }

    /**
     * 6. Написать функцию, заменяющую несколько последовательных одинаковых символов в строке одним.
     * <p>
     * Пример: aaabbcdeef ->abcdef
     */
    public static void task6() {
        Scanner in = new Scanner(System.in);
        System.out.println("\nВведите строку :");
        String string = in.nextLine();
        System.out.println("Строка без повторных символов :"+"\n"+deleteDoubleChar(string));
    }

    public static StringBuilder deleteDoubleChar(String string) {
        ArrayList stringList = new ArrayList();
        for (int i = 0; i < string.length(); i++) {
            stringList.add(i, string.substring(i, i + 1));
        }
        int doubleChar=1;
        while (doubleChar == 1) {
            doubleChar = 0;
            for (int i = 1; i < stringList.size(); i++) {
                if (stringList.get(i - 1).equals(stringList.get(i))) {
                    stringList.remove(i);
                    doubleChar = 1;
                }
            }
        }
        StringBuilder stringOut = new StringBuilder();
        for (int i = 0; i < stringList.size(); i++) {
            stringOut = stringOut.append(stringList.get(i));
        }
        return stringOut;
    }


}

