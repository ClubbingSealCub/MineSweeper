package presenter;

import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.Square;

public class MouseHandler {

    public static void HandleMouse(MouseEvent e, JButton[][] grid, Square[][] board, JFrame frame) throws Exception {
        JButton src = (JButton) e.getSource();
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (src == grid[x][y] && board[x][y].getState().equals("hidden") && MineSweeper.isGameState()) {
                    if (SwingUtilities.isRightMouseButton(e)) {
                        FlagAndQuestionHandler.FlagAndQuestion(board[x][y], grid[x][y]);
                        if (WinStateChecker.WinCheck(board, MineSweeper.getMines())) {
                            JOptionPane.showMessageDialog(frame, "You won! Congratulations!", "Game Over", JOptionPane.PLAIN_MESSAGE);
                            MineSweeper.setGameState(false);
                        }
                    }
                    if (SwingUtilities.isLeftMouseButton(e)) {
                        if (MineSweeper.isNoClicksYet()) {
                            board[x][y].setState("REVEALED"); 
                            // grid[x][y] COLOREAR Y TAL
                            MineLoader.FillBoard(board, MineSweeper.getMines());
                            board[x][y].setState("HIDDEN");
                            MineSweeper.setNoClicksYet(false);
                        }
                        board[x][y].revealEnMasse();
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
