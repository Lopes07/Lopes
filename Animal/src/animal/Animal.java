/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package animal;

/**
 *
 * @author Lucas
 */
public class Animal {
    private String identificador;
    
    public Animal(String i){
        this.identificador = i;
    }
    
    public void atuar(int a, int d){
        for(int i = 0; i<a; i++)
            alimentar();
        for(int i = 0; i<d; i++)
            dormir();
    }
    
    public void alimentar(){
        System.out.println("Comendo.");
    }
    public void dormir(){
        System.out.println("Dormindo.");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
