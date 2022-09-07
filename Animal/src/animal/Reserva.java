/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animal;

/**
 *
 * @author Lucas
 */
public class Reserva extends Animal {
    private Animal[] listaDeAnimais;
    private int numeroDeAnimais;
    
    
    public Reserva(){
        listaDeAnimais = new Animal[8];
        numeroDeAnimais = 0;
    }
    
    public void simularAtuacao(){
        for(int i = 0; i < 8; i ++)
            atuar(2,1); 
    }
    public static void main(String[] args) {
        Predador leao = new Predador("Leão");
        Predador guepardo1 = new Predador("Guepardo");
        Predador guepardo2 = new Predador("Guepardo");
        Presa zebra1 = new Presa("Zebra");
        Presa zebra2 = new Presa("Zebra");
        Presa antilope1 = new Presa("Antílope");
        Presa antilope2 = new Presa("Antílope");
        Presa antilope3 = new Presa("Antílope");
        
        for(int i = 0; i < 30; i++){
            leao.atuar(1 ,2);
            guepardo1.atuar(1, 2);
            guepardo2.atuar(1, 2);
            zebra1.atuar(2, 1);
            zebra2.atuar(2, 1);
            antilope1.atuar(2,1);
            antilope2.atuar(2,1);
            antilope3.atuar(2,1);
        }
    }
}
