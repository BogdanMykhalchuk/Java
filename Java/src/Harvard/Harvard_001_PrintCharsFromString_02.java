package Harvard;

/**
 * Created by Bogdan on 07.02.2017.
 */
public class Harvard_001_PrintCharsFromString_02 {
    public static void main(String[] args) {
        System.out.println("Введите текст: ");
        String wordChar = System.console().readLine();
        for(int i = 0; i < wordChar.length(); i++) {
            System.out.println(wordChar.charAt(i));
        }
    }
}
