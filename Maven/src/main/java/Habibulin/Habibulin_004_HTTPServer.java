package Habibulin;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by Bogdan on 02.02.2017.
 */
public class Habibulin_004_HTTPServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(Integer.parseInt(args[0]));
            while(true) {
                new Habibulin_006_HTTPConnect(ss.accept());
            }
        } catch(ArrayIndexOutOfBoundsException ae) {
            System.err.println("Usage: Srver port");
            System.exit(0);
        } catch(IOException e) {
            System.out.println(e);
        }
    }
}
