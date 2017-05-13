package JavaRush.Collection.task3106;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) {
        Path resultPath = Paths.get(args[0]);
        File resultFile = resultPath.toFile();
        Path tempPath = Paths.get(args[1]);
        String stringTempFile = tempPath.toString().substring(tempPath.toString().lastIndexOf("."));
        File tempFile = null;
        try {
            tempFile = File.createTempFile("111", null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Path> pathList = new ArrayList<>();
        for(int i = 1; i < args.length; i++) {
            pathList.add(Paths.get(args[i]));
        }
        pathList.sort(new Comparator<Path>() {
            @Override
            public int compare(Path o1, Path o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });
        try(FileOutputStream fos = new FileOutputStream(tempFile)) {
            for(Path path : pathList) {
                try(FileInputStream fis = new FileInputStream(path.toFile())) {
                    byte[] bytes = new byte[1024 * 8];
                    int i;
                    while((i = fis.read(bytes)) > 0) {
                        fos.write(bytes, 0, i);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(FileOutputStream fos = new FileOutputStream(resultFile);
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(tempFile))) {
            ZipEntry zipEntry = zipInputStream.getNextEntry();
            byte[] bytes = new byte[1024 * 8];
            int i;
            while((i = zipInputStream.read(bytes)) > 0) {
                fos.write(bytes, 0, i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
