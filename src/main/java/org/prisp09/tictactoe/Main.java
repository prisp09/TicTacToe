package org.prisp09.tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        boolean play = true;

        while(play){
            System.out.println("Enter the name of the first player: ");
            String player1 = input.nextLine();

            System.out.println("Enter the name of the second player: ");
            String player2 = input.nextLine();

            System.out.println("--------------------------------------\nThe game will now begin!");

            Game game = new Game(player1, true, player2);
            System.out.println(game.run(input));

            input.nextLine();
            System.out.println("\nDo you want to continue playing? (y/n)");
            String response = input.nextLine();

            while(!(response.equals("y")||response.equals("n"))){
                System.out.println("You can only use 'y' for yes and 'n' for no to respond.");
                System.out.println("Do you want to continue playing? (y/n)");
                response = input.nextLine();
            }

            System.out.println("--------------------------------------");
            play = response.equals("y");

        }

        System.out.println("Thank you for playing!\n:)");

        input.close();
    }
}
