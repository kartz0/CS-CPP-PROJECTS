/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs245.swingProject.retroClick;

import java.io.Serializable;

/**
 *
 * @author blou
 * purpose: to save a user's data which include their
 * initial and score
 */
public class User implements Serializable {
    
    private String name;
    private int score;
    
    public User() {
        name = "";
        score = 0;
    }
    
    public User(String name, int score) {
        this.name = name;
        this.score = score;
    }
    
    // returns the name of the user
    public String getName() { return name; }
    
    // returns the user's score
    public int getScore() { return score; }
    
    // will set the user's score if it needs to change
    public void setScore(int n) { score = n; }
}
