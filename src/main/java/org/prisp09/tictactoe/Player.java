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

    public String getName(int i){
        return this.name.equals("") ? ("Player " + i) : this.name;
    }

    public String toString(int i) {
        return this.getPiece().isCross() ? (getName(i) + " with X"):(getName(i) + " with O");
    }
}
