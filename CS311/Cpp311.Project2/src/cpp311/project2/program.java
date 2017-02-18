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
        private String  [] symbol         = new String[10000000];
        private int     [] next           = new int[10000000];
        private int     emptyPosition     = 0;
        
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
                int ascii = (int)str[0];
                if(checkLang(ascii)){
                int position = Switch[convert(ascii)];// asccii value of according to the array A = str[0] then gets the position of the next array;
                           // gets the position of the object in the switch array;
                
                Switch[convert(ascii)]= getPosition(position);
            
                addSymbol(Switch[convert(ascii)],str);
                           
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
         System.out.println();
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
           input = emptyPosition;   
       }
     
        return input;
    }
    public void addSymbol(int position, char [] sym){// adds the symbol
     // System.out.println(position);
        System.arraycopy(sym,1,sym,0,sym.length-1);
        sym[sym.length-1] = '*';
       // System.out.println(nextPosition);
        /*(symbol[position]!= null){ 
            while(symbol[position] != null){// traverse thru the array till u get the next position
                position += 1;
            }
            next[nextPosition] = position;
            nextPosition = position;
            
        }*/
        while (symbol[position] != null){
            if(next[position] == 0){
                next[position] = emptyPosition;
            }
            else{
                int nextPosition = next[position];
                position = nextPosition;
            }
            
        }
        if(symbol[position] == null){
            int count = position;
            for(int i= 0; i<sym.length;i++){
            if(i != 0){
                count += 1;
                symbol[count]= String.valueOf(sym[i]);
            }
            else{
            symbol[count]= String.valueOf(sym[i]);
                
                }
            }
            emptyPosition = count+1;
        }       
    }
    private int convert(int ascii) {
//        System.out.println("ascii before:"+ascii);
//        System.out.println("A:"+(int)'a');
        if(ascii == (int)'_'){
            return 52;
        }
        else if (ascii == (int)'_'){
            return 53;
        }
        else if(ascii >= (int)'A' && ascii <= (int)'Z'){
            return ascii - 65;
        }
        else if(ascii >= (int)'a' && ascii <= (int)'z'){
            return ascii - 71;
        }
     return 0;
    }
}
