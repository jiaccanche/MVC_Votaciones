/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author jorge canche
 */
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
public class TryGridLayout {
  public static void main(String[] args) {
    JFrame aWindow = new JFrame("This is a Grid Layout");
    aWindow.setBounds(20, 20, 300, 300);
    aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    GridLayout grid = new GridLayout(10, 10, 60, 20);
    Container content = aWindow.getContentPane(); 
    content.setLayout(grid); 
    JButton button = null;
    for (int i = 1; i <= 11; i++) {
      content.add(button = new JButton(" Press " + i));
    }
    aWindow.pack();
    aWindow.setVisible(true);
  }
}
