package presenter;

import model.CellButton;
import model.Square;

public class FlagAndQuestionHandler {

    public static void FlagAndQuestion(Square square, CellButton cell) throws Exception {
        switch (square.getState()) {
            case "FLAGGED":
                square.setState("QUESTION");
                cell.question();
                break;
            case "QUESTION":
                square.setState("HIDDEN");
                cell.setText(null);
                break;
            default:
                square.setState("FLAGGED");
                cell.flag();
                break;
        }
    }
}
