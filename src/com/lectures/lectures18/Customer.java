package com.lectures.lectures18;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class Customer implements Runnable {
    // касса занята - true, свободна - false
    private static final boolean[] COUNT_OF_CASH_DESK = new boolean[3];
    //Устанавливаем флаг "справедливый", в таком случае метод
    //aсquire() будет раздавать разрешения в порядке очереди
    private static final Semaphore SEMAPHORE = new Semaphore(3, true);

    private CashDesk[]  cashDesks;
    private String name;
    private double customerMoney;
    private HashMap<Good, Integer> shoppingBasket;
    private Receipt receipt;
    private Shop shop;


    public Customer(String name, double money, Shop shop, CashDesk[] cashDesks) {
        this.name = name;
        this.customerMoney = money;
        this.shop = shop;
        this.cashDesks = cashDesks;
    }

    public HashMap<Good, Integer> getShoppingBasket() {
        return shoppingBasket;
    }

    public void buyGoods(Shop shop) {
        synchronized (shop) {
            shoppingBasket = new HashMap<>();
            int countBuy = (int) (Math.random() * 6); // случайное количество покупок
            if (countBuy != 0) {
//                System.out.println(countBuy);
                while (countBuy != 0) {
                    for (Map.Entry entry : shop.getListOfGoods().entrySet()) {
                        int yes = (int) (Math.random() * 2);
                        if ((yes == 0) && (countBuy != 0)) {
                            int countOfGood = (int) (Math.random() * 3) + 1; // случайное количество товара
                            if (countOfGood > (int) entry.getValue()) {   // проверка на наличие такого количества если нет забираем последнее
                                countOfGood = (int) entry.getValue();
                                System.out.printf("Покупателю %s повезло - он забрал последний товар - %s\n",
                                        name, Good.name((Good) entry.getKey())); // информируем))
                            }
                            shoppingBasket.put((Good) entry.getKey(), countOfGood); // добавляем в корзину
                            entry.setValue((int) entry.getValue() - countOfGood); // уменьшаем количество товара данной позиции в магазине
                            countBuy--;
                        }
                    }
                    shop.removeEmptyGood();
                }
            }
//            for (Map.Entry entry : shop.getListOfGoods().entrySet()) {
//                System.out.println(entry);
//            }
        }
    }

    private void goToCashDesk(HashMap<Good,Integer> shoppingBasket) {
        System.out.printf("Покупатель %s подошел к очереди в кассы.\n", name);
        try {
            //acquire() запрашивает доступ к следующему за вызовом этого метода блоку кода,
            //если доступ не разрешен, поток вызвавший этот метод блокируется до тех пор,
            //пока семафор не разрешит доступ
            SEMAPHORE.acquire();
            int cashDesk = -1;
            //Ждем свободную кассу
            synchronized (COUNT_OF_CASH_DESK){
                for (int i = 0; i < 3; i++)
                    if (!COUNT_OF_CASH_DESK[i]) {      //Если место свободно
                        COUNT_OF_CASH_DESK[i] = true;  //занимаем его
                        cashDesk = i;//Наличие свободного места, гарантирует семафор
                        Thread.sleep(50);
                        System.out.printf("Покупатель %s обслуживается в кассе №%d.\n", name, cashDesk+1);
                        break;
                    }
            }

//            Thread.sleep(500);       //Ждем еще обслуживания

            synchronized (COUNT_OF_CASH_DESK) {
                receipt = cashDesks[cashDesk].calculation(shoppingBasket);
                double totalSum = receipt.getTotalSum();
                Thread.sleep((int)(Math.random()*800)+200);
                customerMoney = 5; // Количество денег для передачи в кассу по умолчанию
                while (customerMoney<totalSum) {
                    customerMoney+=5; // добавляем если мало для оплаты
                }
                System.out.printf("Покупателю %s к оплате %5.2f, и он передает для оплаты %5.2f\n", name, totalSum, customerMoney);
                receipt = cashDesks[cashDesk].calculationWithMoney(receipt, customerMoney);
                COUNT_OF_CASH_DESK[cashDesk] = false;//Освобождаем место
                System.out.printf("Покупатель %s получает сдачу %5.2f\n",name, receipt.getChange());
            }

            //release(),  освобождает ресурс
            SEMAPHORE.release();
            System.out.printf("Покупатель %s покинул кассу №%s. Его чек : \n", name, cashDesk+1);
//            Thread.sleep(100);

        } catch (InterruptedException e) {
        }
//        return receipt;
    }



    @Override
    public void run() {
        System.out.printf("В магазин пришел покупатель %s и делает покупки\n", name);
        buyGoods(shop);
        if ((shoppingBasket.size()!= 0)){
            try {
                Thread.sleep(100);
                goToCashDesk(shoppingBasket);
                receipt.printReceipt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.printf("Покупатель %s передумал и уходит без покупок\n", name);

        }
    }


}



