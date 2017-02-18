/*
 * To run this program u need to have spaces in between the all the values
 * so for example (101) should be written as ( 1 0 1 )
 */
package cpp.cs311.project1;
import java.io.*;
import java.util.*;

/**
 *
 * @author kartiksoni
 */
public class GetFileData {
    
       private String numberOfStates;
       private boolean accepted = false;
       private String[] finalStates;
       private String[] alphabet;
       private int nextVal;
       private final LinkedList<String>  initial = new LinkedList();
       private final LinkedList<String>  val = new LinkedList();
       private final LinkedList<String>  next = new LinkedList();
       public void getFileData() { // gets the file data and prints it and does 
           //all the computation
        try{
            
            
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            String input = "";
         
            while((input= br.readLine()) != null){
    
            initial.clear();
            val.clear();
            next.clear();
            numberOfStates = input;
            input = br.readLine();
            finalStates =input.split(" ");
            System.out.println("Number of States: " + numberOfStates);
            System.out.print("Number of Final States: ");
            printFinalStates();
            System.out.println();
            input = br.readLine();
            alphabet = input.split(" ");
            System.out.print("Alphabet: ");
            for (String alphabet1 : alphabet) {
                System.out.print(alphabet1 + " ");
            }
            System.out.println();
            System.out.println("Transitions:");                     
            String position = "";
            position = br.readLine();
            while(position.startsWith("(")){
                String[] data = position.split(" ");
                initial.add(data[1]);
                val.add(data[2]);
                next.add(data[3]);
                position = br.readLine();
            }
            printTransition();
            System.out.println("Strings:");

            while(!position.equals("")){
                String[] data = position.split(" ");
                System.out.print("    ");
              
                if(checkIntialState(data[0])){
                    for(int i = 1; i < data.length; i++){
                        checkState(data[i]);
                        if(!accepted){
                            break;
                        }
                    }
                }
                for(int i = 0; i < data.length; i++){
                    System.out.print(data[i]);
                }
          
                if(accepted && checkFinalState()){
                    
                    System.out.print("      ACCEPT");
                }
                
                else if(!accepted || !checkFinalState()){
                System.out.print("     REJECT");
                }
               System.out.println();
               position =br.readLine();
               accepted = false; // reset the variable 
              if(position == null){
                  break;
              }
            }
            
            }
       
        }
        catch  (FileNotFoundException e){
            System.out.print("Error "+ e);
        } catch (IOException ex) {
            System.out.print(ex);
        } 
    }
    private void printTransition(){// this class print out the transition data
        for(int i = 0; i < initial.size(); i++){
           System.out.println("    " + initial.get(i) + " " + val.get(i) + " " + next.get(i) );
        }
    }
    private boolean checkIntialState(String string) {// this method takes in the
        //character string or the first input 
            boolean state = false;
            int length = initial.size();
            LinkedList<Integer> index = new LinkedList();
            for(int i = 0; i < length; i++){
                if("0".equals(initial.get(i))){
                    index.add(i); // add to the list the position of the inital 
                    //state
                }
                
            }
            for(int j = 0; j< index.size();j++){
                    
                if(val.get(index.get(j)).equals(string)){
                    nextVal = index.get(j);
                    accepted = true;
                    state = true; 
                 }
                else{
                    state = false;
                }
            }
            return state;
    }
    private boolean checkState(String string) { // check the state of if its the 
        //lang
            boolean state = true;
            int length = initial.size();
            LinkedList<Integer> index = new LinkedList();
            
            for(int i = 0; i < length; i++){
                if(next.get(nextVal).equals(initial.get(i))){
                    index.add(i);
                }
            }
            for(int j = 0; j< index.size();j++){
        
                if(val.get(index.get(j)).equals(string)){
                    nextVal = index.get(j);
                    accepted = true;
                    state = true; 
                 }
                else{   
                
                    state = false; // make it a boolean value and set it true 
                    //for when u get the value and false for this case
                
                }
            }
           
            return state;
    }
    private boolean checkFinalState(){// check if the we are at the final state
        for(int i= 0; i < finalStates.length; i++){
            if (finalStates[i].equals(next.get(nextVal))){
                return true;
            }
        }
        return false;
    }
    private void printFinalStates(){// prints the final states
        for(int i= 0; i < finalStates.length; i++){
            System.out.print(finalStates[i]);
        }
    }
     private boolean checkLanguage(String string) {// checks if the string is 
         //in the language
       boolean test= true;
        for(int i = 0; i < alphabet.length;i++ ){
            if(alphabet[i] == string ){
                test = true;
            }
            else 
                test = false;
            }
        return test;
    }
    // do the same thing as before but instead of intial use the next input
}