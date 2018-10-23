package ru.innopolis.jms.request;

public class Item {
    private int id;
    private String name;
    private String category;
    private double price;
    private String comment;
    private String catName;

    public Item(int id, String name, String category, double price, String comment, String catName) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.comment = comment;
        this.catName = catName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
}
