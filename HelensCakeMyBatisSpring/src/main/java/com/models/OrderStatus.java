package com.models;

public enum OrderStatus {
    PLACED,
    DECLINED,
    CHANGED,
    CANCELED,
    ACCEPTED,
    PAID,
    EXECUTED;

    public static boolean checkOrderStatus(String string) {
        if(string == null) return false;
        try {
            OrderStatus.valueOf(string);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}
