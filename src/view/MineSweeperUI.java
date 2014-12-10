package view;

import java.awt.Dimension;
import javax.swing.JFrame; //imports JFrame library
import javax.swing.JButton; //imports JButton library
import java.awt.GridLayout; //imports GridLayout library
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Square;
import presenter.AdjacentSquareSetter;
import presenter.MineSweeper;
import presenter.MouseHandler;

public class MineSweeperUI {

    static final JFrame frame = new JFrame("MineSweeper");

    public static void DisplayWinningMessage() {
        JOptionPane.showMessageDialog(frame, "Whoops! You stepped on a mine!", "Game Over", JOptionPane.ERROR_MESSAGE);
    }

    public static void DisplayLosingMessage() {
        JOptionPane.showMessageDialog(frame, "Whoops! You stepped on a mine!", "Game Over", JOptionPane.ERROR_MESSAGE);
    }
    final Square[][] board;

    public static void Dispose() {
        frame.dispose();
    }

    public MineSweeperUI(int width, int length, Square[][] sourceBoard) throws Exception {
        board = sourceBoard;
        frame.setLayout(new GridLayout(width, length));
        frame.setPreferredSize(new Dimension(width * 44, length * 44));
        frame.setResizable(false);
        frame.setJMenuBar(MineSweeperMenu.menuBar());
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        AdjacentSquareSetter.setAdjacentSquares(board);
        for (int y = 0; y < length; y++) {
            for (int x = 0; x < width; x++) {
                board[x][y] = new Square();
                board[x][y].setSize(10, 10);
                frame.add(board[x][y]);
                board[x][y].addMouseListener(new MouseListener() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (MineSweeper.isGameState()) {
                            try {
                                MouseHandler.HandleMouse(e);
                            } catch (Exception ex) {
                                Logger.getLogger(MineSweeperUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                    }
                });
            }
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
