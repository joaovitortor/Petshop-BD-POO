/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package interfaceteste;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author guest-b7qhgy
 */
public class InterfaceTeste extends JFrame {

    /**
     * @param args the command line arguments
     */
    public InterfaceTeste(){
        setTitle("Layout FlowLayout");
        setSize(380, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        
        JLabel jLabel1 = new JLabel();
        jLabel1.setFont(new Font("Tahoma", 1, 18));
        jLabel1.setText("Cadastro de Dados");
        add(jLabel1);
        
        JLabel jLabel2 = new JLabel();
        jLabel1.setText("Nome:");        
        add(jLabel2);
        
        JTextField jTextField = new JTextField();
        jTextField.setText("Digite aqui o seu nome");
        add(jTextField);
        
        JLabel jLabel3 = new JLabel();
        jLabel3.setText("Sexo: ");
        add(jLabel3);
        
        setVisible(true);
        
    }
    
    public static void main(String[] args) {
        new InterfaceTeste();
    }
    
}
