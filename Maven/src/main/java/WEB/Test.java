package WEB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Dreawalker on 17.02.2017.
 */
public class Test extends JFrame {
    private String string;
    private Test() {
        super("Процес внесення нового запису в БД");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(Box.createVerticalGlue());
        panel.add(Box.createRigidArea(new Dimension(30, 30)));

        final JLabel label1 = new JLabel("Оберіть файл для обробки");
        label1.setAlignmentY(CENTER_ALIGNMENT);
        label1.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(label1);

        panel.add(Box.createRigidArea(new Dimension(30, 30)));

        final JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(100, 30));
        panel.add(textField);


        panel.add(Box.createRigidArea(new Dimension(30, 30)));

        final JButton button = new JButton("Додати запис в БД");
        button.setAlignmentX(CENTER_ALIGNMENT);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button) {
                    string = textField.getText();
                    System.out.println(string);
                    System.exit(0);
                }
            }
        });

        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(30, 30)));
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
                new Test();
            }
        });
//        File file = new File("src/main/java/WEB/Test.txt");
//        try(BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
//            String string = fileReader.readLine();
//            while(string != null) {
//                System.out.println(string);
//                string = fileReader.readLine();
//            }
//            fileReader.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
