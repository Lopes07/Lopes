/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package meiosdetransporte;

/**
 *
 * @author Lucas
 */
public class CadastroDeVeiculos {
    private Veiculo[] lista;
    private int contadorDeVeiculos;
    
   public CadastroDeVeiculos(int tamanho){
       lista = new Veiculo[tamanho];
       contadorDeVeiculos = 0;
   }
   
   public void inserir(Veiculo v){
       if(contadorDeVeiculos < lista.length){
           lista[contadorDeVeiculos++] = v;
       } else {
           Veiculo[] novaLista = new Veiculo[lista.length * 2];
           for(int i = 0; i < contadorDeVeiculos; i++)
               novaLista[i] = lista[i];
           novaLista[contadorDeVeiculos++] = v;
           lista = novaLista;
       }
   }
   
   public Veiculo retornaItem(int posicao){
       if(posicao < lista.length)
           return lista[posicao];
       else
           return null;
   }
   
   public int tamanho(){
       return ++contadorDeVeiculos;
   }
   
   public void imprimir(){
       for(int i = 0; i < contadorDeVeiculos; i++){
           lista[i].imprimirInformacoes();
       }
   }
}
