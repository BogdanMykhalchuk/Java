package com.models;

/**
 * Created by Dreawalker on 06.08.2017.
 */
public enum DecorComplexity {
    EASY,
    HARD,
    _3D;

    public static boolean checkCakeDecorComplexity(String string) {
        if(string == null) return false;
        try {
            DecorComplexity.valueOf(string);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}
