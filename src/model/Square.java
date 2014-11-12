package model;

import java.util.Set;

public class Square {

    private boolean mine;
    private boolean flag;
    private boolean hidden;
    private Set<Square> adjacent;
    
    public Square() {
        hidden = true;
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
