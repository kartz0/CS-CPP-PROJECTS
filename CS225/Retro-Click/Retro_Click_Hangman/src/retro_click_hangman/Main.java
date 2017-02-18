/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retro_click_hangman;

/**
 *
 * @author kartiksoni
 */
public class Main {
    public static void main(String args[]) {
    Intro intr = new Intro();
    Mainintro intro = new Mainintro();
    intro.setVisible(true);
    long time   = System.currentTimeMillis();
    long time2  = System.currentTimeMillis();
    while(time2< time + 3000){
        time2= System.currentTimeMillis();
    }
    intro.setVisible(false);
    intr.setVisible(true);
}
}
