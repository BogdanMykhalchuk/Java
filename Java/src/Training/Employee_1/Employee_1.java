package Training.Employee_1;

import java.io.Serializable;

public class Employee_1 implements Serializable {
    private int wages;
    private int age;
    private String name;
    
    Employee_1() {}
    Employee_1( int wages, int age,  String name) {
        this.wages = wages;
        this.age = age;
        this.name = name;
    }
    
    public int getWages() {
        return wages;
    }
    
    public void setWages(int wages) {
        this.wages = wages;
    }
    
     public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
     public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return String.format("%d;%d;%s;Training.Employee\n", getWages(), getAge(), getName());
    }
}