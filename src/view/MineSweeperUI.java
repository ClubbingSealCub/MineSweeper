package view;

import java.awt.Dimension;
import javax.swing.JFrame; //imports JFrame library
import javax.swing.JButton; //imports JButton library
import java.awt.GridLayout; //imports GridLayout library
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CellButton;
import model.Square;
import presenter.MouseHandler;

public class MineSweeperUI implements MouseListener {

    static JFrame frame;
    CellButton[][] grid;
    Square[][] board;

    public static void Dispose() {
        frame.dispose();
    }

    public MineSweeperUI(int width, int length, Square[][] sourceBoard) {
        frame = new JFrame("MineSweeper");
        board = sourceBoard;
        frame.setLayout(new GridLayout(width, length));
        frame.setPreferredSize(new Dimension(width * 44, length * 44));
        frame.setResizable(false);
        frame.setJMenuBar(MineSweeperMenu.menuBar());
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        grid = new CellButton[width][length];
        for (int y = 0; y < length; y++) {
            for (int x = 0; x < width; x++) {
                grid[x][y] = new CellButton();
                grid[x][y].setSize(10, 10);
                frame.add(grid[x][y]);
                grid[x][y].addMouseListener(this);
            }
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            MouseHandler.HandleMouse(e, grid, board, frame);
        } catch (Exception ex) {
            Logger.getLogger(MineSweeperUI.class.getName()).log(Level.SEVERE, null, ex);
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
}
