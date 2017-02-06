package Habibulin;

import java.io.*;
import java.net.Socket;
import java.util.StringTokenizer;

/**
 * Created by Dreawalker on 05.02.2017.
 */
public class Habibulin_006_HTTPConnect extends Thread {
    private Socket sock;

    Habibulin_006_HTTPConnect(Socket sock) {
        this.sock = sock;
        setPriority(NORM_PRIORITY - 1);
        start();
    }

    public void run() {
        try {
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));

            String req = br.readLine();
            System.out.println("Request: " + req);

            StringTokenizer st = new StringTokenizer(req);
//            if((st.countTokens() >= 2) && st.nextToken().equals("GET")) {
//                if ((req = st.nextToken()).endsWith("/") || req.equals("")) {
//                    req += "index.html";
//                }
                try {
                    File f = new File("D:\\Web\\Hello.html");
                    BufferedReader bfr = new BufferedReader(new FileReader(f));
                    char[] data = new char[(int)f.length()];
                    bfr.read(data);
                    pw.println("HTTP/1.1 200 OK\n");
                    pw.write(data);
                    pw.flush();
                } catch(FileNotFoundException fe) {
                    pw.println("HTTP/1.1 404 Not Found\n");
                } catch(IOException ioe) {
                    System.out.println(ioe);
                }
//            } else {
//                pw.println("HTTP/1.1 400 Bad Request\n");
//            }
            sock.close();
        } catch(IOException e) {
            System.out.println(e);
        }
    }
}
