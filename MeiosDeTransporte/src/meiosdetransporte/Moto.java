/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package meiosdetransporte;

/**
 *
 * @author Lucas
 */
public class Moto extends Automovel{
    private boolean partidaEletrica;
    
    public Moto(String marca, int qtdRodas, String modelo, double potenciaMotor, boolean partidaEletrica){
        super(marca, qtdRodas, modelo, potenciaMotor);
        this.partidaEletrica = partidaEletrica;
    }
    
    public void imprimirInformacoes(){
        super.imprimirInformacoes();
        if(partidaEletrica =  true){
            System.out.println("Tem partida eletrica.");
        }
    }
}
