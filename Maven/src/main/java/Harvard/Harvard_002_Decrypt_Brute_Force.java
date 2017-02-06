package Harvard;

import org.apache.commons.codec.digest.Crypt;

/**
 * Created by Dreawalker on 15.01.2017.
 */
public class Harvard_002_Decrypt_Brute_Force {

    static char[] array = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

//    static {
//        array = new char[95];
//        for (int i = 0; i < 95; i++) {
//            array[i] = (char) (i + 32);
//        }
//    }
    public static void main(final String[] args) throws Exception {

        if (args.length != 1) {
            System.exit(1);
        }

        String decryptPass;
        String encryptPass;
        final String salt = Character.toString(args[0].charAt(0)) + Character.toString(args[0].charAt(1));

//        String[] array = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
//        "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
//        "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

//        char[] array = new char[95];
//        for (int i = 0; i < 95; i++) {
//            array[i] = (char) (i + 32);
//        }

        Thread myThread = new Thread(new Runnable() {
            public void run() {


                String decryptPass;
                String encryptPass;

                for (char anArray1 : Harvard_002_Decrypt_Brute_Force.array) {
                    decryptPass = Character.toString(anArray1);
                    encryptPass = Crypt.crypt(decryptPass, salt);
                    if (encryptPass.equals(args[0])) {
                        System.out.println(decryptPass);
                        System.exit(0);
                    }
                }

                for (char anArray1 : array) {
                    for (char anArray : array) {
                        decryptPass = Character.toString(anArray1) + Character.toString(anArray);
                        encryptPass = Crypt.crypt(decryptPass, salt);
                        if (encryptPass.equals(args[0])) {
                            System.out.println(decryptPass);
                            System.exit(0);
                        }
                    }
                }

                for (char anArray : array) {
                    for (char anArray1 : array) {
                        for (char anArray2 : array) {
                            decryptPass = Character.toString(anArray) + Character.toString(anArray1) +
                                    Character.toString(anArray2);
                            encryptPass = Crypt.crypt(decryptPass, salt);
                            if (encryptPass.equals(args[0])) {
                                System.out.println(decryptPass);
                                System.exit(0);
                            }
                        }
                    }
                }

                for (char anArray : array) {
                    for (char anArray1 : array) {
                        for (char anArray2 : array) {
                            for (char anArray3 : array) {
                                decryptPass = Character.toString(anArray) + Character.toString(anArray1) +
                                        Character.toString(anArray2) + Character.toString(anArray3);
                                encryptPass = Crypt.crypt(decryptPass, salt);
                                if (encryptPass.equals(args[0])) {
                                    System.out.println(decryptPass);
                                    System.exit(0);
                                }
                            }
                        }
                    }
                }

                for (char anArray : array) {
                    for (char anArray1 : array) {
                        for (char anArray2 : array) {
                            for (char anArray3 : array) {
                                for (char anArray4 : array) {
                                    decryptPass = Character.toString(anArray) + Character.toString(anArray1) +
                                            Character.toString(anArray2) + Character.toString(anArray3) +
                                            Character.toString(anArray4);
                                    encryptPass = Crypt.crypt(decryptPass, salt);
                                    if (encryptPass.equals(args[0])) {
                                        System.out.println(decryptPass);
                                        System.exit(0);
                                    }
                                }
                            }
                        }
                    }
                }

                for (char anArray : array) {
                    for (char anArray1 : array) {
                        for (char anArray2 : array) {
                            for (char anArray3 : array) {
                                for (char anArray4 : array) {
                                    for (char anArray5 : array) {
                                        decryptPass = Character.toString(anArray) + Character.toString(anArray1) +
                                                Character.toString(anArray2) + Character.toString(anArray3) +
                                                Character.toString(anArray4) + Character.toString(anArray5);
                                        encryptPass = Crypt.crypt(decryptPass, salt);
                                        if (encryptPass.equals(args[0])) {
                                            System.out.println(decryptPass);
                                            System.exit(0);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });

        myThread.start();

        for (char anArray : Harvard_002_Decrypt_Brute_Force.array) {
            for (char anArray3 : array)
                for (char anArray1 : array) {
                    for (char anArray2 : array) {
                        for (char anArray4 : array) {
                            for (char anArray5 : array) {
                                for (char anArray6 : array) {
                                    decryptPass = Character.toString(anArray) + Character.toString(anArray3) +
                                            Character.toString(anArray1) + Character.toString(anArray2) +
                                            Character.toString(anArray4) + Character.toString(anArray5) +
                                            Character.toString(anArray6);
                                    encryptPass = Crypt.crypt(decryptPass, salt);
                                    if (encryptPass.equals(args[0])) {
                                        System.out.println(decryptPass);
                                        System.exit(0);
                                    }
                                }
                            }
                        }
                    }
                }
        }

        for (char anArray : array) {
            for (char anArray1 : array) {
                for (char anArray2 : array) {
                    for (char anArray3 : array) {
                        for (char anArray4 : array) {
                            for (char anArray5 : array) {
                                for (char anArray6 : array) {
                                    for (char anArray7 : array) {
                                        decryptPass = Character.toString(anArray) + Character.toString(anArray1) +
                                                Character.toString(anArray2) + Character.toString(anArray3) +
                                                Character.toString(anArray4) + Character.toString(anArray5) +
                                                Character.toString(anArray6) + Character.toString(anArray7);
                                        encryptPass = Crypt.crypt(decryptPass, salt);
                                        if (encryptPass.equals(args[0])) {
                                            System.out.println(decryptPass);
                                            System.exit(0);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
