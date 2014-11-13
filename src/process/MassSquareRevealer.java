package process;

import model.Square;

public class MassSquareRevealer {

    public static void RevealMassSquares(Square sourceSquare) {
        if (!sourceSquare.isMine()) {
            SquareHandler.Reveal(sourceSquare);
        }
        for (Square square : sourceSquare.getAdjacent()) {
            if (!square.isMine()) {
                RevealMassSquares(square);
            }
        }
    }
}
