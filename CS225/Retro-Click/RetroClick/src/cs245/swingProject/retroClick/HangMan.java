
/***************************************************************
* file: GameWindo.java
* author: Brian Sandoval
*         Kartik Soni
*         Kean Jafari
*         Cristian Lopez
*         Shane Avila
* 
* class: CS 245 – Programming Graphical User Intefaces
*
* assignment: program 1
* date last modified: 1/18/2017
*
* purpose: The purpose of this program is to create a graphical representation
* of the game of 'hang man' which keeps track of the user's score and will
* end the game when the user either guesses the correct work or fails after
* 6 tries of guessing the correct letters
*
****************************************************************/

package cs245.swingProject.retroClick;



// Import of necessary libraries 
import java.util.Random;
import java.util.ArrayList;

// class: HangMan
// purpose: the logical representation of a hang man game
// has the logic for how the game works

public class HangMan {
    
    
    // the number of guesses user has entered
    private int numberOfTries;
    
    // total number of possible tries
    private int totalTries;
    
    // number of correct letters user has gotten in word
    private int correctLetters;
    
    // total number of letters in word
    private int totalLetters;
    
    // random word chosen random, if worded complete game is won
    private String winningWord;
    
    // the characters in the winningWord 
    private char[] winningChar;
    
    // using a this array in order to compare to the winningChar
    // in order to determine what letters the user has gotten
    private char[] displayedChar;
    
    // the characters the user has already attempted
    private ArrayList attemptedChars;
    
    // starting number of points
    // ten points should be taken away for every incorrect letter
    private int score;
    
    // The user's end score
    private int highScore;
    
    // the length of the displayed word
    private int length;
    // String Containing Dashes based on the loop
    public String dash= "";
    // player win or lose
    private boolean win;
    
    // boolean to determine game status
    private boolean gameOver;
    
   
    
    public HangMan() {
        reset();
    }
     // method: reset   
     // purpse: Sets the initial values for the game
    public void reset() {
        numberOfTries = 0;
        totalTries = 6;
        winningWord = randomWord();
        winningChar = winningWord.toCharArray();
        displayedChar = new char[winningChar.length];
        totalLetters = winningChar.length;
        correctLetters = 0;
        score = 100;
        highScore = 0;
        win = false;
        getDash();
        attemptedChars = new ArrayList();
        fillDisplayedChar();
        gameOver = false;
    }
    
    // method: randomWord
    // purpose: Method will randomly choose a word from the specified list
    private String randomWord() {
        
        Random rand = new Random();
        String[] possibleWords = {"abstract", "cemetery", "nurse", "pharmacy", "climbing"};
        int index       = rand.nextInt(5);
        length = possibleWords[index].length();
        return possibleWords[index];
    }
    
    // method: checkUserInput
    // purpose: Will go through the winnging char array and if the user's inputed character
    // matches a character in the array, it will add that character to the displayedChar array
    // as well as will increase the number of correct letters the user has
    public boolean checkUserInput(char c) {
        boolean matched = false;
        
        // In gui we can have skip button enter this as input
        // then based on this game will end
        if(c == '*') {
            score = 0;
            gameOver = true;
            return true;
        }
        
        // if the character has been used before
        // it will do nothing to the score and prompt to enter
        // new input
        if(attemptedChars.contains(c)) {
            return true;
        }
        
        for(int i = 0; i < winningChar.length; ++i) {
            if(c == winningChar[i]) {
                // if character entered by user matches a character
                // in the winning array, will place that character
                // in the same position in the displayedChar array
                displayedChar[i] = c;
                ++correctLetters;
                matched = true;
            }
        }
        attemptedChars.add(c);
        return matched;
    }
    public int getScore(){ return highScore;}
    // method: updateNumberOfTries
    // purpose: will update the number of incorrect attempts by
    // a player as well as their score
    
    public void updateNumberOfTries(boolean correctLetter) {
        // If no correct letter was guessed, the number of tries
        // will be incremented by 1 and the score will be deducted 10
        numberOfTries += (correctLetter) ? 0 : 1;
        score -= (correctLetter) ? 0 : 10;
        
    }
    
    // method: fillDisplayedChar
    // purpose: Currently filling the displayedChar array with '*'
    // I am printing this out on the command line to test how the game is
    // working, however this will have to be changed for the gui part
    private void fillDisplayedChar() {
        for(int i = 0; i < displayedChar.length; ++i) {
            displayedChar[i] = '_';
        }
    }
    
    // method: checkGameStatus
    // purpose: Will check if the game has been won
    // Still need to implement something to check 
    // if the game is lost
    public void checkGameStatus() {
        if(totalLetters == correctLetters) {
            gameOver = true;
            highScore = score;
            win = true;
        } else if(numberOfTries == totalTries) {
            gameOver = true;
            highScore = score;
        }
    }
     
    // method: gameOver
    // purpose: returns the status of the game
    public boolean gameOver() { return gameOver; }
    
    // method: highScore
    // purpose: will return the highScore
    public int highScore() { return highScore; }
    
    // method: numberOfTries
    // purpose: will return the number of incorrect tries
    public int numberOfTries() { return numberOfTries; }
    
    // method: score
    // purpose: will return users score
    public int score() { return score; }
    
    // method: didWin
    // purpose: will return whether the user won or lose
    public boolean didWin() { return win; }
    
    // method: getDash
    // purpose: will place spaces between the characters in
    // the displayedChar and then return that string to be printed
    public String getDash() throws NullPointerException{
        dash ="";
         for(int i = 0; i < length; ++i) {
            dash = dash + " " +displayedChar[i];
        }
         
        return dash;
    }
    
   // method: print 
   // purpose: Helper method for testing the game on the command line
   // Prints the characters currently in the displayedChar array
   public void print() {
       System.out.println("Score: " + score + " Total Tries: " + totalTries + " # of Tries: " + numberOfTries);
       for(int i = 0; i < displayedChar.length; ++i) {
           System.out.print(displayedChar[i] + " ");
       }
       System.out.println();
   }
        
}
