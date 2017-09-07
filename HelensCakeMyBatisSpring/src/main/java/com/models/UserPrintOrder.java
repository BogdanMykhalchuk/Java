package com.models;

/**
 * Created by Dreawalker on 19.08.2017.
 */
public class UserPrintOrder {
    private Integer id;
    private String linkToImg;
    private boolean isTight;
    private Integer quantity;
    private OrderStatus orderStatus;
    private String description;

    public UserPrintOrder() {
    }

    public UserPrintOrder(Integer id, String linkToImg, boolean isTight,
                          Integer quantity, OrderStatus orderStatus, String description) {
        this.id = id;
        this.linkToImg = linkToImg;
        this.isTight = isTight;
        this.quantity = quantity;
        this.orderStatus = orderStatus;
        this.description = description;
    }

    public static UserPrintOrder createUserPrintOrderWithoutId(String linkToImg, boolean isTight,
                                                               Integer quantity, OrderStatus orderStatus, String description) {
        return new UserPrintOrder(null, linkToImg, isTight, quantity, orderStatus, description);
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
