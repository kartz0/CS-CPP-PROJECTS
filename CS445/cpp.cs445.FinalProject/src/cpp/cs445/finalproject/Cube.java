/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpp.cs445.finalproject;

/**
 *
 * @author kartiksoni
 */
import org.lwjgl.opengl.*;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import static org.lwjgl.util.glu.GLU.gluPerspective;
import static org.lwjgl.opengl.GL11.*;


public class Cube {
    
    /*
     This method draws the cube and gets the @i from the final class
     */
        
      public void multiplecubes(int i) {
          for(int x = 0; x <= i ;x++){
              for(int y = 0; y <= i; y++){
                  for(int z = 0; z<=i;z++){
                      drawCube(1);
                      glTranslatef(0f, 0f, 2f);
                  }
                  glTranslatef(i, 2f,-i*3);
          } 
         glTranslatef(i, -i*2, -3*i);
        }
   }
     public void drawCube(int i) {
       float size = (float)i;
        glBegin(GL_QUADS);
        // THE TOP
        glColor3f(0.5f, 0.0f, 1.0f); // PURPLE
        glVertex3f(size, size, -size);
        glVertex3f(-size, size, -size);
        glVertex3f(-size, size, size);
        glVertex3f(size, size, size);
        //bottom 
        glColor3f(1.0f, 0.0f, 0.0f); // RED
        glVertex3f(size, -size, size);
        glVertex3f(-size, -size, size);
        glVertex3f(-size, -size, -size);
        glVertex3f(size, -size, -size);
        //front
        glColor3f(0.0f, 1.0f, 0.0f); // GREEN
        glVertex3f(size, size, size);
        glVertex3f(-size, size, size);
        glVertex3f(-size, -size, size);
        glVertex3f(size, -size, size);
        //back
        glColor3f(1.0f, 1.0f, 0.0f); // YELLOW
        glVertex3f(size, -size, -size);
        glVertex3f(-size, -size, -size);
        glVertex3f(-size, size, -size);
        glVertex3f(size, size, -size);
        //Right
        glColor3f(0.0f, 0.3f, 0.2f); // DarkGreen(Grass Green?)
        glVertex3f(-size, size, size);
        glVertex3f(-size, size, -size);
        glVertex3f(-size, -size, -size);
        glVertex3f(-size, -size, size);
        //Left
        glColor3f(0.0f, 1.0f, 1.0f); // CYAN color
        glVertex3f(size, size, -size);
        glVertex3f(size, size, size);
        glVertex3f(size, -size, size);
        glVertex3f(size, -size, -size);

        glEnd();
    }
}
