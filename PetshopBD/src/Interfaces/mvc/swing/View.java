/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.swing;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author André Cordeiro
 */
public class View {
    private JFrame frame;
    private JLabel label;
    private JButton button;
    
    public View(){
        this.frame = new JFrame("View");
        this.frame.getContentPane().setLayout(new BorderLayout());
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(200, 200);
        
        this.label = new JLabel("x:");
        frame.getContentPane().add(this.label, BorderLayout.CENTER);
        
        this.button = new JButton("Button");
        this.frame.getContentPane().add(this.button, BorderLayout.SOUTH);
        this.frame.setVisible(true);
    }
    
    public JButton getButton(){
        return this.button;
    }
    
    public void setText(String text){
        this.label.setText(text);
    }
}
