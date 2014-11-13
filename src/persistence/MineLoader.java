package persistence;

import java.util.Random;
import model.Board;

public class MineLoader {

    public MineLoader() {
    }

    public void FillBoard(Board board, int mines) {
        Random r = new Random();
        int aux1;
        int aux2;
        for (int i = 0; i < 10; i++) {
            do {
                aux1 = r.nextInt(board.getSize());
                aux2 = r.nextInt(board.getSize());
            } while (board.getSquare(aux1, aux2) == null || board.getSquare(aux1, aux2).isMine());
            System.out.println(aux1+":"+aux2);
            if (board.getSquare(aux1, aux2) != null)  {
                board.getSquare(aux1, aux2).setMine(true);
                System.out.println("Mine Planted!");
            }
        }
    }
}
