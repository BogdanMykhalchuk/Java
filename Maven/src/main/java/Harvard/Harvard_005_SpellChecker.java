package Harvard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by Bogdan on 18.10.2016.
 */
public class Harvard_005_SpellChecker extends JFrame {
    private static File file;
    private static String filePath;
    private Harvard_005_SpellChecker() {
        super("Програма пошуку орфографічних помилок");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(Box.createVerticalGlue());

        final JLabel label1 = new JLabel("Оберіть файл для обробки");
        label1.setAlignmentY(CENTER_ALIGNMENT);
        label1.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(label1);

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
                    System.out.println(filePath);
                    SpellChecker.spellCheck(filePath);
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
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                JDialog.setDefaultLookAndFeelDecorated(true);
                new Harvard_005_SpellChecker();
            }
        });
    }
}
