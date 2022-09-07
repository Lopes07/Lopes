/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabanco;

/**
 *
 * @author Lucas
 */
public class Telefone {
    private short ddd;
    private int numero;
    
    public Telefone(short ddd, int numero){
        this.ddd = ddd;
        this.numero = numero;
    }
    
    public void imprimir(){
        System.out.println("-------------------------------------");
        System.out.println("DDD: " + ddd);
        System.out.println("Telefone: " + numero);
        System.out.println("-------------------------------------");
        
    }
}
