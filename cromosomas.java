/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmogenetico;

import java.util.Random;

/**
 *
 * @author Daniel
 */
public class cromosomas {
    private String cromo;
    static private int totalgenes;
    static private String alfabeto;
    static private Random random;

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    @Override
    public String toString() {
        return cromo;
    }
    
    public void inicializa(){
        cromo="";
    
        for(int i=0;i<totalgenes;i++){
            int idx=random.nextInt(alfabeto.length());
            cromo=cromo+alfabeto.charAt(idx);
            
        }
    
    }
    public void setCromo(String cromo) {
        this.cromo = cromo;
    }

    public void setTotalgenes(int totalgenes) {
        this.totalgenes = totalgenes;
    }

    public void setAlfabeto(String alfabeto) {
        this.alfabeto = alfabeto;
    }

    public String getCromo() {
        return cromo;
    }

    public int getTotalgenes() {
        return totalgenes;
    }

    public String getAlfabeto() {
        return alfabeto;
    }
    
    public static void main(String[] args) {
        int res=0;
        cromosomas a=new cromosomas();
        cromosomas a2=new cromosomas();
        cromosomas a3=new cromosomas();
        Fitness a4=new Fitness();
        cromosomas[] hijos=new cromosomas[2];
        a.setAlfabeto("abcdefghijklmnopkrstuvwxyzABCDEFGHIJKLMNOPKRSTUVYZ ");
        a.setRandom(new Random(System.currentTimeMillis()));
        a.setTotalgenes(10);
        a.inicializa();
        a2.inicializa();
        a3.setCromo("Hola");
        res=a4.evalue(a3,"Hola");
                
        System.out.println(a3.getCromo());
        System.out.println("Hola");
        System.out.println(res);

    }
}
