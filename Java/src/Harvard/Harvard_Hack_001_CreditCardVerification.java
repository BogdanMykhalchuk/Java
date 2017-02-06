package Harvard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Character.getNumericValue;
import static java.lang.Character.isDigit;

/**
 * Created by Dreawalker on 03.01.2017.
 */
public class Harvard_Hack_001_CreditCardVerification {
    public static void main(String[] args) {
        String cardNumber = getCreditCardNumber("Введите номер кредитной карты");
        String company = setCompanyName(cardNumber);
        System.out.println(company);

    }

    public static boolean checkCardNumber(String cardNumber) {
        int k;
        int j = 0;
        char[] chars = cardNumber.toCharArray();
        int[] ints = new int[chars.length];
        int i;
        for(i = 0; i < chars.length; i++) {
            ints[i] = getNumericValue(chars[i]);
        }
        i = 1;
        while(i < ints.length) {
            k = ints[i] * 2;
            if(k > 9) {
                k = k - 10 + 1;
            }
            j = j + k;
            if(i + 2 < ints.length) {
                i = i + 2;
            } else {
                break;
            }
        }
        i = 0;
        while(i < ints.length) {
            j = j + ints[i];
            if(i + 2 < ints.length) {
                i = i + 2;
            } else {
                break;
            }
        }
        System.out.println(j);
        return j % 10 == 0;
    }

    public static String setCompanyName(String cardNumber) {
        if(cardNumber.length() == 15 && checkCardNumber(cardNumber) && getNumericValue(cardNumber.charAt(0)) == 3 &&
                getNumericValue(cardNumber.charAt(1)) == 4 | getNumericValue(cardNumber.charAt(1)) == 7) {
            return  "AMEX";
        } else if(cardNumber.length() == 16 && checkCardNumber(cardNumber) && getNumericValue(cardNumber.charAt(0)) == 5
                && getNumericValue(cardNumber.charAt(1)) == 1 || getNumericValue(cardNumber.charAt(1)) == 2 ||
                getNumericValue(cardNumber.charAt(1)) == 3 || getNumericValue(cardNumber.charAt(1)) == 4 ||
                getNumericValue(cardNumber.charAt(1)) == 5) {
            return  "MASTERCARD";
        } else if(checkCardNumber(cardNumber) && getNumericValue(cardNumber.charAt(0)) == 4 & cardNumber.length() == 16
                || cardNumber.length() == 13) {
            return "VISA";
        } else {
            return "INVALID";
        }
    }

    public static String getCreditCardNumber(String string) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String number;
        boolean b = true;
        while (b) {
            System.out.println(string);
            try {
                number = reader.readLine();
                char[] array = number.toCharArray();
                if (ifNumber(array)) {
                    System.out.println("Спасибо!");
                    reader.close();
                    return number;
                } else {
                    System.out.println("Ошибка ввода!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static boolean ifNumber(char[] array) {
        int i = 0;
        while(i < array.length) {
            if(isDigit(array[i])) {
                i++;
            } else {
                return false;
            }
        }
        return true;
    }
}
