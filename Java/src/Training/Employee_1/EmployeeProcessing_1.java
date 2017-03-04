package Training.Employee_1;

import Training.Employee.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeProcessing_1 {
    public static void main(String[] args) {
        ArrayList<Employee_1> list = new ArrayList<>();
        Employee_1 employee1 = new Employee_1(3500, 36, "Petia");
        Employee_1 employee2 = new Employee_1(3500, 26, "Vasia");
        Employee_1 employee3 = new Employee_1(2500, 31, "Vova");
        Employee_1 employee4 = new Manager_1(5500, 46, "Grisha");
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        list.add(employee4);
        
        Collections.sort(list, new  Employee_Manager_1_Cpmparator());
        
        System.out.println(list.get(0).toString());

        serialize(list);
        ArrayList newList = deserialize("D:\\Job\\Java\\Java\\Java\\src\\Training\\Employee_1\\" +
                        "EmployeeSerialized.txt");
        System.out.println(newList.toString());

        
        writeToFile(list , "D:\\Job\\Java\\Kolia\\Hub\\Bogdan\\src\\com\\company\\Training.Employee_1\\Test.Test.txt");
        System.out.println(readFromFile("D:\\Job\\Java\\Kolia\\Hub\\Bogdan\\src\\com\\company\\Training.Employee_1\\Test.Test.txt"));
        
    }
    
    static void writeToFile(List<Employee_1> list, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(Employee_1 object : list) {
                bufferedWriter.append(object.toString());
            }
            bufferedWriter.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    static List<Employee_1> readFromFile(String filePath) {
         List<Employee_1> list = new ArrayList<>();
         try {
             FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             while(true) {
                 String nextLine = bufferedReader.readLine();
                 if(nextLine != null) {
                     String[] temp = nextLine.split(";");
                     if(temp[3].equals("Training/Employee")) {
                         Employee_1 employee = new Employee_1(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), temp[2]);
                         list.add(employee);
                     } else {
                         Employee_1 manager = new Manager_1(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), temp[2]);
                         list.add(manager);
                     }
                 } else {
                     break;
                 }
             }
             bufferedReader.close();
         } catch (IOException e) {
             e.printStackTrace();
         }
         return list;
    }

    private static void serialize(ArrayList<Employee_1> list) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\Job\\Java\\Java\\Java\\" +
                    "src\\Training\\Employee_1\\EmployeeSerialized.txt"));
            oos.writeObject(list);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList deserialize(String filePath) {
        ArrayList<Employee> list = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
            list = (ArrayList<Employee>)ois.readObject();
            ois.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (ClassNotFoundException e3) {
            e3.printStackTrace();
        }
        return list;
    }
}