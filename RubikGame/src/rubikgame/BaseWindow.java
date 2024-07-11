/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubikgame;

import javax.swing.JFrame;

/**
 *
 * @author De'v
 */
public class BaseWindow extends JFrame {
    
    public BaseWindow() {
        setTitle("Rubik játék");
        setSize(400,400);
        setDefaultCloseOperation((JFrame.DISPOSE_ON_CLOSE));
    }
    
    protected void exit() {
        dispose();
    }
}
