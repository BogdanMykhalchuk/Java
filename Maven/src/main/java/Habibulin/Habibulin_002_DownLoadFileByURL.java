package Habibulin;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Dreawalker on 31.01.2017.
 */
public class Habibulin_002_DownLoadFileByURL {
    public static void main(String[] args) {
        String string = "This text is posting to URL";
        try {
            URL url = new URL("http://ic1.static.km.ru/sites/default/files/img/news/2014/7/3/grumpy-cat-14.jpg");
            URLConnection uc = url.openConnection();
            uc.connect();

            BufferedInputStream br = new BufferedInputStream(uc.getInputStream());
            File file = new File("D:\\Cat.jpg");
            FileOutputStream fw = new FileOutputStream(file);

            byte[] array = new byte[1024];
            int i;

            while((i = br.read(array, 0, 1024)) != -1) {
                fw.write(array, 0, i);
            }
            br.close();
            fw.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
