/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author Acer
 */
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

public class WindowManager {
    private static final List<JFrame> openFrames = new ArrayList<>();

    // Register a new frame (call this when a JFrame opens)
    public static void registerFrame(JFrame frame) {
        openFrames.add(frame);
    }

    // Close all registered frames (call this on logout)
    public static void closeAllFrames() {
        for (JFrame frame : openFrames) {
            frame.dispose(); // Close each frame
        }
        openFrames.clear(); // Clear the list
    }
}
