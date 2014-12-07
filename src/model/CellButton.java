package model;

import java.awt.Color;
import javax.swing.JButton;

public class CellButton extends JButton {

    public CellButton() {
        super();
    }

    public void setMine() {
        this.setText("B");
        this.setBackground(Color.RED);
    }

    public void reveal(Square square) throws Exception {
        if (!square.isMine()) {
            this.setText(Integer.toString(square.getNearbyMines()));
            this.setBackground(Color.GRAY);
        }
        else setMine();
    }

    public void flag() throws Exception {
        this.setText("F");
    }

    public void question() throws Exception {
        this.setText("?");
    }
}
