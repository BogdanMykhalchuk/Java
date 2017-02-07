package Harvard;

import org.apache.commons.codec.digest.Crypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Bogdan on 07.02.2017.
 */
public class Harvard_002_Decrypt_DES_ReverseWords {
    public static void main(String[] args) {

        String salt = Character.toString(args[0].charAt(0)) + Character.toString(args[0].charAt(1));
        String encryptedPass;
        String[] pass;
        char[] array;
        char[] arayReversed;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Bogdan\\Desktop\\Java\\words.txt"));
            String decryptedPass = bufferedReader.readLine();
            while(decryptedPass != null) {
//                pass = decryptedPass.split("\t");
//                // System.out.println(Arrays.toString(pass));
//                if(pass.length < 2) {
//
//                } else {
                //                  decryptedPass = pass[1];
                array = decryptedPass.toCharArray();
                System.out.println(Arrays.toString(array));
                arayReversed = new char[array.length];
                for(int i = 0; i < arayReversed.length; i++) {
                    arayReversed[i] = array[array.length - 1 - i];
                }
                System.out.println(Arrays.toString(arayReversed));
                decryptedPass = arayReversed.toString();
                encryptedPass = Crypt.crypt(decryptedPass, salt);
                if (encryptedPass.equals(args[0])) {
                    System.out.println(decryptedPass);
                    System.exit(0);
                }
                //              }
                decryptedPass = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
