package com.example.firstproject;

public class Element {
    private int id;
    private String item;
    private String quantity;

    public Element(int id, String item, String quantity) {
        this.id = id;
        this.item = item;
        this.quantity = quantity;
    }

    public Element() {
    }

    @Override
    public String toString() {
        return "Element{" +
                "id=" + id +
                ", item='" + item + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
