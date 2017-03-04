package Training.Employee_5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StaffProcessing {
    public static void main(String[] args) {
        List<Staff> list = new ArrayList<>();
        list.add(new Manager("Vasia", 640));
        list.add(new Manager("Vasia2", 650));
        list.add(new Manager("Vasia3", 660));
        list.add(new Manager("Vasia4", 690));
        list.add(new Manager("Vasia5", 602));
        list.add(new Manager("Vasia1", 630));
        
        list.sort(new StaffComparator());
        
        for(int i = 0; i < 3; i++) {
            System.out.println(list.get(i));
        }
        
        for(int i = list.size() - 1; i >  list.size() - 4; i--) {
            System.out.println(list.get(i));
        }
        
        writeListToFile(list, "C://Staff.txt");
        List<Staff> newList = readListFromFile("C://Staff.txt");

        System.out.println(newList);
    }
    
    public static void writeListToFile( List<Staff> list, String filepath) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filepath))) {
            for(Staff staff : list) {
                bw.append(staff.toString());
            }
            bw.flush();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public static List<Staff> readListFromFile(String filepath) {
        List<Staff> list = new ArrayList<>();
            if(filepath.substring(filepath.length() - 4, filepath.length()).equals(".txt")) {
                try(BufferedReader br = new BufferedReader(new FileReader(filepath))) {
                    String line = br.readLine();
                    String[] array;
                    while(line != null) {
                        array = line.split(";");
                        if(array.length == 3) {
                            if(array[0].equals(Manager.IDENTIFIER)) {
                                Staff staff = new Manager(array[1], Integer.parseInt(array[2]));
                                list.add(staff);
                            } else if(array[0].equals(Employee.IDENTIFIER)) {
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
                throw new IllegalArgumentException("Wrong type of file!!!");
            }
        return list;
    }
}