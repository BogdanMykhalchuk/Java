package JavaRush.Collection.task3105;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
//        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(args[1]));
//        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(args[0]));
        ZipInputStream zipIn = new ZipInputStream(new FileInputStream("D:\\Test\\Test.zip"));
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream("D:\\Test\\Test.zip"));
        Map<ZipEntry, byte[]> map = new HashMap<>();
        ZipEntry nextZipEntry;
        while((nextZipEntry = zipIn.getNextEntry()) != null) {
            if (!nextZipEntry.isDirectory()) {
                byte[] bytes = new byte[(int) nextZipEntry.getSize()];
                zipIn.read(bytes);
                map.put(nextZipEntry, bytes);
                zipIn.closeEntry();
            } else {
                map.put(nextZipEntry, null);
            }
        }

        zipIn.close();

        for(ZipEntry zipEntry : map.keySet()) {
            zipOut.putNextEntry(zipEntry);
            if(!zipEntry.isDirectory()) {
                zipOut.write(map.get(zipEntry));
            }
            zipOut.closeEntry();
        }
        ZipEntry zipEntry = new ZipEntry("new\\Test1.txt");
        zipOut.putNextEntry(zipEntry);
        File file = new File("D:\\Test\\Test.txt");
        Files.copy(file.toPath(), zipOut);
        zipOut.close();
    }
}
