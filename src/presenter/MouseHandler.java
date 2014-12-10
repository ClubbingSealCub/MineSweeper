package presenter;

import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import model.Square;
import view.MineSweeperUI;

public class MouseHandler {

    public static void HandleMouse(MouseEvent e) throws Exception {
        Square square = (Square) e.getSource();
        for (Square square2 : square.getAdjacent()) {
            System.out.print(square2.toString());
            System.out.println();
        }

        if (!square.getState()
                .equals("REVEALED") && MineSweeper.isGameState()) {
            if (SwingUtilities.isRightMouseButton(e)) {
                FlagAndQuestionHandler.FlagAndQuestion(square);
                if (WinStateChecker.WinCheck(MineSweeper.getBoard(), MineSweeper.getMines())) {
                    MineSweeperUI.DisplayWinningMessage();
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
                MassSquareRevealer.RevealMassSquares(square);
                if (square.isMine()) {
                    MineSweeperUI.DisplayLosingMessage();
                    MineRevealer.RevealMines(MineSweeper.getBoard());
                    MineSweeper.setGameState(false);
                }
                if (WinStateChecker.WinCheck(MineSweeper.getBoard(), MineSweeper.getMines())) {
                    MineSweeperUI.DisplayWinningMessage();
                    MineSweeper.setGameState(false);
                }
            }
        }
    }
}
