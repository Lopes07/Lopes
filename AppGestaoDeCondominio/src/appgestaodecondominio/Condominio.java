/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appgestaodecondominio;

/**
 *
 * @author Lucas
 */
public class Condominio {
    private String nome;
    private Pessoa administrador;
    private Unidades unidades;
    private ListaDeVisitantes visitantes;
    private ListaDeRegVisitantes registroDeVisitantes;
}

public Condominio(String n, Pessoa a){
    this.nome = n;
    this.administrador = a;
}

public incluirUnidade(Unidade u){

} 