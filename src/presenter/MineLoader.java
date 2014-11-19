package presenter;

import java.util.Random;
import model.Square;

public class MineLoader {

    public static void FillBoard(Square[][] board, int mines) {
        Random r = new Random();
        int aux1;
        int aux2;
        for (int i = 0; i < mines; i++) {
            do {
                aux1 = r.nextInt(board.length);
                aux2 = r.nextInt(board.length);
            } while ((board[aux1][aux2].isMine()) || !board[aux1][aux2].getState().equals("hidden"));
            System.out.print(aux1 + ":" + aux2 + " ");
            board[aux1][aux2].setMine(true);

        }
        System.out.println("");
    }
}
