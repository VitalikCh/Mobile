package com.example.vlad.androidapp.Entities;

public class ListItem {
    private Integer id;
    private String title;
    private Integer price;
    private String imageUrl;

    public ListItem(Integer id, String title, Integer price, String imageUrl) {
        this.id = id;
        this.price = price;
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
