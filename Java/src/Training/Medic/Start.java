package Training.Medic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by Kvitochka on 22.10.2016.
 */
public class Start extends JFrame {
    private static File file;
    public static String filePath;
    private Start() {
        super("Програма попередньої обробки даних");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(Box.createVerticalGlue());

        final JLabel label1 = new JLabel("Оберіть файл для обробки");
        label1.setAlignmentY(CENTER_ALIGNMENT);
        label1.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(label1);

        final JLabel label2 = new JLabel("(назва файлу повинна відповідати шаблону)");
        label2.setAlignmentY(CENTER_ALIGNMENT);
        label2.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(label2);

        panel.add(Box.createRigidArea(new Dimension(10, 10)));

        JButton button = new JButton("Обрати файл");
        button.setAlignmentX(CENTER_ALIGNMENT);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileOpen = new JFileChooser();
                int ret = fileOpen.showDialog(null, "Відкрити файл");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    file = fileOpen.getSelectedFile();
                    filePath = file.getPath();
                    Calculations.startCalculations(filePath);
                }
            }
        });

        panel.add(button);
        panel.add(Box.createVerticalGlue());
        getContentPane().add(panel);

        setPreferredSize(new Dimension(360, 220));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static String getFilePath() {
        return filePath;
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                JDialog.setDefaultLookAndFeelDecorated(true);
                new Start();
            }
        });
    }
}
