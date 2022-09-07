/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package meiosdetransporte;

/**
 *
 * @author Lucas
 */
public class Carro extends Automovel{
    private int qtdPortas;
    
    public Carro(String marca, int qtdRodas, String modelo, double potenciaMotor, boolean partidaEletrica){
        super(marca,qtdRodas, modelo, potenciaMotor);
        this.qtdPortas =  qtdPortas;        
    }
    
    public void imprimirInformacoes(){
        super.imprimirInformacoes();
        System.out.println("Quantidade de portas: " + qtdPortas);
    }
}
