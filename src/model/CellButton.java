package model;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;

public class CellButton extends JButton {
    
    private final ArrayList<CellButton> adjacent;

    public CellButton() {
        super();
        adjacent = new ArrayList<>();
    }
    
    public void addAdjacent(CellButton adjButton) {
        adjacent.add(adjButton);
    }

    public ArrayList<CellButton> getAdjacent() {
        return adjacent;
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
