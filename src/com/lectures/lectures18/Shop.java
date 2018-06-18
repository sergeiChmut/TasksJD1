package com.lectures.lectures18;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Shop {
//    public Good good;
    private HashMap<Good, Integer> listOfGoods;

    private static int receiptNum;

    public static int getReceiptNum() {
        return receiptNum;
    }

    public static void setReceiptNum(int receiptNum) {
        Shop.receiptNum = receiptNum;
    }

    Shop(HashMap<Good, Integer> listOfGoods) {
        this.listOfGoods = listOfGoods;
    }


    HashMap<Good, Integer> getListOfGoods() {
        return listOfGoods;
    }

    public void addGood(Good good, int countGood) {
        listOfGoods.put(good, countGood);
    }


    public void removeEmptyGood() {          // Удаление Товара при условии что количество позиции 0
        Iterator it = listOfGoods.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if ((int) entry.getValue() == 0) {
                it.remove();
            }
        }
    }

}
