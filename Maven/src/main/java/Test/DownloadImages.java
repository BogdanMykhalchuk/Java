package Test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Created by Bogdan on 12.05.2017.
 */
public class DownloadImages {
    public static void main(String[] args)throws IOException {
//        Path source = Paths.get("D:/01.jpg");
//        Path destination = Paths.get("\\\\192.168.1.68\\сеть вова\\Test\\01.jpg");
//        Files.copy(source, destination);
        Document doc = null;
        try {
            doc = Jsoup.connect("http://www.jpegworld.com/categories/8/babes/").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(doc != null) {
            Elements img = doc.getElementsByTag("img");
            if(img != null) {
                for (Element el : img) {
                    URL url = new URL(el.attr("src"));
                    InputStream inputStream = url.openStream();
                    String[] array = el.attr("src").split("/");
                    String destination = "\\\\192.168.1.68\\сеть вова\\Test\\" + array[array.length - 1];     //Vova
//                    String destination = "\\\\192.168.1.27\\temp\\Test\\" + array[array.length - 1];        //Bercos
                    if (destination.endsWith(".jpeg") || destination.endsWith(".jpg") || destination.endsWith(".gif") || destination.endsWith(".png")) {
                        Path path = Paths.get(destination);
                        Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
