package com.models;

/**
 * Created by Dreawalker on 19.08.2017.
 */
public class UserPrintOrder {
    private Integer id;
    private String linkToImg;
    private Cake cake;
    private boolean isTight;
    private Integer quantity;
    private OrderStatus orderStatus;

    public UserPrintOrder() {
    }

    public UserPrintOrder(Integer id, String linkToImg, Cake cake, boolean isTight, Integer quantity,
                          OrderStatus orderStatus) {
        this.id = id;
        this.linkToImg = linkToImg;
        this.cake = cake;
        this.isTight = isTight;
        this.quantity = quantity;
        this.orderStatus = orderStatus;
    }

    public static UserPrintOrder createUserPrintOrderWithoutId(String linkToImg, Cake cake, boolean isTight,
                                                               Integer quantity, OrderStatus orderStatus) {
        return new UserPrintOrder(null, linkToImg, cake, isTight, quantity, orderStatus);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLinkToImg() {
        return linkToImg;
    }

    public void setLinkToImg(String linkToImg) {
        this.linkToImg = linkToImg;
    }

    public Cake getCake() {
        return cake;
    }

    public void setCake(Cake cake) {
        this.cake = cake;
    }

    public boolean isTight() {
        return isTight;
    }

    public void setTight(boolean tight) {
        isTight = tight;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
