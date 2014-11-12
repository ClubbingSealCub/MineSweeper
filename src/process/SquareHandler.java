package process;

import model.Square;

public class SquareHandler {

    public boolean MineCheck(Square square) {
        return square.isMine();
    }

    public void SquareFlagger(Square square) {
        square.setFlag(!square.isFlag());
    }

    public void Unveil(Square square) {
        if (square.isHidden()) {
            square.setHidden(false);
        }
    }

}
