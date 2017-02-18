/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpp.cs445.finalproject;
import org.lwjgl.opengl.*;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.input.Mouse;
import static org.lwjgl.util.glu.GLU.gluPerspective;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.input.Keyboard;
import java.util.*;

/**
 *
 * @author kartiksoni
 */
public class Main {
    public static void main(String[] args) {
        start();
    }
     public static void start() {
        try {
            createWindow();
            initGL();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Camera camera = new Camera(0f, 0f, 0f);
        float movementSpeed = 1f;
        float mouseSensitivity = 0.09f;
        Mouse.setGrabbed(true);

        Cube b = new Cube();

        while (!Display.isCloseRequested() && !Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {

            camera.yaw(Mouse.getDX() * mouseSensitivity);
            camera.pitch(-Mouse.getDY() * mouseSensitivity);
            movement(camera, movementSpeed);
            
            glLoadIdentity();
            camera.cameraView();
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            glScaled(2, 2, 2);
            glTranslatef(0f, 0f, -50f);
            b.multiplecubes(1);

            Display.update();
            Display.sync(60);
        }
        Display.destroy();
    }


    private static void createWindow() throws Exception {
        Display.setFullscreen(false);
        Display.setDisplayMode(new DisplayMode(640, 480));
        Display.setTitle("Final Program Checkpoint 1");
        Display.create();
    }


    private static void initGL() {
        glEnable(GL_DEPTH_TEST);
        glDepthFunc(GL_LEQUAL);
        glShadeModel(GL_SMOOTH);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        gluPerspective(100f, (640 / 480), 0.1f, 300.0f);
        glMatrixMode(GL_MODELVIEW);
        glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
        glEnable(GL_BLEND);
    }
    //public void multipleCubes(int number){
    //    for(int i ){
            
     //   }
   // }

    // method: movement 
    // purpose: Gives the user controls to move in the 3D space,
    // arrow keys or wasd to move, float up or down with left shift
    // and spacebar, respectively
    public static void movement(Camera camera, float movementSpeed) {
        if (Keyboard.isKeyDown(Keyboard.KEY_UP) || Keyboard.isKeyDown(Keyboard.KEY_W)) {
            camera.strafeForward(movementSpeed);
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_DOWN) || Keyboard.isKeyDown(Keyboard.KEY_S)) {
            camera.strafeBack(movementSpeed);
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_LEFT) || Keyboard.isKeyDown(Keyboard.KEY_A)) {
            camera.strafeLeft(movementSpeed);
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT) || Keyboard.isKeyDown(Keyboard.KEY_D)) {
            camera.strafeRight(movementSpeed);
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
            camera.moveDown(movementSpeed);
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
            camera.moveUp(movementSpeed);
        }
    }

    // method: main
    // purpose: starts the program


}
