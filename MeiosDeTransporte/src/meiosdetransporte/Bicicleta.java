/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package meiosdetransporte;

/**
 *
 * @author Lucas
 */
public class Bicicleta extends Veiculo {
    int numMarchas;
    boolean bagageiro;
    
    public Bicicleta(String marca, int qtdRodas, String modelo,int numMarchas, boolean bagageiro){
        super(marca, qtdRodas, modelo);
        this.numMarchas = numMarchas;
        this.bagageiro = bagageiro;        
    }
    
    public void imprimirInformacoes(){
        super.imprimirInformacoes();
        System.out.println("Numero de marchas: "+ numMarchas );
        if(bagageiro = true){
            System.out.println("Existe bagageiro.");
        }
    }
}
