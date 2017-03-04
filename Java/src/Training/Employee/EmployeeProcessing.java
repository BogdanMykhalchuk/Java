package Training.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeProcessing {
    public static void main(String[] args) {
        ArrayList<Employee> listToWrite = new ArrayList<>();
        EmployeeHourly object1 = new EmployeeHourly("Kolia", 1, 5);
        listToWrite.add(object1);
        EmployeeHourly object2 = new EmployeeHourly("Vasia", 2, 3);
        listToWrite.add(object2);
        EmployeeHourly object3 = new EmployeeHourly("Petia", 3, 5);
        listToWrite.add(object3);
        EmployeeHourly object4 = new EmployeeHourly("Mykola", 4, 1);
        listToWrite.add(object4);
        EmployeeHourly object5 = new EmployeeHourly("Gena", 5, 6);
        listToWrite.add(object5);
        EmployeeHourly object6 = new EmployeeHourly("Olia", 6, 5);
        listToWrite.add(object6);
        EmployeeHourly object7 = new EmployeeHourly("Ira", 7, 8);
        listToWrite.add(object7);
        EmployeeFixed object8 = new EmployeeFixed("Vova", 8, 300);
        listToWrite.add(object8);
        EmployeeFixed object9 = new EmployeeFixed("Bogdan", 9, 200);
        listToWrite.add(object9);

        listToWrite.sort(new EmployeeSelaryComparator());

        System.out.println(listToWrite);

        for (int i = 0; i < 5; i++) {
            System.out.println(listToWrite.get(i));
        }

        for (int i = listToWrite.size() - 1; i > listToWrite.size() - 4; i--) {
            System.out.println(listToWrite.get(i).getId());
        }

        serialize(listToWrite);
        ArrayList newList = deserialize("D:\\Job\\Java\\Java\\Java\\src\\" +
        "Training\\Employee\\EmployeeSerialized.txt");
        System.out.println(newList.toString());
        fileWrite(listToWrite, "D:\\Job\\Java\\Java\\Java\\src\\Training\\Employee\\Employee.txt");
        System.out.println(fileRead("D:\\Job\\Java\\Java\\Java\\src\\Training\\Employee\\Employee.txt"));


    }

    private static void fileWrite(List<Employee> list, String filePath) {
        try {
            FileWriter output = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(output);

            for (Employee object : list) {
                bufferedWriter.append(object.toString());
            }
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Employee> fileRead(String filePath) {
        List<Employee> listToRead = new ArrayList<>();
        String fileExtension = filePath.substring(filePath.length() - 3, filePath.length());
        if(fileExtension.equals("txt")) {
            try {
                FileReader input = new FileReader(filePath);
                BufferedReader bufferedReader = new BufferedReader(input);
                String s = "";
                while(true) {
                    s= bufferedReader.readLine();
                    if(s != null) {
                        String[] arrayTemp = s.split(";");
                        if (arrayTemp.length == 4) {
                            Employee employeeHourly = new EmployeeHourly(arrayTemp[0], Integer.parseInt(arrayTemp[1]),
                                    Integer.parseInt(arrayTemp[3]));
                            listToRead.add(employeeHourly);
                        } else {
                            Employee employeeFixed = new EmployeeFixed(arrayTemp[0], Integer.parseInt(arrayTemp[1]),
                                    Double.parseDouble(arrayTemp[2]));
                            listToRead.add(employeeFixed);
                        }
                    } else {
                        break;
                    }
                }
                bufferedReader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("Inappropriate file type!!!");
        }
        return listToRead;
    }

    private static void serialize(ArrayList<Employee> list) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\Job\\Java\\Java\\Java\\src\\" +
                    "Training\\Employee\\EmployeeSerialized.txt"));
            for(Object employee : list) {
                oos.writeObject(employee);
                oos.flush();
            }
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList deserialize(String filePath) {
        ArrayList<Employee> list = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
            try {
                while (true) {
                    list.add((Employee)ois.readObject());
                }
            } catch (OptionalDataException e) {
                if (!e.eof) throw e;
            } finally {
                ois.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
