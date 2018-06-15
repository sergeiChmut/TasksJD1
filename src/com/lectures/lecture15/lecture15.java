package com.lectures.lecture15;


import java.io.*;
import java.util.Date;

/**1.	Сравнить скорость чтения и записи 5 МБ символов при использовании классов буфиризированого
 * и не буфиризированого символьного ввода вывода.

 2.	Создать класс Computer. Добавить ему несколько полей, создать объект этого класса, сериализовать в файл.
 Десериализовать объект из того же файла, вывести значения полей в консоль.

 3.	Создать класс Notebook - наследник Computer. В этом классе должно быть поле типа Touchpad - также созданного класса со своими полями.
 Добавить в класс Notebook transient-поле. Создать объект класса Notebook, сериализовать в файл.
 Десериализовать объект из файла, продемонстрировать, что transient-поля не сериализуются.

 *
 */
public class lecture15 {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    /**1.	Сравнить скорость чтения и записи 5 МБ символов при использовании классов буфиризированого
     * и не буфиризированого символьного ввода вывода.
     *
     */
    private static void task1() {
        try(Writer writer = new FileWriter("dataTest.dat");
            Writer writer2 = new FileWriter("dataTestNoBuffer.dat");
            Writer writer3 = new FileWriter("dataTestWithBuffer.dat");
            BufferedWriter bw = new BufferedWriter(writer);
            BufferedWriter bw2 = new BufferedWriter(writer3);
            Reader reader = new FileReader("dataTest.dat");
            Reader reader2 = new FileReader("dataTestNoBuffer.dat");
            BufferedReader br = new BufferedReader(reader2);) {
            //Запись 5Мб символов в файл dataTest.txt
            for (int i=0; i<655360;i++) {
                bw.write('Я');  // 'Я' дает в запись 2 байта
                bw.write('Я');
                bw.write('Я');
                bw.write('Я');
            }
            // Чтение запись без использования буферизированного символьного ввода
            int temp;
            long startOutBuffer = System.nanoTime();
            while ((temp = reader.read())!=-1) {
                writer2.write((char)temp);
            }
            long endOutBuffer = System.nanoTime();
            // Чтение запись c использованием буферизированного символьного ввода
            long startWithBuffer = System.nanoTime();
            while ((temp = br.read())!=-1) {
                bw2.write((char)temp);
            }
            long endWithBuffer = System.nanoTime();
            System.out.println("Время записи/чтения 5Mb без буферизации : "+(endOutBuffer-startOutBuffer)+
                    "\nВремя записи/чтения 5Mb с  буферизацией : "+(endWithBuffer-startWithBuffer));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**2.	Создать класс Computer. Добавить ему несколько полей, создать объект этого класса, сериализовать в файл.
     Десериализовать объект из того же файла, вывести значения полей в консоль.
     *
     */
    private static void task2() {
        Computer computer = new Computer("#5624","WorkComp",new Date(),4096,"550 $");
        final String fileName = "serialization.txt";
        System.out.println(computer);
        serialization(computer, fileName);
        Computer recoveredComputer = (Computer)deserialization(fileName);
        System.out.println(recoveredComputer);
    }
    public static void serialization(final Object car, String fileName) {
        try {
            FileOutputStream os = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(os);
            objectOutputStream.writeObject(car);
            objectOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object deserialization(String fileName) {
        try (FileInputStream is = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(is);){
            return objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**3.	Создать класс Notebook - наследник Computer. В этом классе должно быть поле типа Touchpad -
     * также созданного класса со своими полями.
     Добавить в класс Notebook transient-поле. Создать объект класса Notebook, сериализовать в файл.
     Десериализовать объект из файла, продемонстрировать, что transient-поля не сериализуются.
     *
     */
    private static void task3() {
        Touchpad tochAsus = new Touchpad("none","#254","Asus");
        Notebook notebook = new Notebook("#2541","Asus",new Date(),4096,"450 $","14", tochAsus);
        final String fileName = "serializNotebook.txt";
        System.out.println(notebook);
        serialization(notebook, fileName);
        Notebook recoveredNotebook = (Notebook)deserialization(fileName);
        System.out.println(recoveredNotebook);
    }

}
