package JavaRush.Collection.task3210;

/*
Используем RandomAccessFile
*/

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Solution {
    public static void main(String... args) {
        File file = new File(args[0]);
        int start = Integer.parseInt(args[1]);
        String stringToCompare = args[2];
        try(RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw")) {
            long fileLength = randomAccessFile.length();
            if(start + stringToCompare.length() > fileLength) {
                randomAccessFile.seek(fileLength);
                randomAccessFile.write("false".getBytes());
            } else {
                byte[] bytes = new byte[stringToCompare.length()];
                randomAccessFile.seek(start);
                randomAccessFile.read(bytes, 0, stringToCompare.length());
                String readText = convertByteToString(bytes);
                System.out.println(readText);
                randomAccessFile.seek(fileLength);
                if (readText.equals(stringToCompare)) {
                    randomAccessFile.write("true".getBytes());
                } else {
                    randomAccessFile.write("false".getBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String convertByteToString(byte[] readBytes)
    {
        return new String(readBytes);
    }
}
