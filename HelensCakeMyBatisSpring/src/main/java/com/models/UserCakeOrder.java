package com.models;

import java.time.LocalDateTime;


/**
 * Created by Dreawalker on 19.08.2017.
 */
public class UserCakeOrder {

    private Integer id;
    private String recipe;
    private String linkToImg;
    private Incision incision;
    private Cake cake;
    private Double weight;
    private Double price;
    private Boolean needDelivery;
    private Address address;
    private LocalDateTime date;
    private OrderStatus orderStatus;

    public UserCakeOrder() {
    }

    public UserCakeOrder(Integer id, String recipe, String linkToImg, Incision incision, Cake cake, Double weight,
                         Double price, Boolean needDelivery, Address address, LocalDateTime date,
                         OrderStatus orderStatus) {
        this.id = id;
        this.recipe = recipe;
        this.linkToImg = linkToImg;
        this.incision = incision;
        this.cake = cake;
        this.weight = weight;
        this.price = price;
        this.needDelivery = needDelivery;
        this.address = address;
        this.date = date;
        this.orderStatus = orderStatus;
    }

    public static UserCakeOrder createUserCakeOrderWithoutId(String recipe, String linkToImg, Incision incision,
                          Cake cake, Double weight, Double price, Boolean needDelivery, Address address,
                          LocalDateTime date, OrderStatus orderStatus) {
        return new UserCakeOrder(null, recipe, linkToImg, incision, cake, weight, price, needDelivery,
                address, date, orderStatus);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public String getLinkToImg() {
        return linkToImg;
    }

    public void setLinkToImg(String linkToImg) {
        this.linkToImg = linkToImg;
    }

    public Incision getIncision() {
        return incision;
    }

    public void setIncision(Incision incision) {
        this.incision = incision;
    }

    public Cake getCake() {
        return cake;
    }

    public void setCake(Cake cake) {
        this.cake = cake;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getNeedDelivery() {
        return needDelivery;
    }

    public void setNeedDelivery(Boolean needDelivery) {
        this.needDelivery = needDelivery;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
