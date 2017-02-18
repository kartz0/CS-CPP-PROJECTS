/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpp.pkg430.project;


/**
 *
 * @author kartiksoni
 */
public class dataObject {
    private String job;
    private double value;
    
    public dataObject(String jb,int vl){
        job     = jb;
        value   = vl; 
    }

    dataObject() {
        
    }

   
    public void setJob(String jb){
        job     = jb;
    }
    public void setValue(double vl){
        value = vl;
    }
    public String getJob(){
        return job;
    }
    public double getValue(){
        return value;
    }
   
    public void subtractValue(int x){    
        int overall = (int) (value - x);
        value = overall;
    }

}
