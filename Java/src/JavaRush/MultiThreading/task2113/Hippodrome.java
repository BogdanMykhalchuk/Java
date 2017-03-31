package JavaRush.MultiThreading.task2113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dreawalker on 28.03.2017.
 */
public class Hippodrome {
    static Hippodrome game;
    private List<Horse> horses;
    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome(new ArrayList<>());
        game.getHorses().add(new Horse("Vasilisa", 3, 0));
        game.getHorses().add(new Horse("Voronoy", 3, 0));
        game.getHorses().add(new Horse("Blast", 3, 0));

        game.run();
        game.printWinner();
    }

    public List<Horse> getHorses() {
        return this.horses;
    }

    public void run() throws InterruptedException {
        for(int i = 1; i < 101; i++) {
            this.move();
            this.print();
            Thread.sleep(200);
        }
    }
    public void print(){
        for(Horse horse : getHorses()) {
            horse.print();
        }
        for(int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
    public void move(){
        for(Horse horse : getHorses()) {
            horse.move();
        }
    }

    public Horse getWinner() {
        Horse temp = getHorses().get(0);
        for(Horse horse : getHorses()) {
            if(temp.getDistance() < horse.getDistance()) {
                temp = horse;
            }
        }
        return temp;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
