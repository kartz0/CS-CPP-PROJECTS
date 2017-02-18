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
public class sjf {
    double apt  = 0;
    double att  = 0;
    double awt  = 0;
    private LinkedList<Double> attList  = new LinkedList();
    private LinkedList<Double> aptList  = new LinkedList();
    private LinkedList<dataObject> mainList = new LinkedList();
    public sjf(LinkedList input){
        mainList.addAll(input);
        sort();
        calculateTotal();
    }
    public void sort(){
        LinkedList<dataObject> temp = new LinkedList();
        
        
        while(!mainList.isEmpty()){
          dataObject smallest = mainList.get(0);
         
           for(int i = mainList.size()-1; i >= 0;i--){
           
                if(smallest.getValue() > mainList.get(i).getValue()){
                   
                   smallest = mainList.get(i);

                }  
    
             }
              temp.addLast(smallest);
              mainList.remove(mainList.indexOf(smallest));
        }
        mainList= temp;

    }
     
    public void print(){
        System.out.println("SJF:");
        System.out.print("_______________________________________________________________");
        System.out.println();
        System.out.println("Job\t|\tStart\t|\tEnd  \t  |\tOutput \t     |" );
        int intial = 0;
        int end = 0;
        for(int i =0; i < mainList.size();i++){ 
            end += mainList.get(i).getValue();
            System.out.println(mainList.get(i).getJob()+"\t|\t "+intial+"\t|\t"+end+"\t  | \t  "+end+"\t     |");
            intial += mainList.get(i).getValue();
        }
    
        System.out.println();
        System.out.println("Avg APT:\t"+apt+""
                        + "\nAvg AWT:\t"+awt+""
                        + "\nAvg ATT:\t"+att);
     
        System.out.print("_______________________________________________________________\n\n");
       
        
    }
   
    
    public void calculateTotal(){
        for(int i = 0 ; i< mainList.size(); i++){ 
           apt +=  mainList.get(i).getValue();
           aptList.add(apt);
           attList.add(apt);
           
       }
       for(int i = 0 ; i< attList.size(); i++){ 
           
           att +=  attList.get(i);
           
       }
       awt = (att- apt)/aptList.size();
       apt = apt/aptList.size();
       att = att/attList.size();
       print();
       
    }
}
