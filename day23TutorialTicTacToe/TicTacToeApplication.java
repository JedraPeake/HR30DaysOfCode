import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import;

import java.util.Scanner;

public class TicTacToeApplication {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        boolean doYouWantToPlay=true;
        while (doYouWantToPlay)
        {
            //setting up tokens/AI
            System.out.println("Welcome to TicTacToe, are you ready?? I hope so\n"+"First you need to pick a character");
            System.out.println();
            System.out.println("Enter a single character that will represent you on the board");
            char playerToken = sc.next().charAt(0);
            System.out.println("Enter a single character that will represent your opponent on the board");
            char opponentToken = sc.next().charAt(0);
            TicTacToe game= new TicTacToe(playerToken, opponentToken);
            AI ai = new AI();

            //set up game
            System.out.println();
            System.out.println("Now to start, to play enter a number, and your token will be placed in the spot\n"+
                                "The numbers go 1-9, left to right, we shall soon see who wins the game!");
            game.printIndexBoard();

            //lets play
            while (game.gameOver().equals("notOver"))
            {
                //user turn
                if (game.currentMarker==game.userMarker)
                {
                    System.out.println("It's your turn, enter a spot please");
                    int spot = sc.nextInt();
                    while (!game.playTurn(spot))
                    {
                        System.out.println("Try Again "+spot+ "is an invalid spot, as it is taken");
                        spot = sc.nextInt();
                    }
                    System.out.println("You picked "+spot);
                }
                else
                {
                    System.out.println("It's my turn");
                    int spot = ai.pickSpot(game);
                    game.playTurn(spot);
                    System.out.println("I picked "+spot);
                }
                //print board
                System.out.println();
                game.printBoard();
            }
            System.out.println(game.gameOver());
            System.out.println();

            System.out.println("Would you like to play again? If yes enter Y");
            char again=sc.next().toUpperCase.charAt(0);
            doYouWantToPlay = (again =='Y');

            System.out.println();
            System.out.println();

        }


    }
}
