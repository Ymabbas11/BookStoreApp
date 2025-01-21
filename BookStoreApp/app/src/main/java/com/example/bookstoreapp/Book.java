package com.example.bookstoreapp;

import java.io.Serializable;

public class Book implements Serializable {

    private String title,description,author,pages,score;
    private int rating;
    private int drawableResource;

    public Book(String title, String description, String author, String pages,String score,int rating,int drawableResource) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.pages = pages;
        this.score=score;
        this.rating = rating;
        this.drawableResource = drawableResource;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public String getPages() {
        return pages;
    }

    public int getRating() {
        return rating;
    }

    public int getDrawableResource() {
        return drawableResource;
    }

    public String getScore() {
        return score;
    }

}
