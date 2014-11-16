package presenter;

import java.awt.Color;
import model.Square;

public class SquareHandler {

    public static boolean MineCheck(Square square) {
        return square.isMine();
    }

    public static void Flagger(Square square) {
        square.setFlag(!square.isFlag());
    }
    
    public static void Cover(Square square){
        if (!square.isHidden()){
            square.setHidden(true);
        }
    }

    public static void Reveal(Square square){
        if (square.isHidden()) {
            square.setHidden(false);
            square.getSquareButton().setText(Integer.toString(MineLocator.LocateNearbyMines(square)));
            square.getSquareButton().setBackground(Color.GRAY);
        }
    }
}
