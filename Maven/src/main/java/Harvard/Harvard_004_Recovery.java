package Harvard;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Bogdan on 07.02.2017.
 */
public class Harvard_004_Recovery {
    private static int count = 0;
    public static void main(String[] args) {
        byte[] data = null;
        File file = new File("C:\\Users\\Bogdan\\Desktop\\Java\\hacker4\\jpg\\card.raw");
        Path path = Paths.get(file.getAbsolutePath());
        try {
            data = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (data != null) {
            for(int i = 0; i < data.length; i++) {
                if(checkData(data, i)) {
                    count++;
                    writeToFile(data, i);
                }
            }
        }
    }

    private static boolean checkForthByte(byte theByte) {
        byte[] arrayTemp = {(byte)0xe0, (byte)0xe1, (byte)0xe2, (byte)0xe3, (byte)0xe4, (byte)0xe5, (byte)0xe6,
                (byte)0xe7, (byte)0xe8, (byte)0xe8, (byte)0xe9, (byte)0xea, (byte)0xeb,
                (byte)0xec, (byte)0xed, (byte)0xee, (byte)0xef};
        for (int theInt : arrayTemp) {
            if(theByte == theInt) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkData(byte[] array, int i) {
        if(array[i] == (byte)0xff && i + 1 < array.length) {
            if(array[i + 1] == (byte)0xd8 && i + 2 < array.length) {
                if(array[i + 2] == (byte)0xff && i + 3 < array.length) {
                    if(checkForthByte(array[i + 3])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static void writeToFile(byte[] array, int i) {
        FileOutputStream fileOutputStream = null;
//        ArrayList<Byte> arrayList = null;
//        char[] arrayTemp;
        try {
            fileOutputStream = new FileOutputStream("C:\\Users\\Bogdan\\Desktop\\Java\\hacker4\\jpg\\" +
                    "Image\\" + count + ".jpeg");
            fileOutputStream.write(array[i]);
            if(i + 1 < array.length) {
                for(int j = i + 1; j < array.length; j++) {
                    if (!checkData(array, j)) {
                        //                    arrayList.add(array[j]);
                        fileOutputStream.write(array[j]);
                    } else {
                        fileOutputStream.close();
                        return;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
