package presenter;

import model.Square;

public class AdjacentSquareSetter {

    public static void setAdjacentSquares(Square[][] board) throws Exception {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board.length; y++) {
                for (int a = x; a < x + 2; a++) {
                    for (int b = y; b < y + 2; b++) {
                        if (a > 0 && b > 0 && a < board.length && b < board.length && (a!=b && a!=1)) {
                            board[x][y].addAdjacent(board[a][b]);
                            System.out.println(x+":"+y+" is now adjacent to "+a+":"+b);
                        }
                    }
                }
            }
        }
    }
}
