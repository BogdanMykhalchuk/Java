package JavaRush.MultiThreading.Game2048;

/**
 * Created by Dreawalker on 07.05.2017.
 */
public class MoveEfficiency implements Comparable<MoveEfficiency> {

    private int numberOfEmptyTiles;
    private int score;
    private Move move;

    public MoveEfficiency(int numberOfEmptyTiles, int score, Move move) {
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.score = score;
        this.move = move;
    }

    public Move getMove() {
        return move;
    }

    @Override
    public int compareTo(MoveEfficiency o) {
        int i = Integer.compare(numberOfEmptyTiles, o.numberOfEmptyTiles);
        if(i == 0) {
            i = Integer.compare(score, o.score);
        }
        return i;
    }
}
