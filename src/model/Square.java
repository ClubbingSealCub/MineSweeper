package model;

import java.util.ArrayList;
import javax.swing.JButton;

public class Square {

    private boolean mine;
    private boolean flag;
    private boolean hidden;
    private boolean question;
    private final ArrayList<Square> adjacent;
    JButton squareButton;
    
    public Square() {
        hidden = true;
        mine = false;
        flag = false;
        question = false;
        adjacent = new ArrayList();
    }

    public boolean isQuestion() {
        return question;
    }

    public void setQuestion(boolean question) {
        this.question = question;
    }

    public void setSquareButton(JButton squareButton) {
        this.squareButton = squareButton;
    }

    public JButton getSquareButton() {
        return squareButton;
    }
    
    public void addAdjacent(Square adjSquare){
        adjacent.add(adjSquare);
    }
    
    public ArrayList<Square> getAdjacent(){
        return adjacent;
    }
    
    public boolean isMine() {
        return mine;
    }

    public void setMine(boolean mine) {
        this.mine = mine;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

}
