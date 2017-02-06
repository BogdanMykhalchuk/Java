package Habibulin;

import java.io.IOException;
import java.net.*;

/**
 * Created by Dreawalker on 06.02.2017.
 */
public class Habibulin_004_UDPSender {

    private String host;
    private int port;

    Habibulin_004_UDPSender(String host, int port) {
        this.host = host;
        this.port = port;
    }

    private void sendMessage(String mes) {
        byte[] data = mes.getBytes();
        try {
            InetAddress addr = InetAddress.getByName(host);
            DatagramPacket pack = new DatagramPacket(data, data.length, addr, port);
            DatagramSocket ds = new DatagramSocket();
            ds.send(pack);
            ds.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Habibulin_004_UDPSender sender = new Habibulin_004_UDPSender("localhost", 1050);
        for(int i = 0; i < args.length; i++) {
            sender.sendMessage(args[i]);
        }
    }
}
