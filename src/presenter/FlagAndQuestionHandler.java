package presenter;

import model.Square;

public class FlagAndQuestionHandler {

    public static void FlagAndQuestion(Square square) throws Exception {
        if (square.getState().equals("flagged")) {
            square.setState("QUESTION");
        } else if (square.getState().equals("QUESTION")){
            square.setState("HIDDEN");
        } else {
            square.setState("FLAGGED");
        }
    }
}
