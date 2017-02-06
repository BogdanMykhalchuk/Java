package Test;

/**
 * Created by Dreawalker on 26.07.2016.
 */

public class Deck {

    public static int numSuits = 4;
    public static int numRanks = 13;
    public static int numCards = numSuits * numRanks;

    private Card[][] cards;

    public Deck() {
        cards = new Card[numSuits][numRanks];
        for (int suit = Card.DIAMONDS; suit <= Card.SPADES; suit++) {
            for (int rank = Card.ACE; rank <= Card.KING; rank++) {
                cards[suit-1][rank-1] = new Card(rank, suit);
            }
        }
    }

    public Card getCard(int suit, int rank) {
        return cards[suit-1][rank-1];
    }

    /**
     * Created by Dreawalker on 21.07.2016.
     */
    public static class Rectangle {
        public int width = 0;
        public int height = 0;
        public Test_Point origin;

        // four constructors
        public Rectangle() {
            origin = new Test_Point(0, 0);
        }
        public Rectangle(Test_Point p) {
            origin = p;
        }
        public Rectangle(int w, int h) {
            origin = new Test_Point(0, 0);
            width = w;
            height = h;
        }
        public Rectangle(Test_Point p, int w, int h) {
            origin = p;
            width = w;
            height = h;
        }

        // a method for moving the rectangle
        public void move(int x, int y) {
            origin.x = x;
            origin.y = y;
        }

        // a method for computing the area of the rectangle
        public int getArea() {
            return width * height;
        }
    }
}
