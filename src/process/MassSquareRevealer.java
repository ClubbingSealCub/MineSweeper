package process;

import java.awt.Color;
import model.Square;
import presenter.MineSweeper;

public class MassSquareRevealer {

    public static void RevealMassSquares(Square square) {
        if (MineSweeper.isGameState()) {
            if (square.isMine()) {
                square.getSquareButton().setText("B");
                square.getSquareButton().setBackground(Color.red);
            }
            if (!square.isMine() && square.isHidden()) {
                SquareHandler.Reveal(square);
                square.getSquareButton().setText(Integer.toString(MineLocator.LocateNearbyMines(square)));
                square.getSquareButton().setBackground(Color.GRAY);
                if (MineLocator.LocateNearbyMines(square) == 0) {
                    square.getAdjacent().stream().forEach((sq) -> {
                        RevealMassSquares(sq);
                    });
                }
            }
        }
    }
}