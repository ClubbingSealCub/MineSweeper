package presenter;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.CellButton;
import model.Square;

public class MassSquareRevealer {

    public static void RevealMassSquares(Square square, CellButton cell) throws Exception {
        if (MineSweeper.isGameState()) {
            if (square.isMine()) {
                square.setState("REVEALED");
                cell.reveal(square);
            }
            if (!square.isMine() && "HIDDEN".equals(square.getState())) {
                square.setState("REVEALED");
                cell.reveal(square);
                if (square.getNearbyMines() == 0) {
                    for (int i = 0; i < square.getAdjacent().size(); i++) {
                        try {
                            RevealMassSquares(square.getAdjacent().get(i), cell.getAdjacent().get(i));
                        } catch (Exception ex) {
                            Logger.getLogger(MassSquareRevealer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }
    }
}
