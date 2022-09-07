/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemalembrete;

/**
 *
 * @author Lucas
 */
public class LembretesApp {
        
    public static void main(String[] args) {
        BlocoDeLembretes bloco = new BlocoDeLembretes(2);
        bloco.incluirLembrete(new Lembrete("Aula de POO", "Segundas às 15h10", new Data((byte)28,(byte)03,(short)2022)));
        bloco.incluirLembrete(new Lembrete("Compras", "Mercado", new Data((byte)29,(byte)03,(short)2022)));
        bloco.incluirLembrete( new Lembrete("Dentista", "Clinica Gaming", new Data((byte)28,(byte)03,(short)2022)));
        
        //Lembrete excluido = bloco.excluirLembrete(1);
        //bloco.listarLembretes();
        
        //System.out.println("-- Lembrete excluido -- ");
        //excluido.imprimir();
        
        Data minhaData = new Data((byte)28,(byte)03,(short)2022);
        System.out.println("-- Lembretes para a data "+ minhaData.getData()+ " -- ");
        bloco.buscarLembretePorData(minhaData);
        
        System.out.println(" -- Lembrete por nome -- ");
        bloco.buscarLembretePorNome("Com");
    }
    
}
