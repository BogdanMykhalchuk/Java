package Training.Staff;

public class Manager extends Staff {
     public static final String CLASS = "Manager";
     public Manager(){}
     public Manager(String name, int wages) {
          super(name, wages);
     }
     
     @Override
     public String toString() {
          return String.format("%s;%s;%d\n", CLASS, getName(), getWages());
     }
}