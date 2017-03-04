package Habibulin;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;

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
            DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));

            String req = br.readLine();
            System.out.println("Request: " + req);

            String[] array = null;
            if(req != null) {
                array = req.split(" ");
            }
            String[] temp = null;
            if(array != null) {
                temp = array[1].split("\\.");
            }
            System.out.println(Arrays.toString(temp));

            if(array != null && array.length > 2 && array[0].equals("GET") && array[1].equals("/")) {
                try {
                    File f = new File("D:\\Web\\Hello.html");
                    BufferedReader bfr = new BufferedReader(new FileReader(f));
                    char[] data = new char[(int) f.length()];
                    bfr.read(data);
                    pw.println("HTTP/1.1 200 OK\n");
                    pw.write(data);
                    pw.flush();
                } catch (FileNotFoundException fe) {
                    pw.println("HTTP/1.1 404 Not Found\n");
                } catch (IOException ioe) {
                    System.out.println(ioe);
                }
            }

            else if(array != null && array.length > 2 && array[0].equals("GET") && !array[1].equals("/") && (temp[1].equals("css")
                    || temp[1].equals("html"))) {
                req = array[1].substring(1);
                req = "D:\\Web\\" + req;
                System.out.println(req);
                try {
                    File f = new File(req);
                    BufferedReader bfr = new BufferedReader(new FileReader(f));
                    char[] data = new char[(int) f.length()];
                    bfr.read(data);
                    pw.println("HTTP/1.1 200 OK\n");
                    pw.write(data);
                    pw.flush();
                } catch (FileNotFoundException fe) {
                    pw.println("HTTP/1.1 404 Not Found\n");
                } catch (IOException ioe) {
                    System.out.println(ioe);
                }
            }

            else if(array != null && array.length > 2 && array[0].equals("GET") && !array[1].equals("/")) {
                req = array[1].substring(1);
                req = "D:\\Web\\" + req;
                System.out.println(req);
                try {
                    File file = new File(req);
                    FileInputStream fis = new FileInputStream(file);
                    byte[] data = new byte[(int) file.length()];
                    fis.read(data);
                    fis.close();

                    dos.writeBytes("HTTP/1.0 200 OK\r\n");
                    dos.writeBytes("Content-Type: image/" + temp[1] + "\r\n");
                    dos.writeBytes("Content-Length: " + data.length);
                    dos.writeBytes("\r\n\r\n");
                    dos.write(data);

                    dos.close();
                } catch(FileNotFoundException fe) {
                    pw.println("HTTP/1.1 404 Not Found\n");
                } catch(IOException ioe) {
                    System.out.println(ioe);
                }
            } else {
                pw.println("HTTP/1.1 400 Bad Request\n");
            }
            sock.close();
        } catch(IOException e) {
            System.out.println(e);
        }
    }
}
