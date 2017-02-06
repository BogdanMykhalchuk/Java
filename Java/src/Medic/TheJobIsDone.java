package Medic;


import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Kvitochka on 22.10.2016.
 */
public class TheJobIsDone extends JFrame {
    public TheJobIsDone(String s){
        super(s);
        setSize(400, 150);
        setVisible(true);
        setBackground(Color.GREEN);
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent ev){
                System.exit(0);
            }
        });
    }
    public void paint(Graphics g){
        g.setFont(new Font("Serif", Font.ITALIC|Font.BOLD, 30));
        g.drawString("The job is done!!!", 20, 100);
    }
    public static void printCongratulation() {
        Frame f = new TheJobIsDone("Congratulations!");
    }
}
