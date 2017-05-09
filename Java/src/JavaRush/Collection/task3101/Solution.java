package JavaRush.Collection.task3101;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
Проход по дереву файлов
*/
public class Solution {

    private static List<File> files = new ArrayList<>();

    public static void main(String[] args) {

        File directory = new File(args[0]);
        File outPut = new File(args[1]);
        File destination = new File(outPut.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(outPut, destination);
        addFilesToList(directory);
        files.sort(new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        try(FileOutputStream fos = new FileOutputStream(destination)) {
            for(File file : files) {
                FileInputStream fis = new FileInputStream(file);
                int i;
                byte[] bytes = new byte[2000];
                while(fis.available() > 0) {
                    i = fis.read(bytes);
                    fos.write(bytes, 0, i);
                }
                fos.write('\n');
                fis.close();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private static void addFilesToList(File directory) {
        File[] fileArray = directory.listFiles();
        if(fileArray != null) {
            for (File file : fileArray) {
                if (file != null) {
                    if (file.isDirectory()) {
                        addFilesToList(file);
                    } else {
                        if (file.length() > 2000) {
                            FileUtils.deleteFile(file);
                        } else {
                            files.add(file);
                        }
                    }
                }
            }
        }
    }
}
