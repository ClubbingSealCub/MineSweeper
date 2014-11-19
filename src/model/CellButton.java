package model;

import java.awt.Color;
import javax.swing.JButton;

public class CellButton extends JButton {
    
    Square square;
    
    public CellButton(Square square){
        this.square = square;
    }
    
    public void setMine(){
        this.setText("B");
        this.setBackground(Color.RED);
    }
    
    public void reveal(){
    }
}
