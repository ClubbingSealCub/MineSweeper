package presenter;

import model.Square;

public class AdjacentSquareSetter {

    public static void setAdjacentSquares(Square[][] board) throws Exception {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j].setState("HIDDEN");
                for (int k = i - 1; k < i + 2; k++) {
                    for (int l = j - 1; l < j + 2; l++) {
                        if (k > -1 && l > -1 && k < board.length && l < board.length) {
                            board[i][j].addAdjacent(board[k][l]);
                        }
                    }
                }
            }
        }
    }
}

