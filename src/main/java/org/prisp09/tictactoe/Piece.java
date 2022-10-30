package org.prisp09.tictactoe;

public class Piece {
    private Boolean isCross = false;

    public Piece(Boolean isCross){
        this.isCross = isCross;
    }

    public Boolean isCross(){
        return this.isCross;
    }

    public void setIsCross(Boolean isCross){
        this.isCross = isCross;
    }

    @Override
    public String toString() {
        if(isCross){
            return "x";
        }
        return "o";
    }
}
