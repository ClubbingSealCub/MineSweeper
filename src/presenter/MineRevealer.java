package presenter;

import model.CellButton;
import model.Square;

public class MineRevealer {

    public static void RevealMines(Square[][] board, CellButton[][] grid) throws Exception {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (board[i][j].isMine()) {
                    board[i][j].setState("REVEALED");
                    grid[i][j].setMine();
                }
            }
        }
    }

    public static void RevealMine(Square square, CellButton button) throws Exception {
        square.setState("REVEALED");
        button.setMine();
    }
}
