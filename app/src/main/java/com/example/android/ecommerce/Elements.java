package com.example.android.ecommerce;

public class Elements {
    private String name;
    private int price;
    private String img_url;

    public Elements(String name, int price, String img_url) {
        this.name = name;
        this.price = price;
        this.img_url = img_url;
    }

    public Elements() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}
