package model;

public class Board {

    private final Square[][] board;

    public Board(int size) {
        board = new Square[8][8];
    }

    public int getSize() {
        return board.length;
    }

    public Square getSquare(int pos1, int pos2) {
        if (pos1 < board.length && pos2 < board.length) {
            return board[pos1][pos2];
        } else {
            return null;
        }
    }

    

}
