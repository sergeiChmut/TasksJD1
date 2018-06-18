package com.lectures.lectures18;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class TestShopWithCustomers {

    public static void main(String[] args)throws InterruptedException {
        // созданием магазин и заполненяем его товаром
        Shop anyshop = new Shop(new HashMap<>());
        System.out.println("ДОБРО ПОЖАЛОВАТЬ В МАГАЗИН!");
        anyshop.addGood(new Good(11,"Водка", 6.95, 0),10);
        anyshop.addGood(new Good(25,"Пиво", 1.95, 0),20);
        anyshop.addGood(new Good(23,"Чипсы", 1.1, 0.05),10);
        anyshop.addGood(new Good(28,"Хлеб", 1.2, 0),25);
        anyshop.addGood(new Good(41,"Молоко", 0.95, 0),15);
        anyshop.addGood(new Good(15,"Селедка", 2.4, 0.1),20);
        anyshop.addGood(new Good(16,"Кефир", 1.05, 0),15);
        anyshop.addGood(new Good(27,"Батон", 0.95, 0),25);
        anyshop.addGood(new Good(82,"Гречка", 2.25, 0.1),5);
        anyshop.addGood(new Good(93,"Колбаски", 5.4, 0.45),5);
        anyshop.addGood(new Good(100,"Йогурт", 2.9, 0.15),2);
        anyshop.addGood(new Good(50,"Булочка из печки", 2.1, 0.1),3);
//        Customer customer = new Customer();
//        customer.buyGoods(anyshop);
//        for (Map.Entry entry: customer.getShoppingBasket().entrySet()) {
//            System.out.println(entry);
//        }

        CashDesk[] cashDesks = new CashDesk[3];
        cashDesks[0] = new CashDesk(1, 150);
        cashDesks[1] = new CashDesk(2, 250);
        cashDesks[2] = new CashDesk(3, 350);
//        test1(anyshop,cashDesks);
        test2(anyshop,cashDesks);

    }
    public static void test1(Shop anyshop, CashDesk[] cashDesks) {
        Customer customer1 = new Customer("Вова", 55.2,anyshop,cashDesks);
        Customer customer2 = new Customer("Саня", 150.2,anyshop,cashDesks);
        Customer customer3 = new Customer("Женя", 305.2,anyshop,cashDesks);
        Customer customer4 = new Customer("Слава", 185.2,anyshop,cashDesks);
        Customer customer5 = new Customer("Катя", 455.2,anyshop,cashDesks);
        Customer customer6 = new Customer("Надя", 1005.2,anyshop,cashDesks);
        Customer customer7 = new Customer("Света", 1005.2,anyshop,cashDesks);
        Thread thread1 = new Thread(customer1);
        thread1.start();
//        Thread.sleep(500);
        Thread thread2 = new Thread(customer2);
        thread2.start();
//        Thread.sleep(500);
        Thread thread3 = new Thread(customer3);
        thread3.start();
//        Thread.sleep(500);
        Thread thread4 = new Thread(customer4);
        Thread thread5 = new Thread(customer5);
        Thread thread6 = new Thread(customer6);
        Thread thread7 = new Thread(customer7);
        thread4.start();
        thread5.start();
//        Thread.sleep(500);
        thread6.start();
        thread7.start();

    }
    public static void test2(Shop shop, CashDesk[] cashDesks) {
        LinkedList<String> randomNames = new LinkedList<>(Arrays.asList("Вова","Саня","Женя","Слава","Катя","Надя","Света","Женя",
                "Сергей", "Маша","Аня","Дима", "Денис", "Ваня", "Саня"));
        int numOfCustomer = 1;
        while ((shop.getListOfGoods().size()!=0)&&(numOfCustomer<20)) {
            Customer customer = new Customer("№"+numOfCustomer+" - "+randomNames.get((int) (Math.random() * 15)), 100, shop,cashDesks);
            Thread thread = new Thread(customer);
            thread.start();
            numOfCustomer++;
        }
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Больше обслужить не сможем!\n Все что осталось ) :");
        for (Map.Entry entry : shop.getListOfGoods().entrySet()) {
            System.out.println(entry);
        }
//        System.out.println("Деньги в кассах " + cashDesks[0].getAmountOfMoneyCashDesk()+ " " +cashDesks[1].getAmountOfMoneyCashDesk()+ " "+
//                cashDesks[2].getAmountOfMoneyCashDesk());
    }

}
