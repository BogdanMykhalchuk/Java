package UFIREG.UFIREG_Five_Minute;

import UFIREG.UFIREG_Daily.TheJobIsDone;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.List;

import static java.lang.Character.isDigit;
import static java.lang.Double.NaN;

/**
 * Created by Bogdan on 13.03.2017.
 */
public class UFIREGFiveMinAveragesCalculator extends JFrame{
    private static File inPutFile;
    private static String filePath;
    private UFIREGFiveMinAveragesCalculator() {
        super("Програма попередньої обробки даних");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(Box.createVerticalGlue());

        final JLabel label1 = new JLabel("Оберіть файл для обробки");
        label1.setAlignmentY(CENTER_ALIGNMENT);
        label1.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(label1);

        final JLabel label2 = new JLabel("(файл типу UFIREG_Myy.txt)");
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
                    inPutFile = fileOpen.getSelectedFile();
                    filePath = inPutFile.getPath();
                    System.out.println(filePath);
                    startCalculations(filePath, inPutFile);
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

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                JDialog.setDefaultLookAndFeelDecorated(true);
                new UFIREGFiveMinAveragesCalculator();
            }
        });
    }

    private static void startCalculations(String filePath, File file) {
        if(checkFile(file)) {
            System.out.println("Файл прийнятий до обробки.");
        } else {
            throw new IllegalArgumentException("Невірний формат файлу!!!");
        }
        File outPutFile = new File(getOutputFilepath(filePath));
        Double value1 = 0.0;
        Double value2 = 0.0;
        Double value3 = 0.0;
        Double value4 = 0.0;
        Double value5 = 0.0;
        Double value6 = 0.0;
        Double value7 = 0.0;
        List<Double> finalList;
        String[] array;
        String date;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outPutFile))) {
            String line = bufferedReader.readLine();
            while(line != null) {
                array = line.split(";");
                date = createDate(array[0]);
                finalList = new ArrayList<>();
                for(int i = 0; i < 7; i++) {
                    array = line.split(";");
                    if (!array[3].equals("-999") && !array[4].equals("F")) {
                        switch (array[2]) {
                            case "801":
                                value1 = Double.parseDouble(array[3]);
                                break;
                            case "802":
                                value2 = Double.parseDouble(array[3]);
                                break;
                            case "803":
                                value3 = Double.parseDouble(array[3]);
                                break;
                            case "804":
                                value4 = Double.parseDouble(array[3]);
                                break;
                            case "805":
                                value5 = Double.parseDouble(array[3]);
                                break;
                            case "806":
                                value6 = Double.parseDouble(array[3]);
                                break;
                            case "807":
                                value7 = Double.parseDouble(array[3]);
                                break;
                        }
                    } else {
                        switch (array[2]) {
                            case "801":
                                value1 = NaN;
                                break;
                            case "802":
                                value2 = NaN;
                                break;
                            case "803":
                                value3 = NaN;
                                break;
                            case "804":
                                value4 = NaN;
                                break;
                            case "805":
                                value5 = NaN;
                                break;
                            case "806":
                                value6 = NaN;
                                break;
                            case "807":
                                value7 = NaN;
                                break;
                        }
                    }
                    line = bufferedReader.readLine();
                }

                finalList.add(value1);
                finalList.add(value2);
                finalList.add(value3);
                finalList.add(value4);
                finalList.add(value5);
                finalList.add(value6);
                finalList.add(value7);

                bufferedWriter.append(date).append(";");

                for(Double object : finalList) {
                    bufferedWriter.append(object.toString()).append(";");
                }

                bufferedWriter.append('\n');
            }

        } catch(IOException e) {
            e.printStackTrace();
        }

        TheJobIsDone.printCongratulation();
    }

    private static boolean checkFile(File file) {
        String fileName = file.getName();

        if(!fileName.substring(0, 7).equals("UFIREG_")) {
            return false;
        }

        String sub = fileName.substring(7, 11);

        for(int j = 0; j < sub.length(); j++) {
            if(!isDigit(sub.charAt(j))) {
                return false;
            }
        }

        return fileName.substring(11, 15).equals(".txt");
    }

    private static String createDate(String string) {
        return string.substring(0, 2) + "." + string.substring(2, 4) + ".20"
                + string.substring(4, 6) + " " + string.substring(7, 9) + ":" +
                string.substring(10, 12);
    }

    private static String getOutputFilepath(String filePath) {
        return filePath.substring(0, filePath.length() - 4) + "_Five_Min.csv";
    }
}
