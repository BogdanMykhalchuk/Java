package Employee_1;

import java.util.Comparator;

public class Employee_Manager_1_Cpmparator implements Comparator<Employee_1> {
    @Override
    public int compare(Employee_1 employee1, Employee_1 employee2) {
        int i = employee1.getAge() - employee2.getAge();
        if(i == 0) {
            i = employee1.getName().compareTo(employee2.getName());
        }
        return i;
    }
}