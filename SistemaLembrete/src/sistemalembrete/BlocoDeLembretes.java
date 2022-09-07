/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemalembrete;
import java.util.Arrays;

/**
 *
 * @author Lucas
 */
public class BlocoDeLembretes {
    private Lembrete[] lista;
    private int contadorDeLembretes;
    
    public BlocoDeLembretes(){
        lista = new Lembrete[10];
        contadorDeLembretes = 0;
    }
    public BlocoDeLembretes(int tamanho){
        lista = new Lembrete[tamanho];
        contadorDeLembretes = 0;
    }
    
    public void incluirLembrete(Lembrete l){
        if(contadorDeLembretes < lista.length){
            lista[contadorDeLembretes++] = l;            
        }else{
            Lembrete[] novaLista = new Lembrete[lista.length *2];
            for(int i = 0; i < contadorDeLembretes; i++)
                novaLista[i] = lista[i];
            novaLista[contadorDeLembretes++] = l;
            lista = novaLista;
        }
    }
    
    public int numeroLembretes(){
        return ++contadorDeLembretes;
    }
    
    public void listarLembretes(){
        for(int i = 0; i < contadorDeLembretes; i++)
            lista[i].imprimir();
    }
    
    
    public Lembrete excluirLembrete( int posicao){
        if(posicao < contadorDeLembretes){
            Lembrete excluido = lista[posicao];
            for(int i = posicao; i < contadorDeLembretes - 1; i++)
                lista[i] = lista[i+1];
            contadorDeLembretes--;
            return excluido;
        }
        else
            return null;
    }
    public void buscarLembretePorData(Data data){
        for(int i = 0; i <contadorDeLembretes; i++){
            if(lista[i].dataEhIgual(data))
                lista[i].imprimir();
        }
    }
        
    public void buscarLembretePorNome(String substr){
        for(int i = 0; i <contadorDeLembretes; i++){
            if(lista[i].nomeContemSubstring(substr))
                lista[i].imprimir();
        }
    }
}
