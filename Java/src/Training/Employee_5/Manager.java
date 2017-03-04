package Training.Employee_5;

public class Manager extends Staff {
    public static final String IDENTIFIER = "Manager";
    public Manager(){}
    public Manager(String name, int wages) {
        super(name, wages);
    }
    
    @Override
    public String toString() {
        return String.format("%s;%s;%d\n", IDENTIFIER, getName(), getWages());
    }
}