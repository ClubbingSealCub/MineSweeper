package control;

import model.Board;
import process.ButtonGridMaker;

public class MineSweeper {

    public static void main(String[] args) {
        Board board = new Board(8);
        ButtonGridMaker buttonGrid = new ButtonGridMaker(8, 8, board);
        
    }

}
