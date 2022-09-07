/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemabanco;

/**
 *
 * @author Lucas
 */
public class SistemaBanco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       boolean consegui;
       Conta minhaConta, contaDestino, contaFelipe;
       
       Pessoa maria, joao, felipe;
       maria = new Pessoa ("Maria");
       joao = new Pessoa("Joao");
       felipe = new Pessoa ("Felipe");
       
       minhaConta = new Conta(maria, 1000, 700);
       minhaConta.imprimir();
       
       contaDestino = new Conta(joao, 1000, 200);
       contaDestino.imprimir();
       
       contaFelipe = new Conta(felipe, 700, 100);
       contaFelipe.imprimir();
       
       consegui = minhaConta.saca(200);
       if (consegui == true)
            System.out.println("Saque realizado com sucesso!");
       else
           System.out.println("Saldo insuficiente. ");
       
       minhaConta.transferirPara(contaDestino, 200);
       
    }
    
}
