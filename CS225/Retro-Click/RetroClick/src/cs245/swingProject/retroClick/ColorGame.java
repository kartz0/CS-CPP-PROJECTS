/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs245.swingProject.retroClick;
import java.util.*;
/**
 * @author kartiksoni
 */
public class ColorGame {
    // the number of guesses user has entered
    private int numberOfTries;
    
    // total number of possible tries
    private int totalTries;
    // different words
    private final String[] possibleWords = {"GREEN", "YELLOW", "RED", "BLUE", "PURPLE"};
    
    // random word chosen random, if worded complete game is won
    private String randomWord;
    
    private String winningColor;
    // starting number of points
    // ten points should be taken away for every incorrect letter
    private int score;
    
    // The user's end score
    private int highScore;
    
    // the length of the displayed word
    private int length;
    
    // player win or lose
    private boolean win;
    
    // boolean to determine game status
    private boolean gameOver;
   
    
    public ColorGame() {
        reset();
    }
     // method: reset   
     // purpse: Sets the initial values for the game
    public void reset() {
        numberOfTries = 0;
        totalTries = 5;
        randomWord = randomWord();
        highScore = 0;
        score = 0;
        win = false;
        gameOver = false;
    }
    
    // method: randomWord
    // purpose: Method will randomly choose a word from the specified list
    private String randomWord() {
        Random rand     = new Random();
        int index       = rand.nextInt(5);
        length          = possibleWords[index].length();
        randomWord     = possibleWords[index];
        return possibleWords[index];
    }
    
    public void setWinnnigColor(String clr){
        winningColor = clr;
    }
    
    public boolean checkUserInput(String input) {
        boolean matched = false;
  
            if(input == winningColor) {
                matched = true;
            }
        randomWord();
        return matched;
    }
 
 
    public void updateNumberOfTries(boolean correctWord) {
        //increment the number of tries
        // will be incremented by 1 and the score will be added by 100
        numberOfTries += 1;
        score += (correctWord) ? 100 : 0;
      
    }
    
    // method: checkGameStatus
    // purpose: Will check if the game has been won
    // Still need to implement something to check 
    // if the game is lost
    public void checkGameStatus() {
        if(numberOfTries == totalTries) {
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
    
    public String getWord(){ return randomWord;}
    
   // method: print 
   // purpose: Helper method for testing the game on the command line
   // Prints the word into the command line
   public void print() {
       System.out.println("Score: " + score + " Total Tries: " + totalTries + " # of Tries: " + numberOfTries);
       
           System.out.print("Correct Answer" + winningColor);
  
       System.out.println();
   }
}
