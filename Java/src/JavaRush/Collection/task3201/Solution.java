package JavaRush.Collection.task3201;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) {
        File file = new File(args[0]);
        long marker = Long.parseLong(args[1]);
        String stringToWrite = args[2];
        try(RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw")) {
            long fileLength = randomAccessFile.length();
            if(marker > fileLength) {
                randomAccessFile.seek(fileLength);
                randomAccessFile.writeBytes(stringToWrite);
            } else {
                randomAccessFile.seek(marker);
                randomAccessFile.writeBytes(stringToWrite);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
