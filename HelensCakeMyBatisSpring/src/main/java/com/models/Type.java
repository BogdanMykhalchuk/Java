package com.models;

/**
 * Created by Dreawalker on 26.07.2017.
 */
public enum Type {
    CHILD_CAKE,
    WEDDING_CAKE,
    MAN_CAKE,
    WOMAN_CAKE,
    HEN_PARTY;

    public static boolean checkCakeType(String string) {
        if(string == null) return false;
        try {
            Type.valueOf(string);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}
