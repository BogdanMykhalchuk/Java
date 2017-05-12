package JavaRush.Collection.task3109;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        Properties properties = new Properties();
        String[] array = fileName.split("/");
        String fileNameShort = array[array.length - 1];
        System.out.println(fileNameShort);
        try (FileInputStream fis = new FileInputStream(fileName)){
            if(fileNameShort.endsWith(".xml")) {
                properties.loadFromXML(fis);
            } else {
                properties.load(fis);
            }
        } catch(Exception e) {
            return new Properties();
        }
        return properties;
    }
}
