/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mvc.swing;

/**
 *
 * @author André Cordeiro
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Model model = new Model(0);
        View view = new View();
        Controller controller = new Controller(model, view);
        controller.control();      
    }    
}
