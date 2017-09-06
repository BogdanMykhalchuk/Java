package com.models;

/**
 * Created by Dreawalker on 19.08.2017.
 */
public enum UserRole {

    ROLE_ADMIN,
    ROLE_CLIENT;

    public static boolean checkUserRole(String string) {
        if(string == null) return false;
        try {
            UserRole.valueOf(string);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}
