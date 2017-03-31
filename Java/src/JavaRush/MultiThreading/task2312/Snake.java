package JavaRush.MultiThreading.task2312;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bogdan on 31.03.2017.
 */
public class Snake {
    private List<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;

    public Snake(int x, int y) {
        sections = new ArrayList<>();
        SnakeSection snakeSection = new SnakeSection(x, y);
        sections.add(snakeSection);
        this.isAlive = true;
    }

    public List<SnakeSection> getSections() {
        return this.sections;
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    public SnakeDirection getDirection() {
        return this.direction;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    public int getX() {
        return this.sections.get(0).getX();
    }

    public int getY() {
        return this.sections.get(0).getY();
    }

    public void move() {
        if(this.isAlive) {
            switch(this.direction) {
                case UP: this.move(0, -1); break;
                case RIGHT: this.move(1, 0); break;
                case DOWN: this.move(0, 1); break;
                case LEFT: this.move(-1, 0); break;
            }
        }
    }

    public void move(int x, int y) {
        this.checkBorders(this.sections.get(0));
        this.checkBody(this.sections.get(0));
        if(this.isAlive) {
            this.sections.add(0, new SnakeSection(this.sections.get(0).getX() + x,
                    this.sections.get(0).getY() + y));
            if(this.sections.get(0).getX() == Room.game.getMouse().getX() &&
                    this.sections.get(0).getY() == Room.game.getMouse().getY()) {
                Room.game.eatMouse();
            } else {
                this.sections.remove(this.sections.size() - 1);
            }
        }
    }

    public void checkBorders (SnakeSection head){
        int headX = head.getX();
        int headY = head.getY();
        int widthRoom = Room.game.getWidth();
        int heightRoom = Room.game.getHeight();

        if (headX<0 || headX>=widthRoom || headY<0 || headY>=heightRoom){
            isAlive = false;
        }
    }

    public void checkBody(SnakeSection head) {
        if(this.sections.contains(head)) {
            this.isAlive = false;
        }
    }
}
