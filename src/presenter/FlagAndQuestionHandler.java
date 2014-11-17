package presenter;

import model.Square;

public class FlagAndQuestionHandler {

    public static void FlagAndQuestion(Square square) {
        if (square.isFlag()) {
            square.setFlag(false);
            square.setQuestion(true);
            square.getSquareButton().setText("?");
        } else if (square.isQuestion()){
            square.setQuestion(false);
            square.getSquareButton().setText(null);
        } else {
            square.setFlag(true);
            square.getSquareButton().setText("F");
        }
    }
}
