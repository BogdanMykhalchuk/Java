package Training.Staff;

public class Employee extends Staff {
     public static final String CLASS = "Employee";
     public Employee(){}
     public Employee(String name, int wages) {
          super(name, wages);
     }
     
     @Override
     public String toString() {
          return String.format("%s;%s;%d\n", CLASS, getName(), getWages());
     }
}