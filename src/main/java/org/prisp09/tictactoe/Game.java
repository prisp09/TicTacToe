package org.prisp09.tictactoe;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

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
    public GameStatus checkStatus(){
        if(this.board.checkWin()==1){
            this.setStatus(GameStatus.X_WINS);
        } else if (this.board.checkWin()==2) {
            this.setStatus(GameStatus.O_WINS);
        }
        else {
            if(this.board.isFull()){
                this.setStatus(GameStatus.DRAW);
            }
        }
        return this.getStatus();
    }

    public String run(){
        Scanner input = new Scanner(System.in);
        while(this.getStatus()==GameStatus.NEW||this.getStatus()==GameStatus.ACTIVE){
            System.out.println(this.board);
            System.out.println(this.getPlayer1().toString(1) + " make a move: ");

            int input1 = -1;
            boolean input1IsNotInt = true;
            while(input1IsNotInt) {
                try {
                    input1 = input.nextInt();
                    input1IsNotInt = false;
                } catch (InputMismatchException e) {
                    System.out.println("Please enter an integer: (0-8)");
                    input.next();
                }
            }

            while(input1>8||input1<0){
                System.out.println("Choose a different slot:(0-8)");
                input1IsNotInt = true;
                while(input1IsNotInt) {
                    try {
                        input1 = input.nextInt();
                        input1IsNotInt = false;
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter an integer: (0-8)");
                        input.next();
                    }
                }
            }
            boolean move1 = this.makeMove1(input1);
            while(!move1 || (input1>8||input1<0)){
                System.out.println("Choose a different slot: (0-8)");
                input1IsNotInt = true;
                while(input1IsNotInt) {
                    try {
                        input1 = input.nextInt();
                        input1IsNotInt = false;
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter an integer: (0-8)");
                        input.next();
                    }
                }
                move1 = this.makeMove1(input1);
            }
            this.checkStatus();
            if(this.getStatus()==GameStatus.O_WINS || this.getStatus()==GameStatus.X_WINS){
                input.close();
                return this.getPlayer1().toString(1) + " wins the game!";
            }
            if(this.getStatus()==GameStatus.DRAW){
                input.close();
                return "The game resulted in a draw!";
            }


//----------------------------------


            System.out.println(this.board);
            System.out.println(this.getPlayer2().toString(2) + " make a move: ");
            int input2 = -1;
            boolean input2IsNotInt = true;
            while(input2IsNotInt) {
                try {
                    input2 = input.nextInt();
                    input2IsNotInt = false;
                } catch (InputMismatchException e) {
                    System.out.println("Please enter an integer: (0-8)");
                    input.next();
                }
            }

            while(input2>8||input2<0){
                System.out.println("Choose a different slot:(0-8)");
                input2IsNotInt = true;
                while(input2IsNotInt) {
                    try {
                        input2 = input.nextInt();
                        input2IsNotInt = false;
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter an integer: (0-8)");
                        input.next();
                    }
                }
            }
            boolean move2 = this.makeMove2(input2);
            while(!move2 || (input2>8||input2<0)){
                System.out.println("Choose a different slot: (0-8)");
                input2IsNotInt = true;
                while(input2IsNotInt) {
                    try {
                        input2 = input.nextInt();
                        input2IsNotInt = false;
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter an integer: (0-8)");
                        input.next();
                    }
                }
                move2 = this.makeMove2(input2);
            }
            this.checkStatus();
            if(this.getStatus()==GameStatus.O_WINS || this.getStatus()==GameStatus.X_WINS){
                input.close();
                return this.getPlayer2().toString(2) + " wins the game!";
            }
            if(this.getStatus()==GameStatus.DRAW){
                input.close();
                return "The game resulted in a draw!";
            }

        }
        input.close();
        return "";
    }

}
