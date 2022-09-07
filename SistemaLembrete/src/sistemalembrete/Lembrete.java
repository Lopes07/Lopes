/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemalembrete;

/**
 *
 * @author Lucas
 */
public class Lembrete {
    private Data data;
    private String nome;
    private String descricao;
    
    public Lembrete(String nome, String descricao, Data data){
    this.data = data;
    this.nome = nome;
    this.descricao = descricao;
}
    
    
    public void imprimir(){
        System.out.println("#### Lembrete ####");
        System.out.println("Nome: " + nome + "\nData: " + data.getData() + "\nDescrição: " + descricao);
        System.out.println("##################");
    }
    
    public boolean dataEhIgual(Data data){
        return this.data.dataEhIgual(data);
    }
    
    public boolean nomeContemSubstring(String substr){
        if(this.nome.contains(substr))
            return true;
        return false;
    }
}
