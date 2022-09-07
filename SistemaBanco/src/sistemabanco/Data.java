/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabanco;

/**
 *
 * @author Lucas
 */
public class Data {
    private byte mes, dia;
    private short ano;
    
    public Data(byte d, byte m, short a){
        dia = d;
        mes = m;
        ano = a;
    }
    
    public byte getDia(){
        return dia;
    }
    
    public byte getMes(){
        return mes;
    }
     
    public short getAno(){
        return ano;
    }
    
    public String getData(){
        return dia + "/" + mes + "/" + ano;
    }
    
 }