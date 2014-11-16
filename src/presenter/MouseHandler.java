package presenter;

import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.Square;
import presenter.MineSweeper;

public class MouseHandler {
    public static void HandleMouse(MouseEvent e, JButton[][] grid, Square[][] board, JFrame frame){
    JButton src = (JButton) e.getSource();
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (src == grid[x][y] && board[x][y].isHidden() && MineSweeper.isGameState()) {
                    if (SwingUtilities.isRightMouseButton(e)) {
                        FlagHandler.Flag(board[x][y]);
                    }
                    if (SwingUtilities.isLeftMouseButton(e)) {
                        if(MineSweeper.isNoClicksYet()){
                            SquareHandler.Reveal(board[x][y]);
                            MineLoader.FillBoard(board, MineSweeper.getMines());
                            SquareHandler.Cover(board[x][y]);
                            MineSweeper.setNoClicksYet(false);
                        }
                        MassSquareRevealer.RevealMassSquares(board[x][y]);
                        if (SquareHandler.MineCheck(board[x][y])) {
                            JOptionPane.showMessageDialog(frame, "Whoops! You stepped on a mine!", "Game Over", JOptionPane.ERROR_MESSAGE);
                            MineRevealer.RevealMines(board);
                            MineSweeper.setGameState(false);
                        }
                        if (WinStateChecker.WinCheck(board)) {
                            JOptionPane.showMessageDialog(frame, "You won! Congratulations!", "Game Over", JOptionPane.PLAIN_MESSAGE);
                            MineSweeper.setGameState(false);
                        }
                    }
                }
            }
        }}
}
