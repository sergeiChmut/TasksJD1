package com.lectures.lecture15;

import java.util.Date;

public class Notebook extends Computer {
    private static final long serialVersionUID = 1;
    public Notebook(String id, String name, Date productionDate, long memoryValue, String price) {
        super(id, name, productionDate, memoryValue, price);
    }
    private transient String displaySize;
    private Touchpad touchpad;

    public Notebook(String id, String name, Date productionDate, long memoryValue, String price, String displaySize, Touchpad touchpad) {
        super(id, name, productionDate, memoryValue, price);
        this.displaySize = displaySize;
        this.touchpad = touchpad;
    }

    public String getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(String displaySize) {
        this.displaySize = displaySize;
    }

    public Touchpad getTouchpad() {
        return touchpad;
    }

    public void setTouchpad(Touchpad touchpad) {
        this.touchpad = touchpad;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", productionDate=" + getProductionDate() +
                ", memoryValue=" + getMemoryValue() +
                ", price='" + getPrice() + '\'' +
                "displaySize='" + displaySize + '\'' +
                ", touchpad=" + touchpad +
                '}';
    }
}
