/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabanco;

/**
 *
 * @author Lucas
 */
public class Pessoa {
    private String nome;
    private Endereco endereco;
    private Telefone telefone;
    private Data dataDeNascimento;
    
    public Pessoa(String nome){
        this.nome = nome;
    }
    
    public Pessoa(String nome, Endereco endereco, Telefone telefone, Data dataDeNascimento){
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dataDeNascimento = dataDeNascimento;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void imprimir(){
        System.out.println("-------------------------------------");
        System.out.println("Nome: " + nome);
        System.out.println("Endereço: " + endereco);
        System.out.println("Telefone: " + telefone);
        System.out.println("Data de nascimento: " + dataDeNascimento);
        System.out.println("-------------------------------------");
        
    }
}
