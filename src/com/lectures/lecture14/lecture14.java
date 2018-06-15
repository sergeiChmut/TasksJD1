package com.lectures.lecture14;

import java.io.*;

/**
 * 1. Задан файл с многострочным тестом. Прочитать и вывести этот файл в консоль построчно.
 * <p>
 * 2. Задан файл с текстом, найти и вывести в консоль все слова, начинающиеся с гласной буквы.
 * <p>
 * 3. Задан файл с текстом, найти и вывести в консоль все слова,  для которых последняя буква одного
 * слова совпадает с первой буквой следующего слова
 * <p>
 * 4. Задан файл с текстом. В каждой строке найти и вывести наибольшее число цифр, идущих подряд.
 * <p>
 * 5. Записать в двоичный файл 20 случайных чисел типа int со значением >128. Прочитать записанный файл,
 * распечатать числа и их среднее арифметическое.
 * 6 Вывести список файлов и каталогов выбранного каталога на диске с учетом вложенности директориев.
 * Для этого использовать рекурсию (пример рекурсии тут и тут).
 * 7. Задан файл с java-кодом. Прочитать текст программы из файла и записать в другой файл в обратном порядке символы каждой строки.
 */
public class lecture14 {
    public static void main(String[] args) {
//        tasks1_5();
//        task6();
        task7();

    }

    private static void tasks1_5() {
        try (FileInputStream fis = new FileInputStream("data.txt");
             FileOutputStream fos = new FileOutputStream("intnumber.txt");
             InputStreamReader is = new InputStreamReader(fis);
             BufferedReader bis = new BufferedReader(is);
             OutputStreamWriter osw = new OutputStreamWriter(System.out);
             BufferedWriter bw = new BufferedWriter(osw);) {
            task1(bis, bw);
            fis.getChannel().position(0);
            task2(bis, bw);
            fis.getChannel().position(0);
            task3(bis, bw);
            fis.getChannel().position(0);
            task4(bis, bw);
            FileInputStream fis2 = new FileInputStream("intnumber.txt");
            task5(fos, fis2, bw);

        } catch (IOException e) {
            System.err.print("ошибка ввода/вывода " + e);
        }
    }

    /**
     * 1. Задан файл с многострочным тестом. Прочитать и вывести этот файл в консоль построчно.
     */
    private static void task1(BufferedReader bis, BufferedWriter bw) throws IOException {
        String line = "";
        bw.write("TASK 1 :\n");
        while ((line = bis.readLine()) != null) {
            bw.write(line);
            bw.newLine();
        }
    }

    /**
     * 2. Задан файл с текстом, найти и вывести в консоль все слова, начинающиеся с гласной буквы.
     */
    private static void task2(BufferedReader bis, BufferedWriter bw) throws IOException {
        String line = "";
        bw.write("\nTASK 2 (начинаются на гласную):\n");
        while ((line = bis.readLine()) != null) {
            String[] words = line.split(" +");
            for (String word : words) {
                if (word.matches("^[аеыоэяиюуАЕОЭЯИЮУ][а-яА-Я]+")) {
                    bw.write(word + "  ");
                }
            }
        }
    }

    /**
     * 3. Задан файл с текстом, найти и вывести в консоль все слова,  для которых последняя буква одного
     * слова совпадает с первой буквой следующего слова
     */
    private static void task3(BufferedReader bis, BufferedWriter bw) throws IOException {
        bw.write("\nTASK 3 (последняя - первая буква равны) :\n");
        String line = "";
        while ((line = bis.readLine()) != null) {
            String[] words = line.split(" +");
            if (words.length > 1) {
                for (int i = 1; i < words.length; i++) {
                    if (words[i - 1].substring(words[i - 1].length() - 1).equalsIgnoreCase(words[i].substring(0, 1))) {
                        bw.write(words[i - 1] + " - " + words[i] + "  ");
                    }
                }
            }
        }
    }

    /**
     * 4. Задан файл с текстом. В каждой строке найти и вывести наибольшее число цифр, идущих подряд.
     */
    private static void task4(BufferedReader bis, BufferedWriter bw) throws IOException {
        bw.write("\nTASK 4 (наибольшее число цифр подряд) :\n");
        String line = "";
        while ((line = bis.readLine()) != null) {
            String[] words = line.split(" +");
            String wordOfNumber = "";
            for (int i = 0; i < words.length; i++) {
                if ((words[i].matches("^\\d?\\d+")) && (words[i].length() > wordOfNumber.length())) {
                    wordOfNumber = words[i];
                }
            }
            if (!wordOfNumber.equalsIgnoreCase("")) {
                bw.write(wordOfNumber + "  ");
            }
        }
    }

    /**
     * 5. Записать в двоичный файл 20 случайных чисел типа int со значением >128. Прочитать записанный файл,
     * распечатать числа и их среднее арифметическое.
     */
    private static void task5(FileOutputStream fos, FileInputStream fis, BufferedWriter bw) throws IOException {
        bw.write("\nTASK 5 (числа) :\n");
        int countOfNumbers = 20;
        int random;
        for (int i = 0; i < countOfNumbers; i++) {
            if (i<(countOfNumbers/2)) {
                random = (int) (Math.random() * 2000000000 + 256);
            } else {
                random = (int) (Math.random() * 20000 + 256);
            }
            fos.write(((random >>> 24) & 0xFF));
            fos.write(((random >>> 16) & 0xFF));
            fos.write(((random >>> 8) & 0xFF));
            fos.write(((random >>> 0) & 0xFF));
        }
        long summa = 0;
        int count = 0;
        int temp = 0;
        while ((temp = fis.read()) != -1) {
            int ch1 = temp;
            int ch2 = fis.read();
            int ch3 = fis.read();
            int ch4 = fis.read();
            int number = ((ch1 << 24) + (ch2 << 16) + (ch3 << 8) + (ch4 << 0));
            bw.write(number+" ");
            summa += number;
            count++;
        }
        bw.write("\nСреднее арифметическое 20 случайных чисел равно : " + (summa / count));
    }

    /**
     * 6 Вывести список файлов и каталогов выбранного каталога на диске с учетом вложенности директориев.
     * Для этого использовать рекурсию (пример рекурсии тут и тут).
     */
    private static void task6() {
        File root = File.listRoots()[1];
        System.out.println(root.getFreeSpace());
        File[] files = root.listFiles();
        recDir(files);
    }

    private static File[] recDir(File[] listFiles) {
        for (int i = 0; i < listFiles.length; i++) {
            System.out.println(listFiles[i]);
            if (!(listFiles[i].isHidden()) && (listFiles[i].isDirectory())) {
                recDir(listFiles[i].listFiles());
            }
        }
        return null;
    }

    /**
     * 7. Задан файл с java-кодом. Прочитать текст программы из файла и записать в другой файл в обратном порядке символы каждой строки.
     */
    private static void task7() {
        try (FileInputStream fis3 = new FileInputStream("javaCode.txt");
             FileOutputStream fos2 = new FileOutputStream("javaEdoc.txt");
             InputStreamReader is3 = new InputStreamReader(fis3);
             BufferedReader bis3 = new BufferedReader(is3);
             OutputStreamWriter osw2 = new OutputStreamWriter(fos2);
             BufferedWriter bw2 = new BufferedWriter(osw2);) {
            // task7(bis3, bw2);
            String line = "";
            while ((line = bis3.readLine()) != null) {
                StringBuilder lineInvert = new StringBuilder();
                char[] symbols = line.toCharArray();
                if (symbols.length > 1) {
                    int i = symbols.length - 1;
                    while (i != -1) {
                        lineInvert = lineInvert.append(symbols[i]);
                        i--;
                    }
                    bw2.write(String.valueOf(lineInvert));
                    bw2.write(10);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
