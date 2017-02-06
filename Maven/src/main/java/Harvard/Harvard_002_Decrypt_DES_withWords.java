package Harvard;

import org.apache.commons.codec.digest.Crypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Dreawalker on 17.01.2017.
 */
public class Harvard_002_Decrypt_DES_withWords {
    public static void main(String[] args) {

        char[] array = new char[95];
        for (int i = 0; i < 95; i++) {
            array[i] = (char) (i + 32);
        }
        //char[] array = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        String salt = Character.toString(args[0].charAt(0)) + Character.toString(args[0].charAt(1));
        String encryptedPass;
        String decryptedPass;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Dreawalker\\Downloads\\" +
                    "New\\words.txt"));
            String readLine = bufferedReader.readLine();
            while(readLine != null) {

                encryptedPass = Crypt.crypt(readLine, salt);
                if (encryptedPass.equals(args[0])) {
                    System.out.println(readLine);
                    System.exit(0);
                }

//                if(readLine.length() == 4) {
//                    for (char anArray : array) {
//                        for (char anArray1 : array) {
//                            for (char anArray2 : array) {
//                                for (char anArray3 : array) {
//                                    decryptedPass = readLine + Character.toString(anArray) +
//                                            Character.toString(anArray1) + Character.toString(anArray2) +
//                                            Character.toString(anArray3);
//                                    encryptedPass = Crypt.crypt(decryptedPass, salt);
//                                    if (encryptedPass.equals(args[0])) {
//                                        System.out.println(decryptedPass);
//                                        System.exit(0);
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
                if(readLine.length() == 5) {
                    for (char anArray : array) {
                        for (char anArray1 : array) {
                            for (char anArray2 : array) {
                                decryptedPass = readLine + Character.toString(anArray) +
                                        Character.toString(anArray1) + Character.toString(anArray2);
                                encryptedPass = Crypt.crypt(decryptedPass, salt);
                                if (encryptedPass.equals(args[0])) {
                                    System.out.println(decryptedPass);
                                    System.exit(0);
                                }
                            }
                        }
                    }
                }
                else if(readLine.length() == 6) {
                    for (char anArray1 : array) {
                        for (char anArray : array) {
                            decryptedPass = readLine + Character.toString(anArray1) + Character.toString(anArray);
                            encryptedPass = Crypt.crypt(decryptedPass, salt);
                            if (encryptedPass.equals(args[0])) {
                                System.out.println(decryptedPass);
                                System.exit(0);
                            }
                        }
                    }
                }
                else if(readLine.length() == 7) {
                    for (char anArray1 : Harvard_002_Decrypt_Brute_Force.array) {
                        decryptedPass = readLine + Character.toString(anArray1);
                        encryptedPass = Crypt.crypt(decryptedPass, salt);
                        if (encryptedPass.equals(args[0])) {
                            System.out.println(decryptedPass);
                            System.exit(0);
                        }
                    }
                }

                readLine = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
