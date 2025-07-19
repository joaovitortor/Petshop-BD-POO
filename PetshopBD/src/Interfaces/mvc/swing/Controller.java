/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author André Cordeiro
 */
public class Controller {
    private Model model;
    private View view;
    private ActionListener actionListener;
    
    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }
    
    public void control(){
        this.actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                linkBtnAndLabel();
            }
        };
        view.getButton().addActionListener(actionListener);        
    }
    
    private void linkBtnAndLabel() {
        this.model.incX();
        view.setText(Integer.toString(this.model.getX()));
    }
}
