package com.lectures.lecture13;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * 1. Написать программу, проверяющую, является ли введённая строка адресом электронного почтового ящика.
 * В названии почтового ящика разрешить использование только букв, цифр и нижних подчёркиваний, при этом оно должно начинаться с буквы.
 * Возможные домены верхнего уровня: .org .com
 *
 * 2. Написать программу, выполняющую поиск в строке шестнадцатеричных чисел, записанных по правилам Java,
 * с помощью регулярных выражений и выводящую их на страницу.
 *
 * 3. Написать программу, выполняющую поиск в строке всех тегов абзацев, в т.ч. тех, у которых есть параметры, например <p id ="p1">,
 * и замену их на простые теги абзацев <p>.
 *
 * 4. Написать программу, выполняющую поиск в строке мобильных телефонных номеров в формате +375XXYYYYYYY
 * и заменяющую каждый телефон на тот же, но в формате +375 (XX) YYY-YY-YY
 * X - код оператора
 * Y - номер телефона
 * 5. Написать метод, который проверяет, является ли строка адресом IPv4.
 */
public class lecture13 {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();

    }

    /**1. Написать программу, проверяющую, является ли введённая строка адресом электронного почтового ящика.
     * В названии почтового ящика разрешить использование только букв, цифр и нижних подчёркиваний, при этом оно должно начинаться с буквы.
     * Возможные домены верхнего уровня: .org .com
     *
     */

    public static void task1() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку для проверки на email:");
        String mail = in.nextLine();
        Pattern pMail = Pattern.compile("\\b\\D\\w+@\\w+\\.(COM|com|ORG|org)");
        Matcher matcher = pMail.matcher(mail);
        if (matcher.find()) {
            System.out.println("Это Email !");
        } else {
            System.out.println("Это не Email");
        }
    }

    /**2. Написать программу, выполняющую поиск в строке шестнадцатеричных чисел, записанных по правилам Java,
     * с помощью регулярных выражений и выводящую их на страницу.
     *
     */
    public static void task2() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку c hex:");
        String string = in.nextLine();
        Pattern pHex = Pattern.compile("0x(\\d|[A-F]){2,}");
        Matcher matcher = pHex.matcher(string);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
    /**3. Написать программу, выполняющую поиск в строке всех тегов абзацев, в т.ч. тех, у которых есть параметры, например <p id ="p1">,
     * и замену их на простые теги абзацев <p>.
     *
     */
    public static void task3() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку :");
        String string = in.nextLine();
        string=string.replaceAll("<p?.{0,}>","<P>");
        System.out.println(string);
    }

    /**4. Написать программу, выполняющую поиск в строке мобильных телефонных номеров в формате +375XXYYYYYYY
     * и заменяющую каждый телефон на тот же, но в формате +375 (XX) YYY-YY-YY
     * X - код оператора
     * Y - номер телефона
     *
     */
    public static void task4() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку :");
        String string = in.nextLine();
        Pattern telefonNumber = Pattern.compile("\\+375(\\d{2})(\\d{3})(\\d{2})(\\d{2})");
        Matcher matcher = telefonNumber.matcher(string);
        while (matcher.find()) {
            string = string.replaceFirst("\\+375(\\d{2})(\\d{3})(\\d{2})(\\d{2})","+375 ("+matcher.group(1)+") "+
            matcher.group(2)+"-"+matcher.group(3)+"-"+matcher.group(4));
        }
        System.out.println(string);
    }

    /**5. Написать метод, который проверяет, является ли строка адресом IPv4.
     *
     */
    public static void task5() {
        String exp1 = "0.0.0.0";
        String exp2 = "01.10.255.101";
        String exp3 = "00.100.10.0";
        String exp4 = "101.0.5.15";
        String exp5 = "0.15.0.105";
        String exp6 = "25.205.255.256";
        String exp7 = "25.205.255.255";

        System.out.println(exp1+"  "+isIPv4(exp1));
        System.out.println(exp2+"  "+isIPv4(exp2));
        System.out.println(exp3+"  "+isIPv4(exp3));
        System.out.println(exp4+"  "+isIPv4(exp4));
        System.out.println(exp5+"  "+isIPv4(exp5));
        System.out.println(exp6+"  "+isIPv4(exp6));
        System.out.println(exp7+"  "+isIPv4(exp7));

    }
    public static boolean isIPv4(String string) {
        Pattern iPv4 = Pattern.compile("((([12][0-5][0-5])|([1-2]?[1-5]?[0-5]))\\.){3}(([12][0-5][0-5])|([1-2]?[1-5]?[0-5]))");
        Matcher matcher=iPv4.matcher(string);
        if (matcher.find()&&(matcher.group().length() == string.length())) {
            return true;
        }
        return false;
    }
}


