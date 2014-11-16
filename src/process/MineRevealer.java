package process;

import java.awt.Color;
import model.Square;

public class MineRevealer {

    public static void RevealMines(Square[][] board) {
        for (Square[] squares : board) {
            for (Square sq : squares) {
                if (sq.isMine()) {
                    sq.setHidden(false);
                    sq.getSquareButton().setText("B");
                    sq.getSquareButton().setBackground(Color.red);
                }
            }
        }
    }

    public static void RevealMine(Square square) {
        square.setHidden(false);
        square.getSquareButton().setText("B");
        square.getSquareButton().setBackground(Color.red);
    }
}
