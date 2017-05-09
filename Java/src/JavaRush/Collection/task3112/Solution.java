package JavaRush.Collection.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://yastatic.net/morda-logo/i/citylogos/yandex19-logo-ru.png",
                Paths.get("D:/Test/Temp/create"));
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        URL url = new URL(urlString);
        Path tempFile = Files.createTempFile(null, null);
        InputStream inputStream = url.openStream();
        Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);
        String[] array = urlString.split("/");
        String newPath = downloadDirectory.toString() + "/" + array[array.length - 1];
        Path newFile = Paths.get(newPath);
        Files.move(tempFile, newFile);
        return newFile;
    }
}
