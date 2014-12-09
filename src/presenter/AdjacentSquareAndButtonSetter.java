package presenter;

import model.CellButton;
import model.Square;

public class AdjacentSquareAndButtonSetter {

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

    public static void setAdjacentButtons(CellButton[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                for (int k = i - 1; k < i + 2; k++) {
                    for (int l = j - 1; l < j + 2; l++) {
                        if (k > -1 && l > -1 && k < grid.length && l < grid.length) {
                            grid[i][j].addAdjacent(grid[k][l]);
                        }
                    }
                }
            }
        }
    }
}

