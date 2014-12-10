package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

public class Square extends JButton {

    private boolean mine;
    State state;
    private ArrayList<Square> adjacent;

    public boolean isMine() {
        return mine;
    }

    public void setMine(boolean mine) {
        this.mine = mine;
    }

    public void showMine() {
        this.setText("B");
        this.setBackground(Color.RED);
    }

    private enum State {
        HIDDEN, REVEALED, FLAGGED, QUESTION
    };

    public Square() {
        state = State.HIDDEN;
        mine = false;
        adjacent = new ArrayList();
    }

    @Override
    public String toString(){
        return "a";
    }
    
    public String getState() {
        return state.toString();
    }

    public void setState(String newState) throws Exception {
        newState = newState.toUpperCase();
        switch (newState) {
            case "HIDDEN":
                state = State.HIDDEN;
                break;
            case "REVEALED":
                state = State.REVEALED;
                break;
            case "FLAGGED":
                state = State.FLAGGED;
                break;
            case "QUESTION":
                state = State.QUESTION;
                break;
            default:
                throw new Exception("Not a state");
        }
    }

    public void revealEnMasse() throws Exception {
        if (getState().equals("HIDDEN")) {
            reveal();
            if (getNearbyMines() == 0) {
                getAdjacent().stream().forEach((sq) -> {
                    try {
                        sq.revealEnMasse();
                    } catch (Exception ex) {
                        Logger.getLogger(Square.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
            }
        }
    }

    public void addAdjacent(Square adjSquare) {
        adjacent.add(adjSquare);
    }

    public ArrayList<Square> getAdjacent() {
        return adjacent;
    }

    public int getNearbyMines() {
        int counter = 0;
        counter = adjacent.stream().filter((square) -> (square.isMine())).map((_item) -> 1).reduce(counter, Integer::sum);
        return counter;
    }
    
    public void reveal() throws Exception {
        if (!isMine()) {
            this.setText(Integer.toString(getNearbyMines()));
            this.setBackground(Color.GRAY);
            this.setState("REVEALED");
        }
        else showMine();
    }

    public void flag() throws Exception {
        this.setText("F");
        this.setState("FLAGGED");
    }

    public void question() throws Exception {
        this.setText("?");
        this.setState("QUESTION");
    }

}
