package Training.Employee;

import java.util.Comparator;

/**
 * Created by Dreawalker on 02.10.2016.
 */
class EmployeeSelaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee employee1, Employee employee2) {
        int i = (int)(employee2.getMonthlyAvarage() - employee1.getMonthlyAvarage());
        if(i == 0) {
            i = employee1.getName().compareTo(employee2.getName());
        }
        return i;
    }
}
