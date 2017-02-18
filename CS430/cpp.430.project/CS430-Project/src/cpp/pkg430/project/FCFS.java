
package cpp.pkg430.project;

import java.util.LinkedList;

/**
 *
 * @author kartiksoni
 */
public class FCFS {
    
    int fCFSTotal = 0;
    double apt  = 0;
    double att  = 0;
    double awt  = 0;
    private LinkedList<dataObject>  input    = new LinkedList();
    private LinkedList<Double>      attList  = new LinkedList();
    private LinkedList<Double>      aptList  = new LinkedList();
    public FCFS(LinkedList att){
        input = (LinkedList<dataObject>) att.clone();
    }
    public void calculateTotal(){
      
       for(int i = 0 ; i< input.size(); i++){ 
           
           apt +=  input.get(i).getValue();
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
    public void print(){
        System.out.println("FCFS:");
        System.out.print("_______________________________________________________________");
        System.out.println();
        System.out.println("Job\t|\tStart\t|\tEnd  \t  |\tOutput \t     |" );
        int intial = 0;
        int end = 0;
        for(int i =0; i < input.size();i++){ 
            end += input.get(i).getValue();
            System.out.println(input.get(i).getJob()+"\t|\t "+intial+"\t|\t"+end+"\t  | \t  "+end+"\t     |");
            intial += input.get(i).getValue();
        }
    
     
        System.out.println();
        System.out.println("Avg APT:\t"+apt+""
                        + "\nAvg AWT:\t"+awt+""
                        + "\nAvg ATT:\t"+att);
        System.out.print("_______________________________________________________________\n\n");
    }
}
