package org.prisp09.tictactoe;

public class Main {
    public static void main(String[] args) {
        Game game = new Game("Pri", true, "Shefa");
        System.out.println(game.run());
    }
}
