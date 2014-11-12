package persistence;

import java.util.Arrays;
import java.util.Random;
import model.Board;

public class BoardLoader {
    int pos1[];
    int pos2[];

    public BoardLoader() {
        pos1 = new int[10];
        pos2 = new int[10];
    }

    public void FillBoard(Board board) {
        Random r = new Random();
        int aux;
        for (int i = 0; i < pos1.length; i++) {
            do {
                aux = r.nextInt(pos1.length);
            } while (Arrays.binarySearch(pos1, aux) > -1);
        }
        for (int i = 0; i < pos2.length; i++) {
            do {
                aux = r.nextInt(pos1.length);
            } while (Arrays.binarySearch(pos2, aux) > -1);
        }
        for (int i = 0; i < pos1.length; i++) {
            board.getSquare(pos1[i],pos2[i]).setMine(true);
        }
    }
}
