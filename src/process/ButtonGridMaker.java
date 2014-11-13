package process;

import javax.swing.JFrame; //imports JFrame library
import javax.swing.JButton; //imports JButton library
import java.awt.GridLayout; //imports GridLayout library
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Square;

public class ButtonGridMaker implements ActionListener {

    JFrame frame = new JFrame("MineSweeper"); //creates frame
    JButton[][] grid; //names the grid of buttons
    Square[][] board;
    public ButtonGridMaker(int width, int length, Square[][] sourceBoard) { //constructor
        board = sourceBoard;
        frame.setLayout(new GridLayout(width, length)); //set layout
        grid = new JButton[width][length]; //allocate the size of grid
        for (int y = 0; y < length; y++) {
            for (int x = 0; x < width; x++) {
                grid[x][y] = new JButton(/*"("+x+","+y+")"*/); //creates new button     
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
                if(src==grid[x][y]){
                    MassSquareRevealer.RevealMassSquares(board[x][y]);
                    WinStateChecker.WinCheck(board);
                }
            }
        }
    }

}
