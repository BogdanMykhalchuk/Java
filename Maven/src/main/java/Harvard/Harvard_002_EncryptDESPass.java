package Harvard;

import org.apache.commons.codec.digest.Crypt;

/**
 * Created by Bogdan on 07.02.2017.
 */
public class Harvard_002_EncryptDESPass {
    public static double count = 0;

    public static void main(String[] args) throws Exception {

        if (args.length != 1) {
            System.exit(1);
        }

        String decryptPass;
        String encryptPass;
        String salt = Character.toString(args[0].charAt(0)) + Character.toString(args[0].charAt(1));
        char[] array = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
                'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        System.out.println(salt);

//        char[] array = new char[95];
//        for (int i = 0; i < 95; i++) {
//            array[i] = (char) (i + 32);
//        }

//        for (char anArray1 : array) {
//            decryptPass = Character.toString(anArray1);
//            encryptPass = Crypt.crypt(decryptPass, salt);
//            if (encryptPass.equals(args[0])) {
//                System.out.println(decryptPass);
//                System.exit(0);
//            }
//        }
//
//        for (char anArray1 : array) {
//            for (char anArray : array) {
//                decryptPass = Character.toString(anArray1) + Character.toString(anArray);
//                encryptPass = Crypt.crypt(decryptPass, salt);
//                if (encryptPass.equals(args[0])) {
//                    System.out.println(decryptPass);
//                    System.exit(0);
//                }
//            }
//        }
//        System.out.println("3 characters:");
//        GregorianCalendar start = new GregorianCalendar();
////
//        for (char anArray : array) {
//            for (char anArray1 : array) {
//                for (char anArray2 : array) {
//                    decryptPass = Character.toString(anArray) + Character.toString(anArray1) +
//                            Character.toString(anArray2);
//                    count++;
//                    encryptPass = Crypt.crypt(decryptPass, salt);
//                    if (encryptPass.equals(args[0])) {
//                        System.out.println(decryptPass);
//                        System.exit(0);
//                    }
//                }
//            }
//        }
//
//        GregorianCalendar finish = new GregorianCalendar();
//
//        long milsec = finish.getTimeInMillis() - start.getTimeInMillis();
//
//        double min = milsec / 1000;
//
//        System.out.println("time of encryption: " + min);
//        System.out.println("quontity of combinations: " + count);
//
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println("4 characters:");
//
//        count = 0;
//        start = new GregorianCalendar();
//        for (char anArray : array) {
//            for (char anArray1 : array) {
//                for (char anArray2 : array) {
//                    for (char anArray3 : array) {
//                        decryptPass = Character.toString(anArray) + Character.toString(anArray1) +
//                                Character.toString(anArray2) + Character.toString(anArray3);
//                        encryptPass = Crypt.crypt(decryptPass, salt);
//                        count++;
//                        if (encryptPass.equals(args[0])) {
//                            System.out.println(decryptPass);
//                            System.exit(0);
//                        }
//                    }
//                }
//            }
//        }
//
//        finish = new GregorianCalendar();
//
//        milsec = finish.getTimeInMillis() - start.getTimeInMillis();
//
//        min = milsec / 1000;
//
//        System.out.println("time of encryption: " + min);
//        System.out.println("quontity of combinations: " + count);

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
//
//        for (char anArray : array) {
//            for (char anArray1 : array) {
//                for (char anArray2 : array) {
//                    for (char anArray3 : array) {
//                        for (char anArray4 : array) {
//                            for (char anArray5 : array) {
//                                decryptPass = Character.toString(anArray) + Character.toString(anArray1) +
//                                        Character.toString(anArray2) + Character.toString(anArray3) +
//                                        Character.toString(anArray4) + Character.toString(anArray5);
//                                encryptPass = Crypt.crypt(decryptPass, salt);
//                                if (encryptPass.equals(args[0])) {
//                                    System.out.println(decryptPass);
//                                    System.exit(0);
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        for (char anArray : array) {
//            for (char anArray3 : array)
//                for (char anArray1 : array) {
//                    for (char anArray2 : array) {
//                        for (char anArray4 : array) {
//                            for (char anArray5 : array) {
//                                for (char anArray6 : array) {
//                                    decryptPass = Character.toString(anArray) + Character.toString(anArray3) +
//                                            Character.toString(anArray1) + Character.toString(anArray2) +
//                                            Character.toString(anArray4) + Character.toString(anArray5) +
//                                            Character.toString(anArray6);
//                                    encryptPass = Crypt.crypt(decryptPass, salt);
//                                    if (encryptPass.equals(args[0])) {
//                                        System.out.println(decryptPass);
//                                        System.exit(0);
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//        }
//
//        for (char anArray : array) {
//            for (char anArray1 : array) {
//                for (char anArray2 : array) {
//                    for (char anArray3 : array) {
//                        for (char anArray4 : array) {
//                            for (char anArray5 : array) {
//                                for (char anArray6 : array) {
//                                    for (char anArray7 : array) {
//                                        decryptPass = Character.toString(anArray) + Character.toString(anArray1) +
//                                                Character.toString(anArray2) + Character.toString(anArray3) +
//                                                Character.toString(anArray4) + Character.toString(anArray5) +
//                                                Character.toString(anArray6) + Character.toString(anArray7);
//                                        encryptPass = Crypt.crypt(decryptPass, salt);
//                                        if (encryptPass.equals(args[0])) {
//                                            System.out.println(decryptPass);
//                                            System.exit(0);
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
    }
}
