package process;

import model.Square;

public class WinStateChecker {
    public static boolean WinCheck(Square[][] board) {
        int hiddenSquareCounter = 0;
        for (Square[] board1 : board) {
            for (Square board11 : board1) {
                if (board11.isHidden() && !board11.isMine()) {
                    hiddenSquareCounter++;
                }
            }
        }
        return hiddenSquareCounter==0;
    }
}
