package Harvard;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Dreawalker on 12.01.2017.
 */
public class Harvard_004_BMPResize {
    public static void main(String[] args) {
        BufferedImage img = null;
        BufferedImage img2 = null;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            img = ImageIO.read(new File("C:\\Users\\Dreawalker\\Downloads\\New\\hacker4\\bmp\\large.bmp"));
            int width = img.getWidth();
            int height = img.getHeight();
            System.out.println("Введите число");
            int n = Integer.parseInt(bufferedReader.readLine());
            img2 = createResizedCopy(img, width * n, height * n, true);

        } catch (IOException e) {
            e.printStackTrace();
        }

        saveBMP(img2);
    }

    public static BufferedImage createResizedCopy(Image originalImage,
                                    int scaledWidth, int scaledHeight,
                                    boolean preserveAlpha)
    {
        System.out.println("resizing...");
        int imageType = preserveAlpha ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
        BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, imageType);
        Graphics2D g = scaledBI.createGraphics();
        if (preserveAlpha) {
            g.setComposite(AlphaComposite.Src);
        }
        g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null);
        g.dispose();
        return scaledBI;
    }

    private static void saveBMP( final BufferedImage bi){
        try {
            RenderedImage rendImage = bi;
            ImageIO.write(rendImage, "bmp", new File("C:\\Users\\Dreawalker\\Downloads\\New\\hacker4\\bmp\\new2.bmp"));
            //ImageIO.write(rendImage, "PNG", new File(path));
            //ImageIO.write(rendImage, "jpeg", new File(path));
        } catch ( IOException e) {
            e.printStackTrace();
        }
    }
}
