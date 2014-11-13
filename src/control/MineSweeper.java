package control;

import model.Square;
import persistence.MineLoader;
import process.ButtonGridMaker;

public class MineSweeper {

    public static void main(String[] args) {
        Square[][] board = new Square[8][8];
        for (Square[] board1 : board) {
            for (int j = 0; j < board.length; j++) {
                board1[j] = new Square();
            }
        }
        if((board[1][1])==null) System.out.println("Nulo");
        ButtonGridMaker buttonGrid = new ButtonGridMaker(8, 8, board);
        MineLoader.FillBoard(board, 10);
    }

}
