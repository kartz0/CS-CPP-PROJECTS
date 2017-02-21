/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpp311.project2;

import java.io.*;
import java.util.LinkedList;

/**
 *
 * @author kartiksoni
 */
public class program {
        private int     [] Switch         = new int[54];
        private String  [] symbol         = new String[1000000];
        private int     [] next           = new int[1000000];
        private int     emptyPosition     = 0;
        private LinkedList<String>      outPutList      = new LinkedList();
        private LinkedList<String>      defaultWords    = new LinkedList();
      public void initalize(){
          for(int i = 0; i < 54; i++){
              Switch[i] = -1; 
          }
          
      }
      public void readFile(){
               try{
               
        BufferedReader br = new BufferedReader(new FileReader("Proj2_Input2.txt"));
        
        String inputLine = br.readLine();
        

        while(inputLine != null){
           
                
            String[] words = inputLine.split("\\W+");
    
            while(words.length == 0){
                inputLine = br.readLine();
                if(inputLine == null){
                     break;
                 }
                else
                words = inputLine.split("\\W+"); 
            }
            if(inputLine == null){
                     break;
                 }
             while("".equals(words[0])){
                 if(inputLine == null){
                     break;
                 }
                 if(words.length == 1){
                inputLine = br.readLine();
                words = inputLine.split("\\W+"); 
                 }
                 else{
                     String temp = "";
                     for(int i = 0; i < words.length; i++){
                         if ("".equals(words[i])){
                             i += 1;
                         }
                    
                             temp += words[i]+" ";
                     }
                     
                     words = temp.split(" ");
                 }
            }
         
      
            for(int i = 0; i< words.length; i++){
              
                
              
                checkBase(words[i]);
                
               
                           
          
               
            }
            System.out.println();
            
           inputLine = br.readLine();                   
        }
        br.close();
        
     } catch  (FileNotFoundException e){
            System.out.print("Error "+ e);
     } catch (IOException ex) {
            System.out.print("Io error"+ ex);
            }
      }
      public void intializeBase(){
               try{
        BufferedReader br = new BufferedReader(new FileReader("Proj2_Input1.txt"));
        
        String inputLine = br.readLine();
        

        while(inputLine != null){
           
                
            String[] words = inputLine.split("\\W+");
    
            while(words.length == 0){
                inputLine = br.readLine();
                if(inputLine == null){
                     break;
                 }
                else
                words = inputLine.split("\\W+"); 
            }
            if(inputLine == null){
                     break;
                 }
             while("".equals(words[0])){
                 if(inputLine == null){
                     break;
                 }
                 if(words.length == 1){
                inputLine = br.readLine();
                words = inputLine.split("\\W+"); 
                 }
                 else{
                     String temp = "";
                     for(int i = 0; i < words.length; i++){
                         if ("".equals(words[i])){
                             i += 1;
                         }
                    
                             temp += words[i]+" ";
                   
                     }
                     
                     words = temp.split(" ");
                   
                     
                 }
            }
         

            for(int i = 0; i< words.length; i++){
                char[] str = words[i].toCharArray();
                defaultWords.add(words[i]);
                //System.out.println(str);
                int ascii = (int)str[0];
                if(checkLang(ascii)){
                int position = Switch[convert(ascii)];// asccii value of according to the array A = str[0] then gets the position of the next array;
                           // gets the position of the object in the switch array;
                
                Switch[convert(ascii)]= getPosition(position);
            
                addBaseSymbol(Switch[convert(ascii)],str);
                           
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
   
     
     boolean case1 = true;
        System.arraycopy(sym,1,sym,0,sym.length-1);
  
       
        
    
        int i = 0;
        if(!contains(position, sym)){
            sym[sym.length-1] = '?';
        while(symbol[position] != null){
            
           if(symbol[position].equals(String.valueOf(sym[i]))){
 
        
            case1 = false;
            i += 1;
            position+=1;
        
         
           }
           else if(!symbol[position].equals(String.valueOf(sym[i]))){
            if(next[position] == 0){
  
                    next[position] = emptyPosition;
                   
                }
            else{
                int nextPosition = next[position];
                position = nextPosition;
               
             }
           }
        }}
   
       if(symbol[position] == null){
            while( i <sym.length){
                    if(i != 0 && case1){
                       
                        position += 1;
                        symbol[position]= String.valueOf(sym[i]);
                       
                        emptyPosition = position+1;
                    }
                    else if ( i != 0 && !case1) {
                        symbol[position]= String.valueOf(sym[i]);
                       
                        position += 1;
                        emptyPosition = position;
                    
                    }
                        
                    else{
                       // System.out.println(sym[i]+ " i value: "+ i);
                        symbol[position]= String.valueOf(sym[i]);  
                        emptyPosition = position+1;
                    }
              
                i++;
               
                    
                
            }
        }


        
    }
     public void addBaseSymbol(int position, char [] sym){// adds the symbol
     
     boolean case1 = true;
        System.arraycopy(sym,1,sym,0,sym.length-1);
        sym[sym.length-1] = ' ';
       
        
    
        int i = 0;
        
            sym[sym.length-1] = '*';
        while(symbol[position] != null){
            
           if(symbol[position].equals(String.valueOf(sym[i]))){
           
        
            case1 = false;
            i += 1;
            position+=1;
        
         
           }
           else if(!symbol[position].equals(String.valueOf(sym[i]))){
            if(next[position] == 0){
  
                    next[position] = emptyPosition;
                   
                }
            else{
                int nextPosition = next[position];
                position = nextPosition;
               
             }
           }
        }
   
       if(symbol[position] == null){
            while( i <sym.length){
                    if(i != 0 && case1){
                 
                        position += 1;
                        symbol[position]= String.valueOf(sym[i]);
                        emptyPosition = position+1;
                    }
                    else if ( i != 0 && !case1) {
                        symbol[position]= String.valueOf(sym[i]);
                       
                        position += 1;
                        emptyPosition = position;
                    
                    }
                        
                    else{
                       
                        symbol[position]= String.valueOf(sym[i]);  
                        emptyPosition = position+1;
                    }
              
                i++;
                    
            }
        }

        
    }
    private int convert(int ascii) {
        if(ascii == (int)'$'){
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
    private boolean contains(int position, char[] sym) {
        boolean state = false;
        int i = 0;
       while(symbol[position] != null){
 
            if(!symbol[position].equals(String.valueOf(sym[i]))){
                 position +=1;
                 i++;
                 return true;
             }
  
                 i++;
                 position+=1;
       }
        return state; 
    }

    private void checkBase(String str) {
   
            if(defaultWords.contains(str)){
                System.out.print(str + "* ");
            }
            else if(outPutList.contains(str)){
                System.out.print(str + "@ ");
            }
            else
                 System.out.print(str + "?  ");
                char[] output = str.toCharArray();
                int ascii = (int)output[0];
                int position = Switch[convert(ascii)];
                Switch[convert(ascii)]= getPosition(position);          
                addSymbol(Switch[convert(ascii)],output);
                 outPutList.add(str);
     
    }
}
