/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpp.pkg430.project;

import java.util.LinkedList;

/**
 *
 * @author kartiksoni
 */
public class roundRobin {
    int fCFSTotal = 0;
    double apt  = 0;
    double att  = 0;
    double awt  = 0;
    private LinkedList<dataObject>  mainList    = new LinkedList();
    private LinkedList<dataObject>  attList     = new LinkedList();
    private LinkedList<Double>      totalAtt    =  new LinkedList();
    private LinkedList<Integer>      start       =  new LinkedList();
    private LinkedList<Integer>      location       =  new LinkedList();
    private LinkedList<dataObject>  outputList  = new LinkedList();
    private LinkedList<Integer>     defaultValues       =  new LinkedList();
    
    
    private final int rr;
    
    public roundRobin(LinkedList input, int val){
        mainList.addAll(input);
        rr = val;
        
        calculateTotal();
        print();

    }
    public void calculateTotal(){
        int size = mainList.size() ;
        int counter = 0;
       for(int i = 0 ; i< mainList.size(); i++){ 
           apt +=  mainList.get(i).getValue(); 
           }
        double count = 0;
      // System.out.print(input.get(2).getValue());
       while(!mainList.isEmpty()){   
        for(int i = 0 ; i< mainList.size(); i++){ 
           
           outputList.add(mainList.get(i));
           
           if( mainList.get(i).getValue() < rr && mainList.get(i).getValue() >= 0){
               count += (int) mainList.get(i).getValue();
               
               mainList.get(i).subtractValue((int)mainList.get(i).getValue());
           }
           else {
            count += rr;
           
            mainList.get(i).subtractValue(rr);          
           }
           
           start.add((int)count);
           if((int)mainList.get(i).getValue() == 0){
               attList.add(mainList.get(i));
               mainList.remove(i);
               totalAtt.add(count);
               location.add(counter);   
               i -=1;
           }  
           counter++;
        }
       }
     
       for(int i = 0; i < totalAtt.size(); i++){
          att += totalAtt.get(i);
          
       }
       awt = (att- apt)/size;
       apt = apt/size;
       att = att/size;
       
    }
    public void print(){
        System.out.println("RR"+rr+":");
        System.out.print("_______________________________________________________________");
        System.out.println();
        System.out.println("Job\t|\tStart\t|\tEnd  \t  |\tOutput \t     |" );
        int intial = 0;
        int end = 0;
        for(int i =0; i < start.size();i++){ 
            end = start.get(i);
            if(i == location.getFirst()){
            System.out.println(outputList.get(i).getJob()+"\t|\t "+intial+"\t|\t"+end+"\t  | \t  "+end+"\t     |");
            location.pop();
            intial = start.get(i);}
            else{
            System.out.println(outputList.get(i).getJob()+"\t|\t "+intial+"\t|\t"+end+"\t  | \t  "+" "+"\t     |");
            intial = start.get(i);  
                    } 
        }
       
        
        System.out.println();
        System.out.println("Avg APT:\t"+apt+""
                        + "\nAvg AWT:\t"+awt+""
                        + "\nAvg ATT:\t"+att);
     
        System.out.print("_______________________________________________________________\n\n");
       
        
    }

}
