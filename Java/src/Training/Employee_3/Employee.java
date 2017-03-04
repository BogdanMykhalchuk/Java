package Training.Employee_3;

public class Employee extends Staff {
    public static final String IDENTIFIER = "Employee";
    public Employee(){}
     public Employee(String name, int wages) {
         super(name, wages);
     }

     @Override
     public String toString() {
         return String.format("%s;%s;%d\n", IDENTIFIER, getName(), getWages());
     }
}