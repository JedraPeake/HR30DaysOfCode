import java.io.IOException;
import java.util.Scanner;

public class HangmanApplication {

    public static void main(String args[]) throws IOException
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to Hangman!\n"+"I will pick a word for you to guess, if you guess wrong more than 6 "+
                            "times I win, however if you guess it in less you win.");
        System.out.println();
        System.out.println("I have picked a word. Below is a picture, and below that is your current guess, which "+
                "starts off as nothing. \n Every time you guess incorrectly. I add a body part to the picture. When there "+
                "is a full person, you lose.");

        boolean doYouWantToPlay = true;
        while (doYouWantToPlay)
        {
            // Setting up the game
            System.out.println();
            System.out.println("Let's play!");
            Hangman game = new Hangman();
            do
            {
                // Draw things for the game
                System.out.println();
                System.out.println(game.drawPicture());
                System.out.println();
                System.out.println(game.getFormalCurrentGuess());
                System.out.print(game.mysteryWord);
                System.out.println();

                // Get the players guess
                System.out.println("Enter a character that you think is in the word");
                char guess = (sc.next().toLowerCase()).charAt(0);
                System.out.println();

                // Check if the character is guessed already
                while (game.isGuessedAlready(guess)) {
                    System.out.println("Try again! You've already guessed that character.");
                    guess = (sc.next().toLowerCase()).charAt(0);
                }

                // Play the guess
                if (game.playGuess(guess)) {
                    System.out.println("Great guess! That character is in the word!");
                } else {
                    System.out.println("Unfortunately that character isn't in the word");
                }

            }
            while (!game.gameOver()); // Keep playing until the game is over

            // Play again
            System.out.println();
            System.out.println("Do you want to play another game? Enter Y if you do.");
            Character response = (sc.next().toUpperCase()).charAt(0);
            doYouWantToPlay = (response == 'Y');

        }
    }
}
