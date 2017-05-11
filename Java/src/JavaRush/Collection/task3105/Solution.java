package JavaRush.Collection.task3105;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        Path fileToAdd = Paths.get("D:\\Test\\111.txt");
        Map<ZipEntry, ByteArrayOutputStream> map = new HashMap<>();
        ZipEntry zipEntry;
        try(ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream("D:\\Test\\Test.zip"))) {
            zipEntry = zipInputStream.getNextEntry();
            while (zipEntry != null) {
                if (!zipEntry.isDirectory()) {
                    try (ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream()) {
                        int bytesRead;
                        byte[] buffer = new byte[8192];
                        while ((bytesRead = zipInputStream.read(buffer)) != -1) {
                            byteOutputStream.write(buffer, 0, bytesRead);
                        }
                        map.put(zipEntry, byteOutputStream);
                    }
                    zipInputStream.closeEntry();
                }
                zipEntry = zipInputStream.getNextEntry();
            }
        }

        try(ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream("D:\\Test\\Test.zip"))) {
            boolean b = true;
            for(ZipEntry zipEntry1 : map.keySet()) {
                String zipEntryName = Paths.get(zipEntry1.getName()).toFile().getName();
                String fileToAddName = fileToAdd.getFileName().toString();
                if(!zipEntryName.equals(fileToAddName)) {
                    zipOutputStream.putNextEntry(zipEntry1);
                    zipOutputStream.write(map.get(zipEntry1).toByteArray());
                    zipOutputStream.closeEntry();
                } else {
                    b = false;
                }
            }
            if(b) {
                zipEntry = new ZipEntry("new\\" + fileToAdd.getFileName());
                zipOutputStream.putNextEntry(zipEntry);
                Files.copy(fileToAdd, zipOutputStream);
                zipOutputStream.closeEntry();
            }
        }
    }
}
