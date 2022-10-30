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

    public Integer checkWin(){ //return 1 if x wins, return 2 if o wins, 0 if no one is winning
        /*
        x x x
        . . .
        . . .
         */
        if(this.getPiece(0)!=null&&this.getPiece(0).equals(this.getPiece(1))&&this.getPiece(1).equals(this.getPiece(2))){
            return this.getPiece(0).isCross() ? 1 : 2;
        }
        /*
        . . .
        x x x
        . . .
         */
        if (this.getPiece(3)!=null&&this.getPiece(3).equals(this.getPiece(4))&&this.getPiece(4).equals(this.getPiece(5))){
            return this.getPiece(3).isCross() ? 1 : 2;
        }

        /*
        . . .
        . . .
        x x x
         */
        if (this.getPiece(6)!=null&&this.getPiece(6).equals(this.getPiece(7))&&this.getPiece(7).equals(this.getPiece(8))){
            return this.getPiece(6).isCross() ? 1 : 2;
        }

        /*
        x . .
        x . .
        x . .
         */
        if (this.getPiece(0)!=null&&this.getPiece(0).equals(this.getPiece(3))&&this.getPiece(3).equals(this.getPiece(6))){
            return this.getPiece(0).isCross() ? 1 : 2;
        }

        /*
        . x .
        . x .
        . x .
         */
        if (this.getPiece(1)!=null&&this.getPiece(1).equals(this.getPiece(4))&&this.getPiece(4).equals(this.getPiece(7))){
            return this.getPiece(1).isCross() ? 1 : 2;
        }

        /*
        . . x
        . . x
        . . x
         */
        if (this.getPiece(2)!=null&&this.getPiece(2).equals(this.getPiece(5))&&this.getPiece(5).equals(this.getPiece(8))){
            return this.getPiece(2).isCross() ? 1 : 2;
        }

        /*
        x . .
        . x .
        . . x
         */
        if (this.getPiece(0)!=null&&this.getPiece(0).equals(this.getPiece(4))&&this.getPiece(4).equals(this.getPiece(8))){
            return this.getPiece(0).isCross() ? 1 : 2;
        }

        /*
        . . x
        . x .
        x . .
         */
        if (this.getPiece(2)!=null&&this.getPiece(2).equals(this.getPiece(4))&&this.getPiece(4).equals(this.getPiece(6))){
            return this.getPiece(2).isCross() ? 1 : 2;
        }

        return 0;
    }

    public boolean isFull(){
        return !this.grid.contains(null);
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
