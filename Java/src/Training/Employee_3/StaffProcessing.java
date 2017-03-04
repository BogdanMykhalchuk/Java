package Training.Employee_3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StaffProcessing {
    public static void main(String[] args) {
        List<Staff> list = new ArrayList<>();
        list.add(new Employee("Vasia", 70));
        list.add(new Employee("Vasia2", 70));
        list.add(new Employee("Vasia3", 760));
        list.add(new Manager("Vasia4", 770));
        list.add(new Manager("Vasia5", 708));
        list.add(new Manager("Vasia65", 709));
        
        list.sort(new CompareStaff());
        
        for(int i = 0; i< 3; i++) {
            System.out.println(list.get(i));
        }
        
         for(int i = list.size() - 1; i > list.size() - 4; i++) {
            System.out.println(list.get(i));
        }
        
        listWriteToFile(list, "C://Staff.txt");
        List<Staff> newList = listreadFromFile("C://Staff.txt");
    }
    
    public static void listWriteToFile(List<Staff> list, String filepath) {
        try(BufferedWriter bf = new BufferedWriter(new FileWriter(filepath))) {
            for(Staff staff : list) {
                bf.append(staff.toString());
                bf.flush();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public static List<Staff> listreadFromFile(String filepath) {
         List<Staff> list = new ArrayList<>();
         if(filepath.substring(filepath.length() - 1, filepath.length() - 5).equals(".txt")) {
             try(BufferedReader br = new BufferedReader(new FileReader(filepath))) {
                 String line = br.readLine();
                 String[] array;
                 while(line != null) {
                     array = line.split(";");
                     if(array.length == 3) {
                         if(array[0].equals(Manager.IDENTIFIER)) {
                             Staff staff = new Manager(array[1], Integer.parseInt(array[2]));
                             list.add(staff);
                         } else if (array[0].equals(Employee.IDENTIFIER)) {
                             Staff staff = new Employee(array[1], Integer.parseInt(array[2]));
                             list.add(staff);
                         }
                     } else {
                         throw new IllegalArgumentException("Wrong data in file!!!");
                     }
                     line = br.readLine();
                 }
             } catch(IOException e) {
                 e.printStackTrace();
            }
         } else {
             throw new IllegalArgumentException("Wrong type file!!!");
         }
         return list;
    }
}