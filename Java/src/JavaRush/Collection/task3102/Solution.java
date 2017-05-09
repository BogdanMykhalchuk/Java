package JavaRush.Collection.task3102;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> list = new ArrayList<>();
        Files.walkFileTree(Paths.get(root), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                list.add(file.toString());
                return FileVisitResult.CONTINUE;
            }
        });
        return list;

    }

    public static void main(String[] args) {
        try {
            for (String string : getFileTree("D:\\Test\\Temp")) {
                System.out.println(string);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
