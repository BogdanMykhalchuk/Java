package UFIREG.UFIREG_Hourly;

import UFIREG.TheJobIsDone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.isDigit;
import static java.lang.Double.NaN;

/**
 * Created by Bogdan on 03.03.2017.
 */
class UFIREGHourlyAveragesCalculator extends JFrame{
    private static File inPutFile;
    private static String filePath;
    private UFIREGHourlyAveragesCalculator() {
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
                new UFIREGHourlyAveragesCalculator();
            }
        });
    }

    private static void startCalculations(String filePath, File file) {
        if(checkFile(file)) {
            System.out.println("Файл прийнятий до обробки.");
        } else {
            throw new IllegalArgumentException("Невірний формат файлу!!!");
        }
        File outPutFile = new File(getOutputFilepath(filePath, file));
        List<Double> list1;
        List<Double> list2;
        List<Double> list3;
        List<Double> list4;
        List<Double> list5;
        List<Double> list6;
        List<Double> list7;
        List<Double> finalList;
        String[] array;
        String date;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outPutFile))) {
            String line = bufferedReader.readLine();
            while(line != null) {
                array = line.split(";");
                date = createDate(array[0]);
                list1 = new ArrayList<>();
                list2 = new ArrayList<>();
                list3 = new ArrayList<>();
                list4 = new ArrayList<>();
                list5 = new ArrayList<>();
                list6 = new ArrayList<>();
                list7 = new ArrayList<>();
                finalList = new ArrayList<>();
                for(int i = 0; i < 84; i++) {
                    if (line != null) {
                        array = line.split(";");
                        if (!array[3].equals("-999") && !array[4].equals("F")) {
                            switch (array[2]) {
                                case "801":
                                    list1.add(Double.parseDouble(array[3]));
                                    break;
                                case "802":
                                    list2.add(Double.parseDouble(array[3]));
                                    break;
                                case "803":
                                    list3.add(Double.parseDouble(array[3]));
                                    break;
                                case "804":
                                    list4.add(Double.parseDouble(array[3]));
                                    break;
                                case "805":
                                    list5.add(Double.parseDouble(array[3]));
                                    break;
                                case "806":
                                    list6.add(Double.parseDouble(array[3]));
                                    break;
                                case "807":
                                    list7.add(Double.parseDouble(array[3]));
                                    break;
                            }
                        }
                    }
                    line = bufferedReader.readLine();
                }
                if (dataAvailability(list1)) {
                    finalList.add(average(list1));
                } else {
                    finalList.add(NaN);
                }
                if (dataAvailability(list2)) {
                    finalList.add(average(list2));
                } else {
                    finalList.add(NaN);
                }
                if (dataAvailability(list3)) {
                    finalList.add(average(list3));
                } else {
                    finalList.add(NaN);
                }
                if (dataAvailability(list4)) {
                    finalList.add(average(list4));
                } else {
                    finalList.add(NaN);
                }
                if (dataAvailability(list5)) {
                    finalList.add(average(list5));
                } else {
                    finalList.add(NaN);
                }
                if (dataAvailability(list6)) {
                    finalList.add(average(list6));
                } else {
                    finalList.add(NaN);
                }
                if (dataAvailability(list7)) {
                    finalList.add(average(list7));
                } else {
                    finalList.add(NaN);
                }

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

    private static String getOutputFilepath(String filePath, File file) {
        return filePath.substring(0, filePath.length() - 3) + "csv";
    }

    private static boolean dataAvailability(List<Double> list) {
        return list.size() >= 9;
    }

    private static double average(List<Double> list) {
        Double j = 0.0;
        for(Double object : list) {
            j = j + object;
        }
        j = j / list.size();
        return j;
    }
}
