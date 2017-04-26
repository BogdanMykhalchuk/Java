package JavaRush.MultiThreading.task2113;

/**
 * Created by Dreawalker on 28.03.2017.
 */
public class Horse {
    private String name;
    private double speed;
    private double distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return this.speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return this.distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void move(){
        this.distance += speed * Math.random();
    }
    public void print(){
        for(int i = 0; i < (int)distance; i++) {
            System.out.print(".");
        }
        System.out.print(this.name);
        System.out.println();
    }
}
