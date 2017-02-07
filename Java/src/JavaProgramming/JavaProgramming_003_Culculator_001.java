package JavaProgramming;

import javax.swing.*;

/**
 * Created by Bogdan on 07.02.2017.
 */
public class JavaProgramming_003_Culculator_001 {
    public static void main(String[] args) {
        JavaProgramming_003_Culculator_002 r = new JavaProgramming_003_Culculator_002("Калькулятор");
        r.setVisible(true);
        r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        r.setSize(300, 250);
        r.setResizable(false);
        r.setLocationRelativeTo(null);
    }
}
