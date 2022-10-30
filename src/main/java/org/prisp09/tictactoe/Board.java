package org.prisp09.tictactoe;

import java.util.ArrayList;

public class Board {
    private ArrayList<Piece> grid;

    public Board(){
        this.initializeGrid();
    }
    private Boolean initializeGrid() {
        this.grid = new ArrayList<>();
        for(int i = 0; i<9; i++) {
            this.grid.add(null);
        }
        return true;
    }

    public Piece getPiece(int i){
        return this.grid.get(i);
    }

    public Boolean setPiece(int i, Piece piece){
        if(!this.canPlace(i))
            return false;

        this.grid.set(i, piece);
        return true;
    }

    public Boolean canPlace(int i){
        return getPiece(i) == null ? true : false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < 9; i+=3){
            stringBuilder.append("[");
            stringBuilder.append(" " + (this.grid.get(i)==null ? " ":this.grid.get(i)) + " |");
            stringBuilder.append(" " + (this.grid.get(i+1)==null ? " ":this.grid.get(i+1)) + " |");
            stringBuilder.append(" " + (this.grid.get(i+2)==null ? " ":this.grid.get(i+2)));
            stringBuilder.append(" ]\n" );
        }
        return stringBuilder.toString();
    }

}
