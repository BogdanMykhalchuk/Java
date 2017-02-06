package Harvard;

import org.apache.commons.codec.digest.Crypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.Character.toUpperCase;

/**
 * Created by Dreawalker on 18.01.2017.
 */
public class Harvard_002_Decrypt_DES_WordsBigLetters {
    public static void main(final String[] args) throws Exception {

        if (args.length != 1) {
            System.exit(1);
        }

        char[] array = new char[95];
        for (int i = 0; i < 95; i++) {
            array[i] = (char) (i + 32);
        }

        String decryptedPass;
        String encryptedPass;
        final String salt = Character.toString(args[0].charAt(0)) + Character.toString(args[0].charAt(1));
        String[] pass;
        char[] arrayTemp;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Dreawalker\\Downloads\\" +
                    "New\\10-million-combos.txt"));
            decryptedPass = bufferedReader.readLine();
            while(decryptedPass != null) {
                pass = decryptedPass.split("\t");
                // System.out.println(Arrays.toString(pass));
                if(pass.length < 2) {

                } else {
                    decryptedPass = pass[1];
                    arrayTemp = decryptedPass.toCharArray();
                    arrayTemp[0] = toUpperCase(arrayTemp[0]);
                    arrayTemp[arrayTemp.length -  1] = toUpperCase(arrayTemp[arrayTemp.length -  1]);
                    decryptedPass = arrayTemp.toString();
                    encryptedPass = Crypt.crypt(decryptedPass, salt);
                    if (encryptedPass.equals(args[0])) {
                        System.out.println(decryptedPass);
                        System.exit(0);
                    }
                }
                decryptedPass = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Dreawalker\\Downloads\\" +
                    "New\\words.txt"));
            decryptedPass = bufferedReader.readLine();
            while(decryptedPass != null) {
                arrayTemp = decryptedPass.toCharArray();
//                System.out.println(Arrays.toString(arrayTemp));
                arrayTemp[0] = toUpperCase(arrayTemp[0]);
                arrayTemp[arrayTemp.length -  1] = toUpperCase(arrayTemp[arrayTemp.length -  1]);
                decryptedPass = arrayTemp.toString();
                encryptedPass = Crypt.crypt(decryptedPass, salt);
                if (encryptedPass.equals(args[0])) {
                    System.out.println(decryptedPass);
                    System.exit(0);
                }
                decryptedPass = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
