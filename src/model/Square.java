package model;

import java.util.ArrayList;

public class Square {

    private boolean mine;
    private boolean flag;
    private boolean hidden;
    private final ArrayList<Square> adjacent;
    
    public Square() {
        hidden = true;
        mine = false;
        flag = false;
        adjacent = new ArrayList();
    }
    
    public void addAdjacent(Square square2){
        adjacent.add(square2);
    }
    
    public Square[] getAdjacent(){
        return (Square[]) adjacent.toArray();
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
