package JavaRush.Collection.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution {

    static int foldersQuantity = 0;
    static int filesQuantity = 0;
    static long totalSize = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        if(string == null) {
            System.exit(0);
        }
        Path path = Paths.get(string);
        if(!Files.isDirectory(path)) {
            System.out.println(string + " - не папка");
            System.exit(0);
        }



        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                totalSize += Files.size(file);
                filesQuantity += 1;
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                totalSize += Files.size(dir);
                foldersQuantity += 1;
                return FileVisitResult.CONTINUE;
            }
        });

        foldersQuantity -= 1;
        totalSize -= 4096;

        System.out.println("Всего папок - " + foldersQuantity);
        System.out.println("Всего файлов - " + filesQuantity);
        System.out.println("Общий размер - " + totalSize);
    }
}
