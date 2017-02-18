
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

import java.util.Scanner;

// class: TestInterface
// purpose: class was used to test the logic of the hang man game
// before the gui was implemented

public class TestInterface {
    
    static Scanner kb = new Scanner(System.in);
    
    public static void main(String[] args) {
       HighScores scores = new HighScores();
       scores.load();
       User[] array = scores.getUserArray(); 
       testHighScores(scores);
      
    }
    
    public static void testHighScores(HighScores scores) {
        //HighScores scores = new HighScores();
        //scores.add("brad", 100);
        scores.add("joezzz", 190);
        //scores.add("brian", 90);
        //scores.add("kean", 300);
        //scores.add("dragon", 10);
        User[] array = scores.getUserArray();
        for(int i = 0; i < array.length; ++i) {
            System.out.println("User: " + array[i].getName() + " Score: " + array[i].getScore());
        }
    }
    
       // method: mainMenu
       // purpose: Prompts the user to play 
       // if anything is entered other than 'Y'
       // the game will end, otherwise the game will play
    public static void mainMenu() {
       
       while(true) {
           System.out.print("Play game(Y/n): ");
           char c = kb.next().charAt(0);
           kb.nextLine();
           if(c == 'Y') {
               play();
           } else {
               break;
           }
       }
    }
    
    // method: play
    // purpose: the logic of how the hang man game should
    // play out step by step
    public static void play() {
        HangMan man = new HangMan();
        man.print();
        while(!man.gameOver()) {
            System.out.print("Enter char: ");
            char c = kb.next().charAt(0);
            kb.nextLine();
            man.updateNumberOfTries(man.checkUserInput(c));
            man.print();
            man.checkGameStatus();
        }
    }
    
}
