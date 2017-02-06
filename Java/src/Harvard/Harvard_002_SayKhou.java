package Harvard;

/**
 * Created by Dreawalker on 09.08.2016.
 */
public class Harvard_002_SayKhou {
    public static void main(String[] args){
        Times(4, "Yahoo");
    }

    public static void Say(String sound) {
        System.out.println(sound);
    }

    public static void Times(int number, String sound) {
        for(int i = 0; i < number; i++) {
            Say(sound);
        }
    }
}
