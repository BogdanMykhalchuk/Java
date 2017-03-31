package JavaRush.MultiThreading.task2312;

public class SnakeSection {
    private int x;
    private int y;


    public SnakeSection(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int hashCode() {
        return this.x * 31 + this.y * 31;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null) return false;
        if(this == o) return true;
        if(!(o instanceof SnakeSection)) return false;
        SnakeSection snakeSection = (SnakeSection)o;
        return this.getX() == snakeSection.getX() && this.getY() == this.getY();
    }
}
