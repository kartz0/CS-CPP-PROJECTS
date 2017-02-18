/***************************************************************
* file: SplashScreen.java
* author: Kartik Soni, Brian Sandawal, Kean Jafari, Cristian Lopez, Shane Avila
* class: CS 245
*
* assignment: SwingProject 1
* date last modified: 1/18/2017
*
* purpose: This method intialize is the main method of the project.
* It creates the intro window and closes it after three second.Then 
* opens up the game window, which contains our game
****************************************************************/ 
package cs245.swingProject.retroClick;

public class Main {
    public static void main(String args[]) {
    GameWindow intr = new GameWindow();   // Intialize GameWindow
    SplashScreen intro = new SplashScreen();//Intialize SplashScreen
    intro.setVisible(true);// sets the splash screen to be visible to us
    long time   = System.currentTimeMillis();
    long time2  = System.currentTimeMillis();
    while(time2< time + 3000){ // counter for 3 secs
        time2= System.currentTimeMillis();
    }
    intro.setVisible(false);// disables the splash screen window
    intr.setVisible(true);// Sets Visible of the game window true and displays it
}
}
