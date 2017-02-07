package Habibulin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Bogdan on 07.02.2017.
 */
public class Habibulin_004_GetWebPage {
    public static void main(String[] args){
        try{
            URL bhv = new URL("http://www.bhv.ru/");
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(bhv.openStream()));
            String line = null;
            while ((line = br.readLine()) != null)
                System.out.println(line);
            br.close();
        }catch(MalformedURLException me){
            System.err.println("Unknown host: " + me);
            System.exit(0);
        }catch(IOException ioe){
            System.err.println("Input error: " + ioe);
        }
    }
}
