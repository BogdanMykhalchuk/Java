package JavaRush.MultiThreading.NotationCalculiator;

/* 
Конвертер систем счислений - максимальная система счисления - шестнадцатиричная.
*/
class Solution {
    public static void main(String[] args) {
        Number number = new Number(10, "6");
        Number result = convertNumberToOtherNumerationSystem(number, 2);
        System.out.println(result);    //expected 110

        number = new Number(16, "6df");
        result = convertNumberToOtherNumerationSystem(number, 8);
        System.out.println(result);    //expected 3337
    }

    static Number convertNumberToOtherNumerationSystem(Number number, int expectedNumerationSystem) {
        switch(number.getNumerationSystem()) {
            case (2):
                if(!number.getDigit().replaceAll("[01]", "").isEmpty()) {
                    throw new NumberFormatException();
                }
                break;
            case (3):
                if(!number.getDigit().replaceAll("[012]", "").isEmpty()) {
                    throw new NumberFormatException();
                }
                break;
            case (4):
                if(!number.getDigit().replaceAll("[0-3]", "").isEmpty()) {
                    throw new NumberFormatException();
                }
                break;
            case (5):
                if(!number.getDigit().replaceAll("[0-4]", "").isEmpty()) {
                    throw new NumberFormatException();
                }
                break;
            case (6):
                if(!number.getDigit().replaceAll("[0-5]", "").isEmpty()) {
                    throw new NumberFormatException();
                }
                break;
            case (7):
                if(!number.getDigit().replaceAll("[0-6]", "").isEmpty()) {
                    throw new NumberFormatException();
                }
                break;
            case (8):
                if(!number.getDigit().replaceAll("[0-7]", "").isEmpty()) {
                    throw new NumberFormatException();
                }
                break;
            case (9):
                if(!number.getDigit().replaceAll("[0-8]", "").isEmpty()) {
                    throw new NumberFormatException();
                }
                break;
            case (10):
                if(!number.getDigit().replaceAll("[0-9]", "").isEmpty()) {
                    throw new NumberFormatException();
                }
                break;
            case (12):
                if(!number.getDigit().replaceAll("[0-9a-bA-B]", "").isEmpty()) {
                    throw new NumberFormatException();
                }
                break;
            case (16):
                if(!number.getDigit().replaceAll("[0-9a-fA-F]", "").isEmpty()) {
                    throw new NumberFormatException();
                }
                break;
        }

        int system = number.getNumerationSystem();
        char[] chars = number.getDigit().toCharArray();
        int decimalResult = 0;
        int count = 0;
        int temp;

        for(int i = chars.length - 1; i >= 0; i--) {
            if(Character.isLetter(chars[i])) {
                temp = LettersToDigits.valueOf(Character.toString(chars[i])).getValue();
            } else {
                temp = Integer.parseInt(Character.toString(chars[i]));
            }
            decimalResult = decimalResult + temp * (int)Math.pow(system, count);
            count++;
        }

        StringBuilder sb = new StringBuilder();
        int remainder;
        temp = decimalResult;
        do {
            remainder = temp % expectedNumerationSystem;
            if(remainder > 9) {
                switch(remainder) {
                    case 10: sb.append('a'); break;
                    case 11: sb.append('b'); break;
                    case 12: sb.append('c'); break;
                    case 13: sb.append('d'); break;
                    case 14: sb.append('e'); break;
                    case 15: sb.append('f'); break;
                }
            } else {
                sb.append(remainder);
            }
            temp = temp / expectedNumerationSystem;
        } while((temp % expectedNumerationSystem) != 0);

        sb = sb.reverse();

        return new Number(expectedNumerationSystem, sb.toString());
    }

    enum LettersToDigits {
        a(10),
        b(11),
        c(12),
        d(13),
        e(14),
        f(15);

        private int value;

        LettersToDigits(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
