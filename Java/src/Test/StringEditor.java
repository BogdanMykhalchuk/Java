package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Character.isSpaceChar;
import static java.lang.Character.isUpperCase;

/**
 * Created by Dreawalker on 24.09.2016.
 */
public class StringEditor {
    public static void main(String[] args) {

        String s = "http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo";
        String subString = s.substring(s.indexOf('?') + 1);
        if (subString.contains("obj="))
        {
            String subString2 = subString.substring(subString.indexOf("obj=") + 4, subString.indexOf("&"));
            if (subString2.contains("."))
            {
                splitSubString(subString);
                System.out.println();
                alert(Double.parseDouble(subString2));
            } else
            {
                splitSubString(subString);
                System.out.println();
                alert(subString2);
            }
        } else
        {
            splitSubString(subString);
        }
    }

    public static void splitSubString(String subString){
        Scanner scanner = new Scanner(subString);
        scanner.useDelimiter("[0-9]|=|&");
        List<String> list = new ArrayList<>();
        while (scanner.hasNext())
        {
            list.add(scanner.next());
        }

        int j = list.size();
        for (int i = 0; i < j; i++)
        {
            String temp = "";
            if (list.get(i).equals("") || isUpperCase(list.get(i).charAt(0)) || list.get(i).equals("."))
            {
                list.remove(i);
                i--;
                j--;

            } else
            {
                if (list.get(i).contains("/s"))
                {
                    for (int x = 0; x < list.get(i).length(); x++)
                    {
                        if (isSpaceChar(list.get(i).charAt(x)))
                        {

                        } else
                        {
                            temp = temp + list.get(i).charAt(x);
                        }
                    }
                    list.set(i, temp);
                }
            }
        }
        for (int i = 0; i < list.size(); i++)
        {
            System.out.print(list.get(i) + " ");
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }

}

//	@Override
//	public static void sort() {
//		for(int i = 0; i < list.size(); i++) {
//			for(int j = 1; j < list.size(); j++) {
//				if(list.get(j - 1).getSalary() < list.get(j).getSalary()) {
//					Employee tempEmployee = new Employee();
//					tempEmployee = list.get(j - 1);
//					list.set(j - 1, list.get(j));
//					list.set(j, tempEmployee);
//				}
//			}
//		}
//
//		for(int i = 0; i < list.size(); i++) {
//			for(int j = 1; j < list.size(); j++) {
//				if(list.get(j - 1).getSalary() == list.get(j).getSalary()
//					&& list.get(j - 1).getName() < list.get(j).getName()) {
//					Employee tempEmployee = new Employee();
//					tempEmployee = list.get(j - 1);
//					list.set(j - 1, list.get(j));
//					list.set(j, tempEmployee);
//				}
//			}
//		}
//
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).getId() + ", " + list.get(i).getName() +
//			", " + list.get(i).getSalary());
//		}
