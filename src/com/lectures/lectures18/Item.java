package com.lectures.lectures18;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Item {
    private int ordinalNumber;
    public Good good;
    private int quantity;
    private double cost;
    private double discount;

    Item (int ordinalNumber, Good good, int quantity) {
        this.ordinalNumber = ordinalNumber;
        this.quantity = quantity;
        this.cost = good.getPrice();
        this.discount = good.getDiscount();
        this.good = good;

    }

    @Override
    public String toString() {
        return "Item{" +
                "ordinalNumber=" + ordinalNumber +
                ", good=" + good +
                ", quantity=" + quantity +
                ", cost=" + cost +
                ", discount=" + discount +
                '}';
    }
}
