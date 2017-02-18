/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpp.cs445.finalproject;
import java.io.*;
import org.lwjgl.opengl.*;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import static org.lwjgl.util.glu.GLU.gluPerspective;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.util.vector.*;
/**
 *
 * @author kartiksoni
 */
public class Camera {
    
    public Vector3f position;
    private float xOffset = 0f;
    private float yOffset = 0f;
    private float zOffset = 0f;

    // method: Camera 
    // purpose: Camera constructor to this obejct class
    public Camera(float x, float y, float z) {
        position = new Vector3f(x, y, z);
    }

    // method: cameraView 
    // purpose: allows the user to rotate the camera with the mouse
    
    public void cameraView() {
        glRotatef(xOffset, 1.0f, 0.0f, 0.0f);
        glRotatef(yOffset, 0.0f, 1.0f, 0.0f);
        glTranslatef(position.x, position.y, position.z);
    }

    // method: pitch
    // purpose: rotates via the pitch of the camera
    public void pitch(float pitchOffset) {
        this.xOffset += pitchOffset;
    }

    // method: yaw 
    // purpose: rotates via the yaw of the camera
    public void yaw(float yawOffset) {
        this.yOffset += yawOffset;
    }

    // method: strafeForward 
    // purpose: moves the camera forward a distance
    public void strafeForward(float distance) {
        position.x -= distance * (float) Math.sin(Math.toRadians(yOffset));
        position.z += distance * (float) Math.cos(Math.toRadians(yOffset));
    }

    // method: strafeBack 
    // purpose: moves the camera back a distance
    public void strafeBack(float distance) {
        position.x += distance * (float) Math.sin(Math.toRadians(yOffset));
        position.z -= distance * (float) Math.cos(Math.toRadians(yOffset));
    }

    // method: strafeLeft 
    // purpose: moves the camera left a distance
    public void strafeLeft(float distance) {
        position.x -= distance * (float) Math.sin(Math.toRadians(yOffset - 90));
        position.z += distance * (float) Math.cos(Math.toRadians(yOffset - 90));
    }

    // method: strafeRight 
    // purpose: moves the camera right a distance
    public void strafeRight(float distance) {
        position.x -= distance * (float) Math.sin(Math.toRadians(yOffset + 90));
        position.z += distance * (float) Math.cos(Math.toRadians(yOffset + 90));
    }

    // method: moveUp 
    // purpose: moves the camera upwards a distance
    public void moveUp(float distance) {
        position.y -= distance;
    }

    // method: moveDown 
    // purpose: moves the camera downwards a distance
    public void moveDown(float distance) {
        position.y += distance;
    }

}
