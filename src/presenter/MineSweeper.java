package presenter;

import model.Square;
import view.MineSweeperUI;

public class MineSweeper {

    private static Square[][] board;

    public static void setBoard(Square[][] board) {
        MineSweeper.board = board;
    }
    private static String difficulty = "Beginner";
    private static boolean gameState = true;
    private static boolean noClicksYet = true;
    private static int mines = 10;
    private static int size = 8;

    public static int getMines() {
        return mines;
    }

    public static void setMines(int mines) {
        MineSweeper.mines = mines;
    }

    public static int getSize() {
        return size;
    }

    public static void setSize(int size) {
        MineSweeper.size = size;
    }

    public static void setDifficulty(String sDifficulty) {
        difficulty = sDifficulty;
    }

    public static String getDifficulty() {
        return difficulty;
    }

    public static boolean isGameState() {
        return gameState;
    }

    public static void setGameState(boolean gameState) {
        MineSweeper.gameState = gameState;
    }

    public static void startGame(String difficulty) throws Exception {
        setGameState(true);
        setNoClicksYet(true);
        switch (difficulty) {
            case "Beginner":
                setSize(8);
                setMines(10);
                break;
            case "Intermediate":
                setSize(12);
                setMines(22);
                break;
            case "Expert":
                setSize(16);
                setMines(40);
                break;
        }
        board = new Square[getSize()][getSize()];
        for (Square[] board1 : board) {
            for (int j = 0; j < board.length; j++) {
                board1[j] = new Square();
            }
        }
        AdjacentSquareSetter.setAdjacentSquares(board);
        MineSweeperUI buttonGrid = new MineSweeperUI(getSize(), getSize(), board);
    }

    public static boolean isNoClicksYet() {
        return noClicksYet;
    }

    public static void setNoClicksYet(boolean noClicksYet) {
        MineSweeper.noClicksYet = noClicksYet;
    }

    public static void main(String[] args) throws Exception {
        startGame(difficulty);
    }

    public static Square[][] getBoard() {
        return board;
    }

}
