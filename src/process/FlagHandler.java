package process;

import model.Square;

public class FlagHandler {

    public static void Flag(Square square) {
        if (square.isFlag()) {
            square.setFlag(false);
            square.getSquareButton().setText(null);
        } else {
            square.getSquareButton().setText("F");
        }
    }
}
