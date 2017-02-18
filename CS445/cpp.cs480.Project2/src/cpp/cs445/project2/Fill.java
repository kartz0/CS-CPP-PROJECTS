/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpp.cs445.project2;

import static org.lwjgl.opengl.GL11.*;

import java.util.*;

/**
 *
 * @author kartiksoni
 */
public class Fill {
    //list of arrays to store the tables
    List<float[]> all_edges= new ArrayList<float[]>();
    List<float[]> active_edge= new ArrayList<float[]>();
    List<float[]> global_edge= new ArrayList<float[]>();
    List<float[]> order= new ArrayList<float[]>();
    boolean parity;
    
    // intialized the values
    public void Fill(List<float[]> orderVertices){
       order = orderVertices;
       parity = true; 
       fillAll_Edge();
        fillGlobal_edge();
    }
    public void draw(){
        scanLine();
    }
    // draws the first line based on the parity
    public void scanLine(){
       
     for(int j =0 ; j< global_edge.size();j++){
       
       createActiveTable(global_edge.get(j)[0]);
       float min = active_edge.get(j)[0];
       float max = active_edge.get(j)[2];

       for (int i = 0; i <= max; i++) {
           
           if(parity && i == active_edge.get(i)[2]){
               flipParity(); 
               System.out.println(i);
           }
           
           if (!parity ) {
               glBegin(GL_POINTS);
               glVertex2f(i,min);
               glEnd();
           } 
       } 
       parity = true;
       }
        
   
     
        
        
    }
    //flips the parity
    public void flipParity(){
        if(parity = true){
            parity = false;
        }
        else{
            parity = true;
        }
    }
    // fills the all edge table
    public void fillAll_Edge(){
        for(int i = 0 ; i <= order.size()-1; ++i){
            float yMax;
            float slope;
            float yMin;
            
            float[] p = new float[4];
            if(i == order.size()- 1){
                slope = 0;
                yMax  = order.get(i)[1];
                yMin = order.get(i)[1];
            }
            else{
                slope = getSlope(order.get(i)[0],order.get(i)[1],order.get(i+1)[0],order.get(i+1)[1]);
                yMax = getMax(order.get(i)[1],order.get(i+1)[1]);
                yMin = getMin(order.get(i)[1],order.get(i+1)[1]);
     
            }
            p[0] = yMin;
            p[1] = yMax;   
            p[2] = order.get(i)[0];
            p[3] = 1/slope;
            all_edges.add(p);
        }
        for(int i = 0; i < all_edges.size()- 1 ; ++i){
            float x;
           if(i == all_edges.size() -1){
               x = all_edges.get(0)[2];
           }
           else{
               if(all_edges.get(i)[0] > all_edges.get(i+1)[0]){
                   x = all_edges.get(i)[2];
               }
               else{
                x = all_edges.get(i+1)[2]; 
                
               }
           }
           
           all_edges.get(i)[2]= x;
        }
       
    }

    
 // if error fix it so thier is a check for the negative value or where it zero and then add it temp(0)[] manually  
    public void fillGlobal_edge(){
        List<float[]> temp= new ArrayList<float[]>();
        temp.add(all_edges.get(0));
        
        for(int i = 1; i <= all_edges.size() -2 ; ++i){
          
            for(int j = 0; j<= temp.get(j)[0];++j){
                if(all_edges.get(i)[0] <= temp.get(j)[0]){
                    if(all_edges.get(i)[0] == temp.get(j)[0] ){
                        if(all_edges.get(i)[1] <= temp.get(j)[1]){
                            temp.add(i-1, all_edges.get(i));
                            break;
                        }
                        else{
                            temp.add(j, all_edges.get(i));
                            break;}
                    }
                   else{
                        temp.add(i-1, all_edges.get(i));
                            break;}
                  
                    }
                else{
                     temp.add(j, all_edges.get(i));
                            break;
                }
             }    
            }
        int count= 0;
        
        for(int k = temp.size()-1; k >=0; --k ){
            global_edge.add(temp.get(k));
        }
        for(int j = 0; j <= global_edge.size() -1 ; ++j){
            System.out.println(j);
         
           System.out.println("y: "+global_edge.get(j)[0]+" yMax: "+global_edge.get(j)[1]+" x: "+global_edge.get(j)[2]+" 1/m: "+global_edge.get(j)[3]);
        }
        
    } 
    //draws the pixel
    public void dPixel(float x, float y){
      // if(parity == false){
        glBegin(GL_POINTS);
        glVertex2f(x,y);
        glEnd();

    }
    // gets the slope
    public float getSlope(float x1,float y1,float x2,float y2){
        float dy = y2 - y1;
        float dx = x2 - x1;
        float m = dy/dx;
        return m;
    }
    // gets the min value
    public float getMin(float y1,float y2){
        if(y1 >= y2){
            return y2;
        }
        else{
            return y1;
        }
    }
    // gets the max value
    public float getMax(float y1, float y2){

        if(y1 >= y2){
            return y1;
        }
        else{
            return y2;
        }
    }
// intiallizes the active edge table everytime a value is enter
    public void createActiveTable(float i){
        int j = 0;
        while(global_edge.get(j)[0] ==  i){
            active_edge.add(global_edge.get(j));
            j++;
        }
    }

}
