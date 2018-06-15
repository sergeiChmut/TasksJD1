package com.lectures.lecture15;

import java.io.Serializable;

public class Touchpad implements Serializable {
    private String type;
    private String id;
    private transient String brend;

    public Touchpad(String type, String id, String brend) {
        this.type = type;
        this.id = id;
        this.brend = brend;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrend() {
        return brend;
    }

    public void setBrend(String brend) {
        this.brend = brend;
    }

    @Override
    public String toString() {
        return "Touchpad{" +
                "type='" + type + '\'' +
                ", id=" + id +
                ", brend='" + brend + '\'' +
                '}';
    }
}
