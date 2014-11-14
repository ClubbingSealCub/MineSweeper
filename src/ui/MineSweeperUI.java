package ui;

import java.awt.Dimension;
import javax.swing.JFrame; //imports JFrame library
import javax.swing.JButton; //imports JButton library
import java.awt.GridLayout; //imports GridLayout library
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Square;
import process.LoseStateChecker;
import process.MassSquareRevealer;
import process.MineRevealer;
import process.WinStateChecker;

public class MineSweeperUI implements ActionListener {

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
                grid[x][y].addActionListener(this);
            }
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack(); //sets appropriate size for frame
        frame.setVisible(true); //makes frame visible
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton src = (JButton) e.getSource();
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (src == grid[x][y] && board[x][y].isHidden()) {
                    MassSquareRevealer.RevealMassSquares(board[x][y]);
                    if (LoseStateChecker.LoseCheck(board[x][y])) {
                        JOptionPane.showMessageDialog(frame, "Whoops! You stepped on a mine!", "Game Over", JOptionPane.ERROR_MESSAGE);
                        MineRevealer.RevealMines(board);
                    }
                    if (WinStateChecker.WinCheck(board)) {
                        JOptionPane.showMessageDialog(frame, "You won! Congratulations!", "Game Over", JOptionPane.PLAIN_MESSAGE);
                    }
                }
            }
        }
    }

}
