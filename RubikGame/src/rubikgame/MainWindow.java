/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubikgame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author De'v
 */
public class MainWindow extends BaseWindow{
    //private List<GameWindow> gameWindows = new ArrayList<>();
    private final int SMALL = 2;
    private final int MEDIUM = 4;
    private final int LARGE = 6;
    
    public MainWindow() {
        JLabel title = new JLabel();
        title.setText("Válaszd ki, hányszor hányas pályát szeretnél:");
        setSize(300,300);
        
        JButton small = new JButton();
        JButton medium = new JButton();
        JButton large = new JButton();
        
        small.setText("2x2");
        medium.setText("4x4");
        large.setText("6x6");
        
        small.addActionListener(newGame(SMALL));
        medium.addActionListener(newGame(MEDIUM));
        large.addActionListener(newGame(LARGE));
        
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        getContentPane().add(title);
        getContentPane().add(small);
        getContentPane().add(medium);
        getContentPane().add(large);
    }
    
    public ActionListener newGame(int size) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameWindow window = new GameWindow(size + 1);
                window.setSize(125*size,125*size);
                window.setVisible(true);
                //gameWindows.add(window);
            }
        };
    }
    /*
    public List<GameWindow> getWindowList() {
        return gameWindows;
    }
    */
}
