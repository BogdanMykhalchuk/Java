package Harvard;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Dreawalker on 15.01.2017.
 */
public class Harvard_004_JPEGRecovery {
    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\Dreawalker\\Downloads\\New\\hacker4\\jpg\\card.raw");
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()) {
                for(int i = 0; i < 512; i++) {

                }
            }
                startScan:
                    while(scanner.hasNext()) {
                        if(scanner.nextByte() == 0xff) {
                            while(scanner.hasNext()) {
                                if(scanner.nextByte() == 0xd8) {
                                    while(scanner.hasNext()) {
                                        if(scanner.nextByte() == 0xff) {
                                            while(scanner.hasNext()) {
                                                if (scanner.nextByte() == 0xff) {

                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
