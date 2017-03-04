package Training.Employee_5;

import java.util.Comparator;

public class StaffComparator implements Comparator<Staff> {
    @Override
    public int compare(Staff staff1, Staff staff2) {
        return staff1.getWages() - staff2.getWages();
    }
}