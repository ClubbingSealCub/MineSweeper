package presenter;

import model.Square;

public class MassSquareRevealer {

    public static void RevealMassSquares(Square square) {
        if (MineSweeper.isGameState()) {
            if (square.isMine()) {
                MineRevealer.RevealMine(square);
            }
            if (!square.isMine() && square.isHidden()) {
                SquareHandler.Reveal(square);
                if (MineLocator.LocateNearbyMines(square) == 0) {
                    square.getAdjacent().stream().forEach((sq) -> {
                        RevealMassSquares(sq);
                    });
                }
            }
        }
    }
}