package process;

import model.Square;

public class MineLocator {

    public int LocateNearbyMines(Square square) {
        int counter = 0;
        Square[] adjacentSquares = square.getAdjacent();
        for (Square adjacentSquare : adjacentSquares) {
            if (adjacentSquare.isMine()) {
                counter++;
            }
        }
        return counter;
    }
}
