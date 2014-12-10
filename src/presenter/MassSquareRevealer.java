package presenter;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.Square;

public class MassSquareRevealer {

    public static void RevealMassSquares(Square square) throws Exception {
        if (MineSweeper.isGameState()) {
            if (square.isMine()) {
                square.reveal();
            }
            if (!square.isMine() && !"REVEALED".equals(square.getState())) {
                square.reveal();
                if (square.getNearbyMines() == 0) {
                    for (int i = 0; i < square.getAdjacent().size(); i++) {
                        try {
                            RevealMassSquares(square.getAdjacent().get(i));
                        } catch (Exception ex) {
                            Logger.getLogger(MassSquareRevealer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }
    }
}
