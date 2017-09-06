package com.dataValidation;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidation {

    public static boolean isContainValidCharsOnly(String string) {
        if(string == null) return false;
        Pattern forbiddenChars = Pattern.compile(".*[\\[\\]\\+\\(\\)\\$\\%\\#\\!\\?\\|\\^\\*\\=\\<\\>\"].*");
        Matcher m = forbiddenChars.matcher(string);
        return !m.matches();
    }

    public static boolean isValidPhoneNumber(String string) {
        if(string == null) return false;
        String phoneNumber = string.replaceAll("[\\)\\(-+]", "");
        return phoneNumber.length() == 10 && StringUtils.isNumeric(phoneNumber);
    }
}
