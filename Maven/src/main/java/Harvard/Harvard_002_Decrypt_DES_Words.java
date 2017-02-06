package Harvard;

import org.apache.commons.codec.digest.Crypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Dreawalker on 17.01.2017.
 */
public class Harvard_002_Decrypt_DES_Words {

    public static void main(String[] args) {

        String salt = Character.toString(args[0].charAt(0)) + Character.toString(args[0].charAt(1));
        String encryptedPass;
        String[] pass;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Dreawalker\\Downloads\\" +
                    "New\\10-million-combos.txt"));
            String decryptedPass = bufferedReader.readLine();
            while(decryptedPass != null) {
                pass = decryptedPass.split("\t");
               // System.out.println(Arrays.toString(pass));
                if(pass.length < 2) {

                } else {
                    decryptedPass = pass[1];
                    encryptedPass = Crypt.crypt(decryptedPass, salt);
                    if (encryptedPass.equals(args[0])) {
                        System.out.println(decryptedPass);
                        System.exit(0);
                    }
                }
                decryptedPass = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
