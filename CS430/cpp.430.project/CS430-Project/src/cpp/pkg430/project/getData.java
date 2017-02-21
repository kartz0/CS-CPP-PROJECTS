    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpp.pkg430.project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author kartiksoni
 */
public class getData {
   
    private LinkedList<dataObject>  value= new LinkedList();
    private LinkedList<dataObject>  value2= new LinkedList();
    public void getFile() throws IOException{
     try{
        BufferedReader br = new BufferedReader(new FileReader("testdata1.txt"));
        
        String inputLine = br.readLine();
        int i = 0;
        
        while(inputLine != null){

                dataObject temp = new dataObject();
                temp.setJob(inputLine);
                inputLine = br.readLine();   
                temp.setValue(Double.parseDouble(inputLine));
                inputLine = br.readLine();
                value.add(temp);
                value2.add(temp);
        }
        br.close();
        
     } catch  (FileNotFoundException e){
            System.out.print("Error "+ e);
     }
              
              
     
    }

    public void perForm() throws IOException {
        FCFS fc =new FCFS(value);
              fc.calculateTotal();
              sjf sjf =new sjf(value);
              System.out.println(value.get(0).getValue());
              roundRobin rr2 = new roundRobin(value,2);
              value.clear();
              getFile();
              roundRobin rr5 = new roundRobin(value,5); //To change body of generated methods, choose Tools | Templates.
    }


}
