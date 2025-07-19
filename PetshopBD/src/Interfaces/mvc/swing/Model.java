/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.swing;

/**
 *
 * @author André Cordeiro
 */
public class Model {
    private int x;
    
    public Model(){
        this.x = 0;
    }
    
    public Model(int x){
        this.x = x;
    }
    
    public void incX(){
        this.x++;
    }
    
    public int getX(){
        return this.x;
    }
}
