package process;

import model.Square;

public class AdjacentSquareSetter {
    public void setAdjacentSquares(Square[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                for (int k = -1; k < 2; k++) {
                    for (int l = -1; l < 2; l++) {
                        if(i+k < board.length && i+k > -1 && j+l < board.length && j+l > -1 && (k!=0 && l!=0)){
                            board[i][j].addAdjacent(board[i+k][j+l]);
                        }
                    }
                }
            }
        }
    }
}
