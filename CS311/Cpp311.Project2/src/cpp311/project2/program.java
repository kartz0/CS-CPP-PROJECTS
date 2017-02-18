/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpp311.project2;

import java.io.*;

/**
 *
 * @author kartiksoni
 */
public class program {
        private int     [] Switch         = new int[54];
        private String  [] symbol         = new String[100000];
        private int     [] next           = new int[100000];
        
      public void initalize(){
          for(int i = 0; i < 54; i++){
              Switch[i] = -1; 
          }
          
      }
      public void readFile(){
               try{
        BufferedReader br = new BufferedReader(new FileReader("Proj2_Input1.txt"));
        
        String inputLine = br.readLine();
        

        while(inputLine != null){
            String[] words = inputLine.split(" ");
            for(int i = 0; i< words.length; i++){
                char[] str = words[i].toCharArray();
                int count = 0;
                    while(count < str.length){
                        int ascii = (int)str[count];
                        
                        if(ascii == -1){
                            ascii = 1;
                        }
                        if(checkLang(ascii)){
                            int position = Switch[convert(ascii)];// asccii value of according to the array A = str[0] then gets the position of the next array;
                            // gets the position of the object in the switch array;
                            addSymbol(getPosition(position),str[count]);
                            count++;
                 }
                else{ 
                count++;
                    }
            } 
            }
            
           inputLine = br.readLine();                   
        }
        br.close();
        
     } catch  (FileNotFoundException e){
            System.out.print("Error "+ e);
     } catch (IOException ex) {
            System.out.print("Io error"+ ex);
            }
      }
      
      
      
      
    public void print(){
          System.out.print("Alphabet:\t");
          for(int i = 0; i < 26; i++){
              System.out.print((char)(65 + i)+"\t");
          }
          
          for(int i = 0; i <  26;i++){
              System.out.print((char)(97 + i)+"\t");
          }
          System.out.print("_" + "\t" + "$");
          System.out.println();
     
         System.out.print("Switch  :");
          
        for(int i = 0; i < 54; i++){
              System.out.print("\t"+Switch[i]);
          }
          
         System.out.println();// 36 == $ && 95 == _;
         System.out.print("Position:");
          
         for(int i = 0 ; i<1000;i++){
             System.out.print("\t"+i);
         }
         System.out.println();
       
         System.out.print("Symbol  :");
         
        for(int i = 0; i <1000;i++ ){
             System.out.print("\t"+symbol[i]);
         }
        System.out.println();
        System.out.print("Next    :");
        
        for(int i = 0; i <1000;i++ ){
             System.out.print("\t"+next[i]);
         }
    }

    private boolean checkLang(int ascii) {
        
        if(ascii == (int)'_'|| ascii == (int)'$'||(ascii >= (int)'A' && ascii <= (int)'Z' ) || (ascii >= (int)'a' && ascii <= (int)'z' )){
            return true;
        }
        return false;
    }
    public int getPosition(int input){// gets the next empty position in the symbol array
       if(input == -1){
           input = 0;
           
       }
    
        while(next[input] != 0){
            int newinput = next[input];
            input = newinput;
        }
        Switch[input] = 0;
        return input;
    }
    public void addSymbol(int position, char sym){// adds the symbol 
        symbol[position]= String.valueOf(sym);
    }
    private int convert(int ascii) {
        if(ascii == (int)'_'){
            return 52;
        }
        else if (ascii == (int)'_'){
            return 53;
        }
        else if(ascii >= (int)'A' && ascii <= (int)'Z'){
            return ascii - 65;
        }
        else if(ascii >= (int)'a' && ascii <= (int)'a'){
            return ascii - 71;
        }
        return 0;
    }
}
