package model;

public class Board {

    private Square[][] board;

    public Board(int size) {
        board = new Square[size][size];
    }

    public int getSize() {
        return board.length;
    }

    public Square getSquare(int pos1, int pos2) {
        return board[pos1][pos2];
    }
}
