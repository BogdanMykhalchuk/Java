package Harvard;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Dreawalker on 09.01.2017.
 */
public class Harvard_004_BMPRemovingNoise {
    public static void main(String[] args) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("C:\\Users\\Dreawalker\\Downloads\\New\\hacker4\\bmp\\clue.bmp"));
            int width = img.getWidth();
            int height = img.getHeight();
            int[] pixels = new int[width * height];
            img.getRGB(0, 0, width, height, pixels, 0, width);
            System.out.println(Arrays.toString(pixels));

            for (int i = 0; i < pixels.length; i++) {
                // I used capital F's to indicate that it's the alpha value.
                if (pixels[i] == -65536) {
                    // We'll set the alpha value to 0 for to make it fully transparent.
                 //   pixels[i] = 0x000000ff;
                    pixels[i] = -1247498;
                }
            }
            img.setRGB(0, 0, width, height, pixels, 0, width);

        } catch (IOException e) {
            e.printStackTrace();
        }

        saveBMP(img);
    }

    private static void saveBMP( final BufferedImage bi){
        try {
            RenderedImage rendImage = bi;
            ImageIO.write(rendImage, "bmp", new File("C:\\Users\\Dreawalker\\Downloads\\New\\hacker4\\bmp\\new1.bmp"));
            //ImageIO.write(rendImage, "PNG", new File(path));
            //ImageIO.write(rendImage, "jpeg", new File(path));
        } catch ( IOException e) {
            e.printStackTrace();
        }
    }
}
