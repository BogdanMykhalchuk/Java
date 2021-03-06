package Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public final class TestTest {

    public static void main(String[] args) {
        File file = new File("D:\\Test\\AutoGenerated.Properties");

//создаем объект Properties и загружаем в него данные из файла.
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(file));
        } catch (IOException e) {
            e.printStackTrace();
        }

//проходимся по всем ключам и печатаем все их значения на консоль
        for (String key : properties.stringPropertyNames())
        {
            System.out.println(properties.get(key));
        }
    }
}


