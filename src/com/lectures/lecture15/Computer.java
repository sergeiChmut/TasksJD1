package com.lectures.lecture15;

import java.io.Serializable;
import java.util.Date;

public class Computer implements Serializable {
    private String id;
    private String name;
    private Date productionDate;
    private long memoryValue;
    private String price;


    public Computer(String id, String name, Date productionDate, long memoryValue, String price) {
        this.id = id;
        this.name = name;
        this.productionDate = productionDate;
        this.memoryValue = memoryValue;
        this.price = price;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public String getPrice() {
        return price;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMemoryValue() {
        return memoryValue;
    }

    public void setMemoryValue(long memoryValue) {
        this.memoryValue = memoryValue;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", productionDate=" + productionDate +
                ", memoryValue=" + memoryValue +
                ", price='" + price + '\'' +
                '}';
    }
}
