package JavaProgramming;

import javax.swing.*;

/**
 * Created by Bogdan on 07.02.2017.
 */
public class JavaProgramming_002_JFrame_002 {
    public static void main(String[] args) {
        JavaProgramming_001_JFrame_001 r = new JavaProgramming_001_JFrame_001("G-гурда");
        r.setVisible(true);
        r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        r.setSize(300, 200);
        r.setResizable(false);
        r.setLocationRelativeTo(null);
    }
}
