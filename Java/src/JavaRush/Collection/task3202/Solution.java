package JavaRush.Collection.task3202;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        if(is == null) {
            return new StringWriter();
        }
        StringWriter stringWriter = new StringWriter();
        byte[] bytes = new byte[1024];
        int i;
        while((i = is.read(bytes)) > 0) {
            String temp = new String(bytes, 0, i);
            stringWriter.write(temp);
        }
        return stringWriter;
    }
}