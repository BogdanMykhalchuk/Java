package JavaRush.Collection.task3204;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        try(BufferedWriter bf = new BufferedWriter(new FileWriter("D:\\Test\\Temp\\Test1.txt"))) {
            for (int i = 0; i < 1000; i++) {
                ByteArrayOutputStream password = getPassword();
                String string = password.toString();
                System.out.println(string);
                bf.write(string);
                bf.write("\n");
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 8; i++) {
            Random random = new Random();
            int j =  random.nextInt(3);
            int k;
            switch(j) {
                case 0: k = random.nextInt(10); sb.append(k); break;
                case 1: k = random.nextInt(10) + 65 + random.nextInt(17); sb.append((char)k); break;
                case 2: k = random.nextInt(10) + 97 + random.nextInt(17); sb.append((char)k);
            }
        }
        String string = sb.toString();
        byte[] bytes = string.getBytes();
        try {
            byteArrayOutputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream;
    }
}