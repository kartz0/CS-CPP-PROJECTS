/*
 * Kartik Soni
 * CS445-Computer Graphics
 * Thursday Oct 27
 */

package cpp.cs445.project2;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.input.Keyboard;
import java.util.*;
        
/**
 * This project works but is not compleat it gets the data but is not able to finish it because of the time constraint 
 * i got it to start scaning from 0 and printing it but was not able to finish it. It gets all the tables ready when you plug in the 
 * values i tested it with different values to check if it was converting the values correctly or not. 
 * @author kartiksoni
 */
public class CppCs480Project2 {

    List<float[]> allVertices= new ArrayList<float[]>();
    
    public static void main(String[] args) {
        CppCs480Project2 display = new CppCs480Project2();
        display.start();
    }

    public CppCs480Project2() {
    
    }
    public void start(){
        try{
            createWindow();
            intGL();
           // readFile();
            render();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private void createWindow() throws Exception{
        Display.setFullscreen(false);
        Display.setDisplayMode(new DisplayMode(640,480));
        Display.setTitle("CS-445_Project-1");
        Display.create();
    }
    private void intGL(){
        glClearColor(0.0f,0.0f,0.0f,0.0f);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        
        glOrtho(-320,320,-240,240,1,-1);
        
        glMatrixMode(GL_MODELVIEW);
        glHint(GL_PERSPECTIVE_CORRECTION_HINT,GL_NICEST);
    
    }
    private void render(){  
      
          DoVerticesShit();
          Fill j = new Fill();
          j.Fill(allVertices);
        while(!Display.isCloseRequested()){
           
            
            /*
            Makes it so if the esc key is pressed the loop breaks and the program ends
            */        
            if(!Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
                  try{   
                
                    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
                
                    glLoadIdentity(); 
                    glColor3f(1.0f,3.0f,0.0f);
                    glPointSize(2);
                    glLineWidth(1);
                    j.draw();
            
                     
                     
                    Display.update();
                    Display.sync(60);
                    

                }
                  catch(Exception e){
                
            }
        }
           
        else{
            break;
        }
    } 
    Display.destroy(); 
  }
  private void DoVerticesShit(){
            float[] p1 = new float[2];
            p1[0] =100; p1[1] = 100;allVertices.add(p1);
            float[] p2 = new float[2];
            p2[0] =100; p2[1] = 160;allVertices.add(p2);
            float[] p3 = new float[2];
            p3[0] =160; p3[1] = 200;allVertices.add(p3);
            float[] p4 = new float[2];
            p4[0] =280; p4[1] = 100;allVertices.add(p4);
            float[] p5 = new float[2];
            p5[0] =280; p5[1] = 160;allVertices.add(p5);
            float[] p6 = new float[2];
            p6[0] =220; p6[1] = 100;allVertices.add(p6);
  }
}
