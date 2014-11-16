package process;

import model.Square;

public class LoseStateChecker {

    public static boolean LoseCheck(Square square) {
        return square.isMine();
    }
}
