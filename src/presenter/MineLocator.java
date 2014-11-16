package presenter;

import java.util.ArrayList;
import model.Square;

public class MineLocator {

    public static int LocateNearbyMines(Square square) {
        int counter = 0;
        ArrayList<Square> adjacentSquares = square.getAdjacent();
        counter = adjacentSquares.stream().filter((adjacentSquare) -> (adjacentSquare.isMine())).map((_item) -> 1).reduce(counter, Integer::sum);
        return counter;
    }
}
