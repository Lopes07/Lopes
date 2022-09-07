/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabanco;

/**
 *
 * @author Lucas
 */
public class Endereco {
    private String rua;
    private String complemento;
    private int numero;
    private int cep;
    private String cidade;
    private String estado;
    
    public Endereco(String rua, String complemento, int numero, int cep, String cidade, String estado){
    this.rua = rua;
    this.complemento = complemento;
    this.numero = numero;
    this.cep = cep;
    this.cidade = cidade;
    this.estado = estado;
}
    
    public void imprimir(){
        System.out.println("-------------------------------------");
        System.out.println("Rua: " + rua);
        System.out.println("Complemento: " + complemento);
        System.out.println("Número: " + numero);
        System.out.println("Cidade: " + cidade);
        System.out.println("Estado: " + estado);
        System.out.println("-------------------------------------");
        
    }
    
}
