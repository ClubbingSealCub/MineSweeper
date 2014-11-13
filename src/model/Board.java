package model;

public class Board {

    public final Square[][] board;

    public Board(int size) {
       board = new Square[size][size];
    }

    public int getSize() {
        return board.length;
    }

    public Square getSquare(int x, int y) {
        return board[x][y];
    }
}
