package Training.Staff;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StaffProcessing {
     public static void main(String[] args) {
         List<Staff> list = new ArrayList<>();
         list.add(new Employee("Vasia", 90));
         list.add(new Employee("Petia", 920));
         list.add(new Employee("Grisha", 90));
         list.add(new Manager("Vova", 190));
         list.add(new Manager("Olia", 1190));
         list.add(new Manager("Gena", 2190));
         
         list.sort(new CompareStaff());
         
         for(int i = 0; i < 3; i++) {
             System.out.println(list.get(i));
         }
         
         for(int i = list.size() - 1; i > list.size() - 4; i--) {
             System.out.println(list.get(i));
         }
         
         listWriteToFile(list, "C://Staff.txt");
         List<Staff> newList = listReadFromFile("C://Staff.txt");
     }
     
     public static void  listWriteToFile(List<Staff> list, String filepath) {
         try(BufferedWriter bw = new BufferedWriter(new FileWriter(filepath))){
             for(Staff staff : list) {
                 bw.append(staff.toString());
             }
             bw.flush();
         } catch(IOException e) {
             e.printStackTrace();
         }
     }
     
     public static List<Staff> listReadFromFile(String filepath) {
         List<Staff> list = new ArrayList<>();
          if(filepath.substring(filepath.length() - 3, filepath.length()). equals("txt")) {
              try(BufferedReader br = new BufferedReader(new FileReader(filepath))){
                  String line = br.readLine();
                  String[] array;
                  while(line != null) {
                      array = line.split(";");
                      if(array[0].equals("Manager")) {
                          Staff staff = new Manager(array[1], Integer.parseInt(array[2]));
                          list.add(staff);
                      } else {
                          Staff staff = new Employee(array[1], Integer.parseInt(array[2]));
                          list.add(staff);
                      }
                      line = br.readLine();
                  }
              } catch (IOException e) {
                  e.printStackTrace();
              }
          } else {
              throw new IllegalArgumentException();
          }
          return list;
     }
}