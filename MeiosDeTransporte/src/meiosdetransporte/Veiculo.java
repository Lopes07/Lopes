/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package meiosdetransporte;

/**
 *
 * @author Lucas
 */
public class Veiculo {
    private String marca;
    private int qtdRodas;
    private String modelo;
    private int velocidade = 0;
    private int velocidadeAtual;
    
    public Veiculo(String marca, int qtdRodas, String modelo){
        this.marca = marca;
        this.qtdRodas = qtdRodas;
        this.modelo = modelo;
    }


    public void imprimirInformacoes(){
    System.out.println("###Veículo###");
    System.out.println("Marca: "+ marca + "\nQuantidade de rodas: " + qtdRodas +"Modelo: " + modelo + "Velocidade: " + velocidade);    
    }

    public void acelerar(int valor){
    velocidade = valor + velocidadeAtual;
    }
    
    public void frear(int valor){
    velocidade = valor + velocidadeAtual;
    }
    
    public void setVelocidadeAtual(int velocidadeAtual){
        if(velocidadeAtual > 0){
            this.velocidadeAtual = velocidadeAtual;
        } else{
            System.out.println("Entre com uma velocidade valida.");
        }
    }
}
