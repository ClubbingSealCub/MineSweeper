package process;

import model.Board;

public class WinStateChecker {
    public static boolean WinCheck(Board board) {
        int hiddenSquareCounter = 0;
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (board.getSquare(i, j).isHidden()) {
                    hiddenSquareCounter++;
                }
            }
        }
        return hiddenSquareCounter==0;
    }
}
