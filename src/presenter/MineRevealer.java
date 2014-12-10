package presenter;

import model.Square;

public class MineRevealer {

    public static void RevealMines(Square[][] board) throws Exception {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].isMine()) {
                    board[i][j].setState("REVEALED");
                    board[i][j].showMine();
                }
            }
        }
    }

    public static void RevealMine(Square square) throws Exception {
        square.setState("REVEALED");
        square.showMine();
    }
}
