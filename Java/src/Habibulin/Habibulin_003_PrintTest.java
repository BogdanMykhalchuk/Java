package Habibulin;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/**
 * Created by Bogdan on 07.02.2017.
 */
public class Habibulin_003_PrintTest extends Frame {
    Habibulin_003_PrintTest(String s){
        super(s);
        setSize(400, 400);
        setVisible(true);
    }
    public void simplePrint(){
        PrintJob pj =
                getToolkit().getPrintJob(this, "Job Title", null);
        if (pj != null){
            Graphics pg = pj.getGraphics();
            if (pg != null){
                print(pg);
                pg.dispose();
            }else System.err.println("Graphics's null");
            pj.end();
        }else System.err.println("Job's null");
    }
    public void paint(Graphics g){
        g.setFont(new Font("Serif", Font.ITALIC, 30));
        g.setColor(Color.black);
        g.drawArc(100, 100, 200, 200, 0, 360);
        g.drawString("Страница 1", 100, 100);
    }
    public static void main(String[] args){
        Habibulin_003_PrintTest pt = new Habibulin_003_PrintTest(" Простой пример печати");
        pt.simplePrint();
        pt.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent ev){
                System.exit(0);
            }
        });
    }
}
