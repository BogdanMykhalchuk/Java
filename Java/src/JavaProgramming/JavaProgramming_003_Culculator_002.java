package JavaProgramming;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Bogdan on 07.02.2017.
 */
public class JavaProgramming_003_Culculator_002 extends JFrame {
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15;
    //JTextField t1;
    JLabel j1;
    int k, i;
    String a, b;
    Nested1 nested1 = new Nested1();

    public JavaProgramming_003_Culculator_002(String s) {
        super(s);
        setLayout(new FlowLayout());
        b1 = new JButton("   1   ");
        b2 = new JButton("   2   ");
        b3 = new JButton("   3   ");
        b4 = new JButton("   4   ");
        b5 = new JButton("   5   ");
        b6 = new JButton("   6   ");
        b7 = new JButton("   7   ");
        b8 = new JButton("   8   ");
        b9 = new JButton("   9   ");
        b10 = new JButton("        0        ");
        b11 = new JButton("   +   ");
        b12 = new JButton("   -   ");
        b13 = new JButton("   *   ");
        b14 = new JButton("   /   ");
        b15 = new JButton("        =        ");
        j1 = new JLabel("");
        add(j1);
        add(b7);
        add(b8);
        add(b9);
        add(b14);
        add(b4);
        add(b5);
        add(b6);
        add(b13);
        add(b1);
        add(b2);
        add(b3);
        add(b12);
        add(b10);
        add(b15);
        add(b11);
        b1.addActionListener(nested1);
        b2.addActionListener(nested1);
        b3.addActionListener(nested1);
        b4.addActionListener(nested1);
        b5.addActionListener(nested1);
        b6.addActionListener(nested1);
        b7.addActionListener(nested1);
        b8.addActionListener(nested1);
        b9.addActionListener(nested1);
        b10.addActionListener(nested1);
        b11.addActionListener(nested1);
        b12.addActionListener(nested1);
        b13.addActionListener(nested1);
        b14.addActionListener(nested1);
        b15.addActionListener(nested1);
    }
    protected class Nested1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            while ((e.getSource() == b15)) {
                if (e.getSource() == b1) {
                    i = 1;
                    a = " " + i;
                    j1.setText(a);
                }
                if (e.getSource() == b2) {
                    i = 2;
                }
                if (e.getSource() == b3) {
                    i = 3;
                }
                if (e.getSource() == b4) {
                    i = 4;
                }
                if (e.getSource() == b5) {
                    i = 5;
                }
                if (e.getSource() == b6) {
                    i = 6;
                }
                if (e.getSource() == b7) {
                    i = 7;
                }
                if (e.getSource() == b8) {
                    i = 8;
                }
                if (e.getSource() == b9) {
                    i = 9;
                }
                if (e.getSource() == b10) {
                    i = 0;
                }
            }
        }
    }
}
