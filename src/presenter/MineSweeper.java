package presenter;

import model.Square;
import persistence.MineLoader;
import process.AdjacentSquareSetter;
import ui.MineSweeperUI;
public class MineSweeper {
    static String difficulty = "Beginner";
    static boolean gameState = true; 
    
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
        
    public static void startGame(String difficulty) {
        int size=8;
        int mines=10;
        setGameState(true);
        switch(difficulty) {
            case "Beginner":
                size = 8;
                mines = 10;
                break;
            case "Intermediate":
                size = 12;
                mines = 22;
                break;
            case "Expert":
                size = 16;
                mines = 40;
                break;
        }
        Square[][] board = new Square[size][size];
        for (Square[] board1 : board) {
            for (int j = 0; j < board.length; j++) {
                board1[j] = new Square();
            }
        }
        AdjacentSquareSetter.setAdjacentSquares(board);
        MineSweeperUI buttonGrid = new MineSweeperUI(size, size, board);
        MineLoader.FillBoard(board, mines);
    }
    
    public static void main(String[] args){
        startGame(difficulty);
    }
}
