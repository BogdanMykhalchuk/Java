package Habibulin;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Dreawalker on 31.01.2017.
 */
public class Habibulin_001_SentStringByURL {
    public static void main(String[] args) {
        String string = "?q=фыв";
        try {
            URL url = new URL("http://google.com.ua/search/");
            URLConnection uc = url.openConnection();
            uc.setDoOutput(true);
            uc.setDoInput(true);
            uc.setUseCaches(false);
            uc.setRequestProperty("content-type", "application/octet-stream");
            uc.setRequestProperty("content-length", "" + string.length());
            uc.connect();

            DataOutputStream dos = new DataOutputStream(uc.getOutputStream());
            dos.writeBytes(string);
            dos.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            String response = null;
            while((response = br.readLine()) != null) {
                System.out.println(response);
            }
            br.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
