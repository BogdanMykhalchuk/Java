package Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();

        StringBuilder stringBuilder = new StringBuilder();
        FileReader br1 = new FileReader(fileName);
        while(br1.ready()) {
            stringBuilder.append((char)br1.read());
        }
        br1.close();

        Matcher matcher1 = Pattern.compile("<" + args[0]).matcher(stringBuilder);
        Matcher matcher2 = Pattern.compile("</" + args[0] + ">").matcher(stringBuilder);

        List<Integer> start = new ArrayList<>();
        List<Integer> finish = new ArrayList<>();
        List<String> list = new ArrayList<>();

        while(matcher1.find()) {
            if(stringBuilder.substring(matcher1.start(), matcher1.start() + args[0].length() + 2).equals("<" + args[0] + " ") ||
                    stringBuilder.substring(matcher1.start(), matcher1.start() + args[0].length() + 2).equals("<" + args[0] + ">") ||
                    stringBuilder.substring(matcher1.start(), matcher1.start() + args[0].length() + 3).equals("<" + args[0] + "\r\n")) {
                start.add(matcher1.start());
            }
        }

        while(matcher2.find()) {
            finish.add(matcher2.start());
        }

        getPairs(start, finish, list, stringBuilder, args);

        for(String string : list) {
            System.out.println(string);
        }
    }

    private static void getPairs(List<Integer> start, List<Integer> finish, List<String> list, StringBuilder stringBuilder, String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        boolean b = false;
        int count;
        for(int i = 0; i < start.size(); i++) {
            b = false;
            if(i + 1 < start.size()) {
                if(start.get(i + 1) >= finish.get(i)) {
                    list1.add(start.get(i));
                    list2.add(finish.get(i));
                } else {
                    count = i;
                    while (count + 1 < start.size()) {
                        if (start.get(count + 1) >= finish.get(count)) {
                            list1.add(start.get(i));
                            list2.add(finish.get(count));
                            b = true;
                            break;
                        }
                        count++;
                    }
                    if(!b) {
                        list1.add(start.get(i));
                        list2.add(finish.get(count));
                    }
                    i = count;
                }
            } else {
                list1.add(start.get(i));
                list2.add(finish.get(i));
            }
        }
        for(int i = 0; i < list1.size(); i++) {
            String string = stringBuilder.substring(list1.get(i), list2.get(i) + args[0].length() + 3);
            string = string.replaceAll("\\r\\n", " ");
            list.add(string);
        }
    }
}