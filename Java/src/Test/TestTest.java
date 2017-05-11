package Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public final class TestTest {

    public static void main(String[] args) {
        Path root = Paths.get("D:\\Test\\");
        Path path = Paths.get("D:\\Test\\Temp\\create\\yandex19-logo-ru.png");
        System.out.println(root.relativize(path));
    }
}


