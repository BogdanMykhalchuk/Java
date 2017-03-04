package Training.Employee_1;

public class Manager_1 extends Employee_1 {
    Manager_1() {}
    Manager_1( int wages, int age,  String name) {
        super(wages, age, name);
    }
    @Override
    public String toString() {
        return String.format("%d;%d;%s;Manager\n", getWages(), getAge(), getName());
    }
}