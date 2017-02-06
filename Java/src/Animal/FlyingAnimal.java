package Animal;

public class FlyingAnimal extends Animal {
    private int maxFlyingHeight;
    private boolean swim;

    public FlyingAnimal() {
    }

    public FlyingAnimal(String name, int age, double height,
                        int maxFlyingHeight, boolean swim) {
        super(name, age, height);
        this.maxFlyingHeight = maxFlyingHeight;
        this.swim = swim;
    }

    public int getMaxFlyingHeight() {
        return maxFlyingHeight;
    }

    public boolean getSwim() {
        return swim;
    }

    @Override
    public String getDiscriminator() {
        return "FlyingAnimal";
    }

    @Override
    public String toString() {
        return String.format("%s;%d;%.2f;%d;%s;%.2f;%s\n", getName(), getAge(),
                getHeight(), getMaxFlyingHeight(), getSwim(), getWeight(), getDiscriminator());
    }
}