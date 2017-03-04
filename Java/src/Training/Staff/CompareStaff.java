package Training.Staff;

import java.util.Comparator;

public class CompareStaff implements Comparator<Staff> {
    @Override
    public int compare(Staff staff1, Staff staff2) {
         int i = staff1.getName().compareTo(staff2.getName());
         return i;
    }
}