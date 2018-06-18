package com.lectures.lectures18;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.Formatter;
import java.util.LinkedList;

@AllArgsConstructor
@Data
public class Receipt {
    //    private Item item;
    //id, date, casseNo, List<Item>, totalSum, change
    private int id;
    private Date date;
    private int casseNo;
    private LinkedList<Item> listItems;
    private double totalSum;
    private double change;
    private double discountAmount;
    private Formatter f = new Formatter(System.out);

    public Receipt(int id, Date date, int casseNo, LinkedList<Item> listItems) {
        this.id = id;
        this.date = date;
        this.casseNo = casseNo;
        this.listItems = listItems;

    }

    public void printReceipt() {
        f.format("\n-------------------------\n");
        f.format("Receipt #%-5d\n", id);
        f.format("%-30s\n", date);
        f.format("Number cash desk : %2s\n", casseNo);
        f.format("%2s %-15s %5s %10s\n", "#", "Item", "Qty", "Price");
        f.format("%2s %-15s %5s %10s\n", "-", "----", "---", "-----");
        for (int i = 0; i < listItems.size(); i++) {
            Item item = listItems.get(i);
            f.format("%2d %-15.15s %5s %10.2f\n", item.getOrdinalNumber(), item.getGood(), item.getQuantity(), item.getCost());
            if (item.getDiscount() != 0) {
                f.format("%-9.9s %2s%% %5s x %5.2f %7.2f\n", "discount, ", (int) (item.getDiscount() * 100),item.getQuantity(),
                        item.getDiscount() * item.getCost(),item.getDiscount() * item.getCost()*item.getQuantity());
            }
        }
        f.format("%2s %-15.15s %5s %10.2f\n", "", "Discount", "", discountAmount);
        f.format("%2s %-15.15s %5s %10s\n", "", "", "", "-----");
        f.format("%2s %-15.15s %5s %10.2f\n", "", "Tax", "", totalSum/1.2*0.2);
        f.format("%2s %-15.15s %5s %10s\n", "", "", "", "-----");
        f.format("%2s %-15.15s %5s %10.2f\n", "", "Total", "", totalSum );
        f.format("--E-N-D---R-E-C-E-I-P-T--\n\n\n");


    }
    public void addItems(Item item) {
        listItems.addLast(item);
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                ", date=" + date +
                ", casseNo=" + casseNo +
                ", listItems=" + listItems +
                ", totalSum=" + totalSum +
                ", change=" + change +
                ", discountAmount=" + discountAmount +
                '}';
    }



}
