package view;

import java.awt.Dimension;
import javax.swing.JFrame; //imports JFrame library
import javax.swing.JButton; //imports JButton library
import java.awt.GridLayout; //imports GridLayout library
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import model.Square;
import presenter.MouseHandler;

public class MineSweeperUI implements MouseListener {

    static JFrame frame; //creates frame
    JButton[][] grid; //names the grid of buttons
    Square[][] board;

    public static void Dispose() {
        frame.dispose();
    }

    public MineSweeperUI(int width, int length, Square[][] sourceBoard) { //constructor
        frame = new JFrame("MineSweeper");
        board = sourceBoard;
        frame.setLayout(new GridLayout(width, length)); //set layout
        frame.setPreferredSize(new Dimension(width * 44, length * 44));
        frame.setResizable(false);
        frame.setJMenuBar(MineSweeperMenu.menuBar());
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        grid = new JButton[width][length]; //allocate the size of grid
        for (int y = 0; y < length; y++) {
            for (int x = 0; x < width; x++) {
                grid[x][y] = new JButton(""); //creates new button
                board[x][y].setSquareButton(grid[x][y]);
                grid[x][y].setSize(10, 10);
                frame.add(grid[x][y]); //adds button to grid
                grid[x][y].addMouseListener(this);
            }
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack(); //sets appropriate size for frame
        frame.setVisible(true); //makes frame visible
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        MouseHandler.HandleMouse(e, grid, board, frame);
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
