package presenter;

import model.Square;

public class FlagAndQuestionHandler {

    public static void FlagAndQuestion(Square square) throws Exception {
        switch (square.getState()) {
            case "FLAGGED":
                square.setState("QUESTION");
                square.question();
                break;
            case "QUESTION":
                square.setState("HIDDEN");
                square.setText(null);
                break;
            default:
                square.setState("FLAGGED");
                square.flag();
                break;
        }
    }
}
