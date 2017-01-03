import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.Random;

public class Hangman
{
    String mysteryWord;
    //stringbuilder can change the string as is!(able to be mutated)
    StringBuilder currentGuess;
    ArrayList<Character> previousGuesses = new ArrayList<>();

    int maxTries = 6;
    int currentTry = 0;

    ArrayList<String> dictionary = new ArrayList<>();
    //filreader is used to get strings from the file to be used as possible words
    private static FileReader fileReader;
    //allows us to itterate through the file and take things in and out of it, similar to string builder idea.
    private static BufferedReader bufferedFileReader;

    public Hangman() throws IOException
    {
        initializeStreams();
        mysteryWord = pickWord();
        currentGuess = initializeCurrentGuess();
    }

    //what if dictionary isnt there in the file? hence the throw IOException and the try catch!
    public void initializeStreams() throws IOException {
        try {
            File inFile = new File("dictionary.txt");
            //read file
            fileReader = new FileReader(inFile);
            //manipulate
            bufferedFileReader = new BufferedReader(fileReader);
            String currentLine = bufferedFileReader.readLine();
            while (currentLine != null)
            {
                dictionary.add(currentLine);
                //allow us to go to the next line
                currentLine = bufferedFileReader.readLine();
            }
            bufferedFileReader.close();
            fileReader.close();
        }
        catch(IOException e)
        {
            System.out.println("Could not init streams");
        }
    }

    public String pickWord()
    {
        Random rand = new Random();
        int wordIndex = Math.abs(rand.nextInt()) % dictionary.size();
        return dictionary.get(wordIndex);
    }

    public StringBuilder initializeCurrentGuess() {
        StringBuilder current = new StringBuilder();
        for (int i = 0; i < mysteryWord.length() * 2; i++) {
            if (i % 2 == 0) {
                current.append("_");    //dash for where we dont know the letter
            } else {
                current.append(" ");    //space in between letters
            }
        }
        return current;
    }

    public String getFormalCurrentGuess()
    {
        return "Current Guess: " + currentGuess.toString();
    }

    public boolean gameOver()
    {
        if (didWeWin())
        {
            System.out.println();
            System.out.println("You won! You guessed the right word!");
            return true;
        }
        else if (didWeLose())
        {
            System.out.println();
            System.out.println("Sorry, you lost. You spent all of your 6 tries\n"+
                    "The word was " + mysteryWord + ".");
            return true;
        }
        return false;
    }

    public boolean didWeLose()
    {
        return currentTry >= maxTries;
    }

    public boolean didWeWin()
    {
        String guess = getCondensedCurrentGuess();
        return guess.equals(mysteryWord);
    }

    public String getCondensedCurrentGuess()
    {
        String guess = currentGuess.toString();
        return guess.replace(" ", "");
    }


    public boolean isGuessedAlready(char guess)
    {
        return previousGuesses.contains(guess);
    }

    public boolean playGuess(char guess)
    {
        boolean isItAGoodGuess = false;
        previousGuesses.add(guess);
        for (int i = 0; i < mysteryWord.length(); i++)
        {
            if (mysteryWord.charAt(i) == guess)
            {
                currentGuess.setCharAt(i * 2, guess);
                isItAGoodGuess = true;
            }
        }

        if (!isItAGoodGuess) {
            currentTry++;
        }

        return isItAGoodGuess;
    }

    public String drawPicture() {
        switch(currentTry) {
            case 0: return noPersonDraw();
            case 1: return addHeadDraw();
            case 2: return addBodyDraw();
            case 3: return addOneArmDraw();
            case 4: return addSecondArmDraw();
            case 5: return addFirstLegDraw();
            default: return fullPersonDraw();
        }

    }

    private String noPersonDraw() {
        return " - - - - -\n"+
                "|        |\n"+
                "|        \n" +
                "|       \n"+
                "|        \n" +
                "|       \n" +
                "|\n" +
                "|\n";
    }

    private String addHeadDraw() {
        return " - - - - -\n"+
                "|        |\n"+
                "|        O\n" +
                "|       \n"+
                "|        \n" +
                "|       \n" +
                "|\n" +
                "|\n";
    }

    private String addBodyDraw() {
        return " - - - - -\n"+
                "|        |\n"+
                "|        O\n" +
                "|        | \n"+
                "|        |\n" +
                "|        \n" +
                "|\n" +
                "|\n";
    }

    private String addOneArmDraw() {
        return   " - - - - -\n"+
                "|        |\n"+
                "|        O\n" +
                "|      / |  \n"+
                "|        |\n" +
                "|        \n" +
                "|\n" +
                "|\n";
    }

    private String addSecondArmDraw() {
        return  " - - - - -\n"+
                "|        |\n"+
                "|        O\n" +
                "|      / | \\ \n"+
                "|        |\n" +
                "|        \n" +
                "|\n" +
                "|\n";
    }

    private String addFirstLegDraw() {
        return   " - - - - -\n"+
                "|        |\n"+
                "|        O\n" +
                "|      / | \\ \n"+
                "|        |\n" +
                "|       / \n" +
                "|\n" +
                "|\n";
    }

    private String fullPersonDraw() {
        return   " - - - - -\n"+
                "|        |\n"+
                "|        O\n" +
                "|      / | \\ \n"+
                "|        |\n" +
                "|       / \\ \n" +
                "|\n" +
                "|\n";
    }


}
