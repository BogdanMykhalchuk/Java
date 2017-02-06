package Harvard;

/**
 * Created by Dreawalker on 12.08.2016.
 */
public class Harvard_007_Args {
    public static void main(String[] args) {
        //System.out.println(args[1]);
        System.out.println(args.length);
        if (args.length == 2){
            System.out.println(args[1]);
        } else {
            System.out.println("Hello you");
        }
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
        for (int i = 0; i < args.length; i++) {
            args[i].toString();
        }
        for (int i = 0; i < args.length; i++) {
            String queue = args[i].toString();
            for (int j = 0; j < queue.length(); j++) {
                System.out.printf("%c\n", args[i].charAt(j));
            }
            System.out.println();
        }
    }
}
