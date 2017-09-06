package com.models;

/**
 * Created by Dreawalker on 06.08.2017.
 */
public enum CoverType {
    GUM_PASTE,
    CHOKO_VELOURS,
    CREAM,
    CAP_CAKES,
    SPACE;

    public static boolean checkCakeCoverType(String string) {
        if(string == null) return false;
        try {
            CoverType.valueOf(string);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}
