package Harvard;

import org.apache.commons.codec.digest.Crypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Bogdan on 07.02.2017.
 */
public class Harvard_002_Decrypt_DES_AddLastLetter {
    public static void main(String[] args) {

        String salt = Character.toString(args[0].charAt(0)) + Character.toString(args[0].charAt(1));
        String encryptedPass;
        String[] pass;
        char[] array;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Bogdan\\Desktop\\Java\\words.txt"));
            String decryptedPass = bufferedReader.readLine();
            while(decryptedPass != null) {
                array = decryptedPass.toCharArray();
                switch (array.length) {
                    case 1: decryptedPass = decryptedPass + array[array.length - 1];
                        encryptedPass = Crypt.crypt(decryptedPass, salt);
                        if (encryptedPass.equals(args[0])) {
                            System.out.println(decryptedPass);
                            System.exit(0);
                        }
                        System.out.println(decryptedPass);
                        decryptedPass = decryptedPass + array[array.length - 1];
                        encryptedPass = Crypt.crypt(decryptedPass, salt);
                        if (encryptedPass.equals(args[0])) {
                            System.out.println(decryptedPass);
                            System.exit(0);
                        }
                        System.out.println(decryptedPass);
                        decryptedPass = decryptedPass + array[array.length - 1];
                        encryptedPass = Crypt.crypt(decryptedPass, salt);
                        if (encryptedPass.equals(args[0])) {
                            System.out.println(decryptedPass);
                            System.exit(0);
                        }
                        System.out.println(decryptedPass);
                        decryptedPass = decryptedPass + array[array.length - 1];
                        encryptedPass = Crypt.crypt(decryptedPass, salt);
                        if (encryptedPass.equals(args[0])) {
                            System.out.println(decryptedPass);
                            System.exit(0);
                        }
                        System.out.println(decryptedPass);
                        decryptedPass = decryptedPass + array[array.length - 1];
                        encryptedPass = Crypt.crypt(decryptedPass, salt);
                        if (encryptedPass.equals(args[0])) {
                            System.out.println(decryptedPass);
                            System.exit(0);
                        }
                        System.out.println(decryptedPass);
                        decryptedPass = decryptedPass + array[array.length - 1];
                        encryptedPass = Crypt.crypt(decryptedPass, salt);
                        if (encryptedPass.equals(args[0])) {
                            System.out.println(decryptedPass);
                            System.exit(0);
                        }
                        System.out.println(decryptedPass);
                        decryptedPass = decryptedPass + array[array.length - 1];
                        encryptedPass = Crypt.crypt(decryptedPass, salt);
                        if (encryptedPass.equals(args[0])) {
                            System.out.println(decryptedPass);
                            System.exit(0);
                        }
                        System.out.println(decryptedPass);
                        break;

                    case 2: decryptedPass = decryptedPass + array[array.length - 1];
                        encryptedPass = Crypt.crypt(decryptedPass, salt);
                        if (encryptedPass.equals(args[0])) {
                            System.out.println(decryptedPass);
                            System.exit(0);
                        }
                        decryptedPass = decryptedPass + array[array.length - 1];
                        encryptedPass = Crypt.crypt(decryptedPass, salt);
                        if (encryptedPass.equals(args[0])) {
                            System.out.println(decryptedPass);
                            System.exit(0);
                        }
                        decryptedPass = decryptedPass + array[array.length - 1];
                        encryptedPass = Crypt.crypt(decryptedPass, salt);
                        if (encryptedPass.equals(args[0])) {
                            System.out.println(decryptedPass);
                            System.exit(0);
                        }
                        decryptedPass = decryptedPass + array[array.length - 1];
                        encryptedPass = Crypt.crypt(decryptedPass, salt);
                        if (encryptedPass.equals(args[0])) {
                            System.out.println(decryptedPass);
                            System.exit(0);
                        }
                        decryptedPass = decryptedPass + array[array.length - 1];
                        encryptedPass = Crypt.crypt(decryptedPass, salt);
                        if (encryptedPass.equals(args[0])) {
                            System.out.println(decryptedPass);
                            System.exit(0);
                        }
                        decryptedPass = decryptedPass + array[array.length - 1];
                        encryptedPass = Crypt.crypt(decryptedPass, salt);
                        if (encryptedPass.equals(args[0])) {
                            System.out.println(decryptedPass);
                            System.exit(0);
                        }
                        break;

                    case 3: decryptedPass = decryptedPass + array[array.length - 1];
                        encryptedPass = Crypt.crypt(decryptedPass, salt);
                        if (encryptedPass.equals(args[0])) {
                            System.out.println(decryptedPass);
                            System.exit(0);
                        }
                        decryptedPass = decryptedPass + array[array.length - 1];
                        encryptedPass = Crypt.crypt(decryptedPass, salt);
                        if (encryptedPass.equals(args[0])) {
                            System.out.println(decryptedPass);
                            System.exit(0);
                        }
                        decryptedPass = decryptedPass + array[array.length - 1];
                        encryptedPass = Crypt.crypt(decryptedPass, salt);
                        if (encryptedPass.equals(args[0])) {
                            System.out.println(decryptedPass);
                            System.exit(0);
                        }
                        decryptedPass = decryptedPass + array[array.length - 1];
                        encryptedPass = Crypt.crypt(decryptedPass, salt);
                        if (encryptedPass.equals(args[0])) {
                            System.out.println(decryptedPass);
                            System.exit(0);
                        }
                        decryptedPass = decryptedPass + array[array.length - 1];
                        encryptedPass = Crypt.crypt(decryptedPass, salt);
                        if (encryptedPass.equals(args[0])) {
                            System.out.println(decryptedPass);
                            System.exit(0);
                        }
                        break;

                    case 4: decryptedPass = decryptedPass + array[array.length - 1];
                        encryptedPass = Crypt.crypt(decryptedPass, salt);
                        if (encryptedPass.equals(args[0])) {
                            System.out.println(decryptedPass);
                            System.exit(0);
                        }
                        decryptedPass = decryptedPass + array[array.length - 1];
                        encryptedPass = Crypt.crypt(decryptedPass, salt);
                        if (encryptedPass.equals(args[0])) {
                            System.out.println(decryptedPass);
                            System.exit(0);
                        }
                        decryptedPass = decryptedPass + array[array.length - 1];
                        encryptedPass = Crypt.crypt(decryptedPass, salt);
                        if (encryptedPass.equals(args[0])) {
                            System.out.println(decryptedPass);
                            System.exit(0);
                        }
                        decryptedPass = decryptedPass + array[array.length - 1];
                        encryptedPass = Crypt.crypt(decryptedPass, salt);
                        if (encryptedPass.equals(args[0])) {
                            System.out.println(decryptedPass);
                            System.exit(0);
                        }
                        break;

                    case 5: decryptedPass = decryptedPass + array[array.length - 1];
                        encryptedPass = Crypt.crypt(decryptedPass, salt);
                        if (encryptedPass.equals(args[0])) {
                            System.out.println(decryptedPass);
                            System.exit(0);
                        }
                        decryptedPass = decryptedPass + array[array.length - 1];
                        encryptedPass = Crypt.crypt(decryptedPass, salt);
                        if (encryptedPass.equals(args[0])) {
                            System.out.println(decryptedPass);
                            System.exit(0);
                        }
                        decryptedPass = decryptedPass + array[array.length - 1];
                        encryptedPass = Crypt.crypt(decryptedPass, salt);
                        if (encryptedPass.equals(args[0])) {
                            System.out.println(decryptedPass);
                            System.exit(0);
                        }
                        break;

                    case 6: decryptedPass = decryptedPass + array[array.length - 1];
                        encryptedPass = Crypt.crypt(decryptedPass, salt);
                        if (encryptedPass.equals(args[0])) {
                            System.out.println(decryptedPass);
                            System.exit(0);
                        }
                        decryptedPass = decryptedPass + array[array.length - 1];
                        encryptedPass = Crypt.crypt(decryptedPass, salt);
                        if (encryptedPass.equals(args[0])) {
                            System.out.println(decryptedPass);
                            System.exit(0);
                        }
                        break;

                    case 7: decryptedPass = decryptedPass + array[array.length - 1];
                        encryptedPass = Crypt.crypt(decryptedPass, salt);
                        if (encryptedPass.equals(args[0])) {
                            System.out.println(decryptedPass);
                            System.exit(0);
                        }
                        break;
                }
//                System.out.println(decryptedPass);
                decryptedPass = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
