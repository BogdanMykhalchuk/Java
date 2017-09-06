package com.models;

/**
 * Created by Dreawalker on 26.07.2017.
 */
public class Incision {

    private Integer id;
    private String name;
    private String description;
    private String pathToImg;
    private double price;

    public Incision() {}

    public Incision(String name, String description, String pathToImg, double price) {
        this.name = name;
        this.description = description;
        this.pathToImg = pathToImg;
        this.price = price;
    }

    public Incision(Integer id, String name, String description, String pathToImg, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.pathToImg = pathToImg;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPathToImg() {
        return pathToImg;
    }

    public void setPathToImg(String pathToImg) {
        this.pathToImg = pathToImg;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
