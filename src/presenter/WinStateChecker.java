package presenter;

import model.Square;

public class WinStateChecker {

    public static boolean WinCheck(Square[][] board, int mines) {
        int hiddenSquareCounter = 0;
        int flaggedMineCounter = 0;
        for (Square[] board1 : board) {
            for (Square board11 : board1) {
                if (board11.getState().equals("HIDDEN") && !board11.isMine()) {
                    hiddenSquareCounter++;
                }
                if (board11.getState().equals("FLAG") && board11.isMine()) {
                    flaggedMineCounter++;
                }
            }
        }
        if (flaggedMineCounter == mines) {
            return true;
        }
        return hiddenSquareCounter == 0;
    }
}
