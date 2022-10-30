package org.prisp09.tictactoe;

public class Game {
    private Player player1;
    private Player player2;
    private Board board;
    private GameStatus status;

    //Constructor for only one human player
    public Game(String name, Boolean playerIsCross){
        this.newGame(name, playerIsCross);
    }

    //Constructor for two human players
    public Game(String name1, Boolean player1IsCross, String name2){
        this.newGame(name1, player1IsCross, name2);
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public GameStatus getStatus() {
        return status;
    }

    public Player getPlayer1() {
        return player1;
    }
    public Player getPlayer2(){
        return player2;
    }


    public void newGame(String name, Boolean playerIsCross){
        this.player1 = new HumanPlayer(new Piece(playerIsCross), name);
        this.player2 = new ComputerPlayer(new Piece(!playerIsCross));
        this.board = new Board();
        this.setStatus(GameStatus.NEW);
    }

    public void newGame(String name1, Boolean player1IsCross, String name2){
        this.player1 = new HumanPlayer(new Piece(player1IsCross), name1);
        this.player2 = new HumanPlayer(new Piece(!player1IsCross), name2);
        this.board = new Board();
        this.setStatus(GameStatus.NEW);
    }

    public Boolean makeMove1(int i){
        this.setStatus(GameStatus.ACTIVE);
        return this.board.setPiece(i, this.getPlayer1().getPiece());
    }

    public Boolean makeMove2(int i){
        this.setStatus(GameStatus.ACTIVE);
        return this.board.setPiece(i, this.getPlayer2().getPiece());
    }
    public void checkWin(){
        if(this.board.checkWin()==1){
            this.setStatus(GameStatus.X_WINS);
        } else if (this.board.checkWin()==2) {
            this.setStatus(GameStatus.X_WINS);
        }
        else {
            if(this.board.isFull()){
                this.setStatus(GameStatus.DRAW);
            }
        }
    }

}
