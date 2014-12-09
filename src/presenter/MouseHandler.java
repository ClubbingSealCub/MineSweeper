package presenter;

import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.CellButton;
import model.Square;

public class MouseHandler {

    public static void HandleMouse(MouseEvent e, CellButton cell, Square square, JFrame frame) throws Exception {
        if (!square.getState().equals("REVEALED") && MineSweeper.isGameState()) {
            if (SwingUtilities.isRightMouseButton(e)) {
                FlagAndQuestionHandler.FlagAndQuestion(square, cell);
                if (WinStateChecker.WinCheck(MineSweeper.getBoard(), MineSweeper.getMines())) {
                    JOptionPane.showMessageDialog(frame, "You won! Congratulations!", "Game Over", JOptionPane.PLAIN_MESSAGE);
                    MineSweeper.setGameState(false);
                }
            }
            if (SwingUtilities.isLeftMouseButton(e)) {
                if (MineSweeper.isNoClicksYet()) {
                    square.setState("REVEALED");
                    MineLoader.FillBoard(MineSweeper.getBoard(), MineSweeper.getMines());
                    square.setState("HIDDEN");
                    MineSweeper.setNoClicksYet(false);
                }
                MassSquareRevealer.RevealMassSquares(square, cell);
                if (square.isMine()) {
                    JOptionPane.showMessageDialog(frame, "Whoops! You stepped on a mine!", "Game Over", JOptionPane.ERROR_MESSAGE);
                    MineRevealer.RevealMines(MineSweeper.getBoard(), MineSweeper.getGrid());
                    MineSweeper.setGameState(false);
                }
                if (WinStateChecker.WinCheck(MineSweeper.getBoard(), MineSweeper.getMines())) {
                    JOptionPane.showMessageDialog(frame, "You won! Congratulations!", "Game Over", JOptionPane.PLAIN_MESSAGE);
                    MineSweeper.setGameState(false);
                }
            }
        }
    }
}
