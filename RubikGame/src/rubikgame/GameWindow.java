/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubikgame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author De'v
 */
public class GameWindow extends BaseWindow{
    private final int size;
    private int stepsCount;
    
    private final JButton[][] buttons = new JButton[7][7];
    private final Color[][] colors = new Color[7][7];
    private final int[] colorCount = new int[7];
    
    ImageIcon upArrow = new ImageIcon("up.png");
    ImageIcon leftArrow = new ImageIcon("left.png");
    ImageIcon rubikCube = new ImageIcon("rubik.png");
    
    public GameWindow(int size) {
        this.size = size;
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(size, size));

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                addButton(mainPanel, i, j);
            }
        }

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        
        
    }
    
    private void addButton(JPanel panel, final int i, final int j) {
        if ((i == size - 1 || j == size - 1) && i != j) {
        JButton button = new JButton(upArrow);
        button.setBackground(Color.WHITE);
        if (i != size - 1) {
            button = new JButton(leftArrow);
            button.setBackground(Color.WHITE);
        }
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (gameOver()){
                    gameOverMessage();
                    exit();
                    return;
                }
                
                if (i == size -1) {
                    Color tmp = colors[0][j];
                    for (int i = 0; i < size - 2; i++) {
                        colors[i][j] = colors[i+1][j];
                        buttons[i][j].setBackground(colors[i+1][j]);
                    }
                    colors[size-2][j] = tmp;
                    buttons[size-2][j].setBackground(colors[size-2][j]);
                } else {
                    Color tmp = colors[i][0];
                    for (int j = 0; j < size - 2; j++) {
                        colors[i][j] = colors[i][j+1];
                        buttons[i][j].setBackground(colors[i][j+1]);
                    }
                    colors[i][size-2] = tmp;
                    buttons[i][size-2].setBackground(colors[i][size-2]);
                }
                stepsCount++;
            }
        });
        buttons[i][j] = button;
        colors[i][j] = button.getBackground();
        panel.add(button);
        } else if (i != size - 1 && j != size - 1) {
        JButton button = new JButton();
        Random rand = new Random();
        int n = rand.nextInt(size - 1) + 1;
        while (colorCount[n] >= size -1 ) {
            rand = new Random();
            n = rand.nextInt(size - 1) + 1;
        }
        switch (n) {
                    case 1:
                        button.setBackground(Color.RED);
                        colorCount[1]++;
                        break;
                    case 2:
                        button.setBackground(Color.BLUE);
                        colorCount[2]++;
                        break;
                    case 3:
                        button.setBackground(Color.GREEN);
                        colorCount[3]++;
                        break;
                    case 4:
                        button.setBackground(Color.YELLOW);
                        colorCount[4]++;
                        break;
                    case 5:
                        button.setBackground(Color.ORANGE);
                        colorCount[5]++;
                        break;
                    case 6:
                        button.setBackground(Color.CYAN);
                        colorCount[6]++;
                        break;
                }
        buttons[i][j] = button;
        colors[i][j] = button.getBackground();
        panel.add(button);
        } else {
            JButton button = new JButton(rubikCube);
            button.setMargin(new Insets(0, 0, 0, 0));
            buttons[i][j] = button;
            colors[i][j] = button.getBackground();
            panel.add(button);
        }
        
    }
    
    private boolean gameOver() {
        boolean sorOk = true;
        boolean oszlopOk = true;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 2; j++) {
                if (!(buttons[i][j].getBackground().equals(buttons[i][j+1].getBackground()))) sorOk = false;
            }
        }
        for (int i = 0; i < size - 2; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (!(buttons[i][j].getBackground().equals(buttons[i+1][j].getBackground()))) oszlopOk = false;
            }
        }
        return (sorOk || oszlopOk);
    }
    
    private void gameOverMessage() {
        JOptionPane.showMessageDialog(null,
                "Gratulálok, " + stepsCount + " lépésben befejezted a játékot.");
    }
}
