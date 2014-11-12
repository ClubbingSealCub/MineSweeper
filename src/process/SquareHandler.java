package process;

import model.Square;

public class SquareHandler {

    public static boolean MineCheck(Square square) {
        return square.isMine();
    }

    public static void Flagger(Square square) {
        square.setFlag(!square.isFlag());
    }

    public static void Reveal(Square square) {
        if (square.isHidden()) {
            square.setHidden(false);
        }
    }
}
