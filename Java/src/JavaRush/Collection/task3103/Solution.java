package JavaRush.Collection.task3103;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/* 
Своя реализация
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(readBytes("D:/Test/Test.txt")));
        System.out.println(readLines("D:/Test/Test.txt").toString());
        byte[] bytes = {1, 2, 3, 4, 5, 6};
        writeBytes("D:/Test/Test24.txt", bytes);
        copy("D:/Test/Test.txt", "D:/Test/Test25.txt");
    }

    public static byte[] readBytes(String fileName) throws IOException {
        return Files.readAllBytes(Paths.get(fileName));
    }

    public static List<String> readLines(String fileName) throws IOException {
        return Files.readAllLines(Paths.get(fileName), Charset.defaultCharset());
    }

    public static void writeBytes(String fileName, byte[] bytes) throws IOException {
        Files.write(Paths.get(fileName), bytes);
    }

    public static void copy(String resourceFileName, String destinationFileName) throws IOException {
        Files.copy(Paths.get(resourceFileName), Paths.get(destinationFileName));
    }
}
