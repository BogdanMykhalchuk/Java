package Test;

public final class TestTest {

    public static void main(String[] args) {
        int[][] tiles = new int[4][4];

        int count = 0;

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                tiles[i][j] = ++count;
            }
        }

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                System.out.print(tiles[i][j] + " ");
            }
            System.out.println();
        }

        int[][] temp = new int[4][4];
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                temp[j][4 - 1 - i] = tiles[i][j];
            }
        }

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                System.out.print(temp[i][j] + " ");
            }
            System.out.println();
        }
    }
}


