/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package meiosdetransporte;

/**
 *
 * @author Lucas
 */
public class Automovel extends Veiculo{
    double potenciaMotor;
    
    public Automovel(String marca, int qtdRodas, String modelo, double potenciaMotor){
        super(marca, qtdRodas, modelo);
        potenciaMotor = potenciaMotor;
    }
    
    public void imprimirInformacoes(){
        super.imprimirInformacoes();
        System.out.println("Potencia do motor: "+ potenciaMotor);
    }
    
}
