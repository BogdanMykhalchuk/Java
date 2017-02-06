package Habibulin;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by Dreawalker on 06.02.2017.
 */
public class Habibulin_003_UDPClient {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket(1050);
            while(true) {
                DatagramPacket pack = new DatagramPacket(new byte[1024], 1024);
                ds.receive(pack);
                System.out.println(new String(pack.getData()));
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
