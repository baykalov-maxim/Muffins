package ua.nure.muffins.model;

import java.util.List;

public class Order {
    private long id;
    private String name;
    private int date;
    private int phone;
    private List<MuffinInOrder> muffins;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public List<MuffinInOrder> getMuffins() {
        return muffins;
    }

    public void setMuffins(List<MuffinInOrder> muffins) {
        this.muffins = muffins;
    }
}
