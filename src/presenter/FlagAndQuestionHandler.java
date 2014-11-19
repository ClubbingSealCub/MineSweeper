package presenter;

import javax.swing.JButton;
import model.Square;

public class FlagAndQuestionHandler {

    public static void FlagAndQuestion(Square square, JButton button) throws Exception {
        if (square.getState().equals("flagged")) {
            square.setState("QUESTION");
            button.setText("?");
        } else if (square.getState().equals("QUESTION")){
            square.setState("HIDDEN");
            button.setText(null);
        } else {
            square.setState("FLAGGED");
            button.setText("F");
        }
    }
}
