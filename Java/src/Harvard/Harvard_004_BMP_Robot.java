package Harvard;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Dreawalker on 08.01.2017.
 */
public class Harvard_004_BMP_Robot {
    public static void main(String args[]) {
        BufferedImage img = map( 260, 320 );
        savePNG( img, "D:\\Job\\Java\\src\\com\\company\\harvard\\test.bmp" );
    }

    private static BufferedImage map(int sizeX, int sizeY ){
        final BufferedImage res = new BufferedImage( sizeX, sizeY, BufferedImage.TYPE_INT_RGB );
        for (int x = 0; x < sizeX; x++){
            for (int y = 0; y < sizeY; y++){
                res.setRGB(x, y, Color.WHITE.getRGB() );
            }
        }
        for (int x = 95; x < 115; x++){
            for (int y = 30; y < 50; y++){
                res.setRGB(x, y, Color.GREEN.getRGB() );
            }
        }

        for (int x = 60; x < 200; x++){
            for (int y = 10; y < 15; y++){
                res.setRGB(x, y, Color.GREEN.getRGB() );
            }
        }

        for (int x = 60; x < 65; x++){
            for (int y = 15; y < 155; y++){
                res.setRGB(x, y, Color.GREEN.getRGB() );
            }
        }

        for (int x = 195; x < 200; x++){
            for (int y = 15; y < 155; y++){
                res.setRGB(x, y, Color.GREEN.getRGB() );
            }
        }

        for (int x = 60; x < 200; x++){
            for (int y = 150; y < 155; y++){
                res.setRGB(x, y, Color.GREEN.getRGB() );
            }
        }

        for (int x = 145; x < 165; x++){
            for (int y = 30; y < 50; y++){
                res.setRGB(x, y, Color.GREEN.getRGB() );
            }
        }

        int start = 0;
        int z = 1;
        beginning:
        for (int y = 60; y < 85; y++){
            while(start < 25) {
                for (int x = 130 - start; x < 130 + 1 + start; x++) {
                    res.setRGB(x, y, Color.GREEN.getRGB());
                }
                start++;
                continue beginning;
            }
        }

        for (int x = 80; x < 180; x++){
            for (int y = 110; y < 125; y++){
                res.setRGB(x, y, Color.GREEN.getRGB() );
            }
        }

        return res;
    }

    private static void savePNG( final BufferedImage bi, final String path ){
        try {
            RenderedImage rendImage = bi;
            ImageIO.write(rendImage, "bmp", new File(path));
            //ImageIO.write(rendImage, "PNG", new File(path));
            //ImageIO.write(rendImage, "jpeg", new File(path));
        } catch ( IOException e) {
            e.printStackTrace();
        }
    }
}
