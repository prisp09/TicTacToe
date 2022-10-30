package org.prisp09.tictactoe;

public abstract class Player {

    private Piece piece;
    private String name;

    public Player(Piece piece, String name){
        this.setPiece(piece);
        this.name = name;
    }
    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Boolean isFirst(){
        return this.piece.isCross();
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
