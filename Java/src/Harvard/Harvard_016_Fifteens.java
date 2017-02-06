package Harvard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Dreawalker on 26.10.2016.
 */
public class Harvard_016_Fifteens {

    public static int[][] array = new int[4][4];
    public static boolean b = true;

    public static void main(String[] args) {
        array[0][0] = 1;
        array[1][0] = 2;
        array[2][0] = 3;
        array[3][0] = 4;
        array[0][1] = 5;
        array[1][1] = 6;
        array[2][1] = 7;
        array[3][1] = 8;
        array[0][2] = 9;
        array[1][2] = 10;
        array[2][2] = 11;
        array[3][2] = 12;
        array[0][3] = 13;
        array[1][3] = 14;
        array[2][3] = 15;
        array[3][3] = 0;

        //while(b) {
        GameField gameField = new GameField("Fifteens", array);
        //}
        //for(int i = 0; i < array.length; i++)
    }

    public static String getString(int i) {
        if(i != 0) {
            return String.format("%d", i);
        }
        return "";
    }
}

class GameField extends JFrame {

    public GameField() {}
    public GameField(String title, int[][] array) {
        super(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setLayout(new FlowLayout());

        JButton[][] buttons = new JButton[4][4];

        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array.length; j++) {
                JButton button = new JButton(Harvard_016_Fifteens.getString(array[j][i]));
                button.setPreferredSize(new Dimension(90, 90));
                button.setEnabled(false);
                panel.add(button);
                buttons[j][i] = button;
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        moveButtons(buttons, array, button);
//                        GameField gameField = new GameField("Fifteens", array);
                    }
                });
            }
        }

        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array.length; j++) {
                if(array[j][i] == 0) {
                    if (i - 1 >= 0) {
                        buttons[j][i - 1].setEnabled(true);
                    }
                    if (i + 1 < array.length) {
                        buttons[j][i + 1].setEnabled(true);
                    }
                    if (j - 1 >= 0) {
                        buttons[j - 1][i].setEnabled(true);
                    }
                    if (j + 1 < array.length) {
                        buttons[j + 1][i].setEnabled(true);
                    }
                }
            }
        }

        getContentPane().add(panel);

        setPreferredSize(new Dimension(400, 420));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void moveButtons(JButton[][] buttons, int[][] array, JButton button) {
        int rows = 0;
        int lines = 0;

        for(int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons.length; j++) {
                if(buttons[j][i] == button) {
                    rows = j;
                    lines = i;
                }
            }
        }

        for(int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if(array[j][i] == 0) {
                    array[j][i] = array[rows][lines];
                    array[rows][lines] = 0;
                }
            }
        }
    }
}
