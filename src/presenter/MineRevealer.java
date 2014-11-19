package presenter;

import java.awt.Color;
import javax.swing.JButton;
import model.Square;

public class MineRevealer {

    public static void RevealMines(Square[][] board, JButton[][] grid) throws Exception {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (board[i][j].isMine()) {
                    board[i][j].setState("REVEALED");
                    grid[i][j].setText("B");
                    grid[i][j].setBackground(Color.red);
                }
            }
        }
    }

    public static void RevealMine(Square square, JButton button) throws Exception {
        square.setState("REVEALED");
        button.setText("B");
        button.setBackground(Color.red);
    }
}
