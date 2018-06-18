package com.lectures.lectures18;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CashDesk {
    private int id;
    private double amountOfMoneyCashDesk;


    public CashDesk(int id, double amountOfMoneyCashDesk) {
        this.id = id;
        this.amountOfMoneyCashDesk = amountOfMoneyCashDesk;
    }

    public int getId() {
        return id;
    }
    public double getAmountOfMoneyCashDesk() {
        return amountOfMoneyCashDesk;
    }

    public void setAmountOfMoneyCashDesk(double amountOfMoneyCashDesk) {
        this.amountOfMoneyCashDesk = amountOfMoneyCashDesk;
    }
    public Receipt calculation (HashMap<Good, Integer> shoppingBasket) {
        Receipt receipt = new Receipt(Shop.getReceiptNum(), new Date(), id, new LinkedList<Item>());
        int iNum = 1;
        double totalSum = 0;
        double discountAmount = 0;
        for (Map.Entry entry:shoppingBasket.entrySet() ) {
            Good currentGood = (Good)entry.getKey();
            receipt.addItems(new Item(iNum, currentGood, (int)entry.getValue()));
            discountAmount = discountAmount + Math.abs(currentGood.getPrice()*currentGood.getDiscount())*((int) entry.getValue());
            totalSum = totalSum + (currentGood.getPrice()*((int) entry.getValue())-
                    currentGood.getDiscount()*currentGood.getPrice()*((int) entry.getValue()));
            iNum++;
        }
        receipt.setTotalSum(totalSum);
        receipt.setDiscountAmount(discountAmount);
        Shop.setReceiptNum(Shop.getReceiptNum()+1);
        return receipt;
    }
    public Receipt calculationWithMoney (Receipt receipt,double money) {
        double change = money - receipt.getTotalSum();
        receipt.setChange(change);
        setAmountOfMoneyCashDesk(getAmountOfMoneyCashDesk()+ receipt.getTotalSum()); // добавляем деньги в кассу
        return receipt;
    }

}
