package Test;

import java.awt.*;
import java.awt.image.MemoryImageSource;

/**
 * Created by Dreawalker on 13.11.2016.
 */
public class Test_002_Cursor {
    public static void main(String[] args) {

        Toolkit tk = Toolkit.getDefaultToolkit();
        int colorMax = tk.getMaximumCursorColors(); // Наибольшее число цветов.
        Dimension d = tk.getBestCursorSize(50, 50); // d — размер изображения.
        int w = d.width, h = d.height, k = 0;
        Point p = new Point(0, 0); // Фокус курсора будет
        // в его верхнем левом углу.
        int[] pix = new int[w * h]; // Здесь будут пикселы изображения.
        for (int i = 0; i < w; i++)
            for (int j = 0; j < h; j++)
                if (j < i) pix[k++] = 0xFFFF0000; // Левый нижний угол — красный.
                else pix[k++] = 0; // Правый верхний угол — прозрачный.
        // Создается прямоугольное изображение размером (w, h),
        // заполненное массивом пикселов pix, с длиной строки w.
        Image im = tk.createImage(new MemoryImageSource(w, h, pix, 0, w));
        Cursor curs = tk.createCustomCursor(im, p, null);
        Test_001_AWT component = new Test_001_AWT();
        component.setCursor(curs);

    }
}
