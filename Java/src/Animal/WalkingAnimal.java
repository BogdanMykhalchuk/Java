package Animal;

public class WalkingAnimal extends Animal {
    private int maxSpeed;
    private boolean climb;

    public WalkingAnimal() {
    }

    public WalkingAnimal(String name, int age, double height, int maxSpeed, boolean climb) {
        super(name, age, height);
        this.maxSpeed = maxSpeed;
        this.climb = climb;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public boolean getClimb() {
        return climb;
    }

    @Override
    public String getDiscriminator() {
        return "WalkingAnimal";
    }

    @Override
    public String toString() {
        return String.format("%s;%d;%.2f;%d;%s;%.2f;%s\n", getName(), getAge(),
                getHeight(), getMaxSpeed(), getClimb(), getWeight(), getDiscriminator());
    }
}