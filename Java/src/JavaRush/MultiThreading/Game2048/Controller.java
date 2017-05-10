package JavaRush.MultiThreading.Game2048;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Dreawalker on 06.05.2017.
 */
public class Controller extends KeyAdapter {

    private Model model;
    private View view;
    private static final int WINNING_TILE = 2048;

    public Controller(Model model) {
        this.model = model;
        view = new View(this);
    }

    public Tile[][] getGameTiles() {
        return model.getGameTiles();
    }

    public int getScore() {
       return model.score;
    }

    public void resetGame() {
        view.isGameWon = false;
        view.isGameLost = false;
        model.score = 0;
        model.resetGameTiles();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            resetGame();
        }
        if(!model.canMove()) {
            view.isGameLost = true;
        }
        if(!view.isGameLost & !view.isGameWon) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_LEFT: model.left(); break;
                case KeyEvent.VK_RIGHT: model.right(); break;
                case KeyEvent.VK_UP: model.up(); break;
                case KeyEvent.VK_DOWN: model.down(); break;
                case KeyEvent.VK_Z: model.rollback(); break;
                case KeyEvent.VK_R: model.randomMove(); break;
                case KeyEvent.VK_A: model.autoMove();
            }
        }
        if(model.maxTile == WINNING_TILE) {
            view.isGameWon = true;
        }

        view.repaint();
    }

    public View getView() {
        return view;
    }
}
