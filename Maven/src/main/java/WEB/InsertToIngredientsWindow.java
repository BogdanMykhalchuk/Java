package WEB;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Dreawalker on 17.02.2017.
 */
public class InsertToIngredientsWindow extends JFrame {
    private InsertToIngredientsWindow() {
        super("Процес внесення нового запису в БД");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(Box.createVerticalGlue());

        final JLabel label1 = new JLabel("Шллях до файлу з рецептом:");
        label1.setAlignmentY(CENTER_ALIGNMENT);
        label1.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(label1);

        panel.add(Box.createRigidArea(new Dimension(10, 10)));

        JButton button = new JButton("Додати запис в БД");
        button.setAlignmentX(CENTER_ALIGNMENT);

//        button.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                JFileChooser fileOpen = new JFileChooser();
//                int ret = fileOpen.showDialog(null, "Відкрити файл");
//                if (ret == JFileChooser.APPROVE_OPTION) {
//                    file = fileOpen.getSelectedFile();
//                    filePath = file.getPath();
//                    System.out.println(filePath);
//                    DailyAverageWindows.startCalculations(filePath);
//                }
//            }
//        });

        panel.add(button);
        panel.add(Box.createVerticalGlue());
        getContentPane().add(panel);

        setPreferredSize(new Dimension(360, 220));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                JDialog.setDefaultLookAndFeelDecorated(true);
                new InsertToIngredientsWindow();
            }
        });
    }
}
