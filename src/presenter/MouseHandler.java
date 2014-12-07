package presenter;

import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.CellButton;
import model.Square;

public class MouseHandler {

    public static void HandleMouse(MouseEvent e, CellButton[][] grid, Square[][] board, JFrame frame) throws Exception {
        CellButton src = (CellButton) e.getSource();
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (src == grid[x][y] && board[x][y].getState().equals("HIDDEN") && MineSweeper.isGameState()) {
                    if (SwingUtilities.isRightMouseButton(e)) {
                        FlagAndQuestionHandler.FlagAndQuestion(board[x][y]);
                        if (WinStateChecker.WinCheck(board, MineSweeper.getMines())) {
                            JOptionPane.showMessageDialog(frame, "You won! Congratulations!", "Game Over", JOptionPane.PLAIN_MESSAGE);
                            MineSweeper.setGameState(false);
                        }
                    }
                    if (SwingUtilities.isLeftMouseButton(e)) {
                        if (MineSweeper.isNoClicksYet()) {
                            board[x][y].setState("REVEALED");
                            MineLoader.FillBoard(board, MineSweeper.getMines());
                            board[x][y].setState("HIDDEN");
                            MineSweeper.setNoClicksYet(false);
                        }
                        MassSquareRevealer.RevealMassSquares(board[x][y]);
                        grid[x][y].reveal(board[x][y]);
                        if ("HIDDEN".equals(board[x][y].getState())) {
                            if (board[x][y].isMine()) {
                                JOptionPane.showMessageDialog(frame, "Whoops! You stepped on a mine!", "Game Over", JOptionPane.ERROR_MESSAGE);
                                MineRevealer.RevealMines(board, grid);
                                MineSweeper.setGameState(false);
                            }
                            if (WinStateChecker.WinCheck(board, MineSweeper.getMines())) {
                                JOptionPane.showMessageDialog(frame, "You won! Congratulations!", "Game Over", JOptionPane.PLAIN_MESSAGE);
                                MineSweeper.setGameState(false);
                            }
                        }
                    }
                }
            }
        }
    }
}
