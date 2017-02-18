/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs245.swingProject.retroClick;

/**
 *
 * @author kean
 */
public class SudokuGame {
    
    //9x9 grid for sudoku board--given
    protected String[][] board = { 
                       {"8","","","4","","6","","","7"},
                       {"","","","","","","4","",""},
                       {"","1","","","","","6","5",""},
                       {"5","","9","","3","","7","8",""},
                       {"","","","","7","","","",""},
                       {"","4","8","","2","","1","","3"},
                       {"","5","2","","","","","9",""},
                       {"","","1","","","","","",""},
                       {"3","","","9","","2","","","5"} };
    
    //solution for the board
    protected String[][] solution = { 
                       {"8","3","5","4","1","6","9","2","7"},
                       {"2","9","6","8","5","7","4","3","1"},
                       {"4","1","7","2","9","3","6","5","8"},
                       {"5","6","9","1","3","4","7","8","2"},
                       {"1","2","3","6","7","8","5","4","9"},
                       {"7","4","8","5","2","9","1","6","3"},
                       {"6","5","2","7","8","1","3","9","4"},
                       {"9","8","1","3","4","5","2","7","6"},
                       {"3","7","4","9","6","2","8","1","5"} };
    
   
    
    protected int score;
    protected boolean[][] deductionChecker = new boolean[9][9];


    //Starts the game here
    public SudokuGame() {
        setFalse(deductionChecker);
        score = 540;
    }
    
    public int getScore() {
        return score;
    }
    

    
    public boolean checkSolution(String[][] check) {
        
        boolean x = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) { 
                
                if (!(check[i][j].equals(solution[i][j])) && deductionChecker[i][j] == false) {
                        score -= 10;
                        deductionChecker[i][j] = true;
                        x = false;
                }
            }
        }
        
        return x;
    }

    
    private void setFalse(boolean[][] deductionChecker) {
        for (int i = 0; i < 9; i++) 
            for (int j = 0; j < 9; j++) 
                deductionChecker[i][j] = false;
    }
    
    
    
    
 }
    