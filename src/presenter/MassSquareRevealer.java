package presenter;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.CellButton;
import model.Square;

public class MassSquareRevealer {

    public static void RevealMassSquares(Square square) throws Exception {
        if (MineSweeper.isGameState()) {
            if (square.isMine()) {
                square.setState("REVEALED");
            }
            if (!square.isMine() && "HIDDEN".equals(square.getState())) {
                square.setState("REVEALED");
                if (square.getNearbyMines() == 0) {
                    square.getAdjacent().stream().forEach((sq) -> {
                        try {
                            RevealMassSquares(sq);
                        } catch (Exception ex) {
                            Logger.getLogger(MassSquareRevealer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });
                }
            }
        }
    }
}
