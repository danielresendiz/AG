/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmogenetico;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Daniel
 */
public class SeleccionRuleta {
private int tamPoblacion;//N
    private double frecuenciaEsperadaTotal = 0;//f
    private double[] aptitudes;
    private double[] valoresEsperados;//Ve
    private double r;//Numero pseudoAleatorio
    private java.util.Random random;
    private ArrayList<Integer> indicesElegidos = new ArrayList();

    public SeleccionRuleta(double[] aptitudes, Random random,int tam) {
        this.aptitudes = aptitudes;
        this.random = random;
        this.tamPoblacion=tam;
        valoresEsperados=new double[tamPoblacion];

    }
    public SeleccionRuleta(ArrayList<Integer> aptitudes, Random random,int tam) {
        
        this.random = random;
        this.tamPoblacion=tam;
        valoresEsperados=new double[tamPoblacion];
        this.aptitudes = new double[aptitudes.size()];
        for(int x=0; x<aptitudes.size(); x++){
            this.aptitudes[x]=aptitudes.get(x);
        }
    }
    /**
     * @return the tamPoblacion
     */
    public int getTamPoblacion() {
        return tamPoblacion;
    }

    /**
     * @param tamPoblacion the t

     amPoblacion to set
     */
    public void setTamPoblacion(int tamPoblacion) {
        this.tamPoblacion = tamPoblacion;
    }
    /**
     * método de selección ruleta
     * @param n número n que indica el total de indicesa generar
     * @return 
     */
    public ArrayList<Integer> selectionRul(int n) {
        //Implementar ruleta.
        ArrayList<Integer> indicesElegidos=new ArrayList<Integer>();
        indicesElegidos.clear();
        double f=0,tmp;
        //realizar la suma de las aptitudes
        for (int i=0;i<aptitudes.length;i++){
            tmp=aptitudes[i];            
            f+=tmp;
            valoresEsperados[i]=f;            
        }
        double aux=0;
        int j=0;
        int frecu=(int)f;
        //recorres n veces 
        //System.out.println("total:"+f);
        for (int i=0;indicesElegidos.size()<n;i++){
            //calcular un numero seudoaleatorio entre 0 y la Frecuencia Esperada total
            r= random.nextInt(frecu)+1;
            aux=0;
            //System.out.println("r:"+r);
            //recorrer hasta que r>=aux entiendase aux como la suma de los valores esperaodos
            for(j=0;j<valoresEsperados.length;j++){
                //aux+=valoresEsperados[j];
                if(aux>=r){
                    indicesElegidos.add(j);
                    aux=0;
                    break;
                }else{
                    aux=valoresEsperados[j];
                }
            }
        }
        return indicesElegidos;
    }
    
    

    /**
     * @return the frecuenciaEsperadaTotal
     */
    public double getFrecuenciaEsperadaTotal() {
        return frecuenciaEsperadaTotal;
    }

    /**
     * @param frecuenciaEsperadaTotal the frecuenciaEsperadaTotal to set
     */
    public void setFrecuenciaEsperadaTotal(double frecuenciaEsperadaTotal) {
        this.frecuenciaEsperadaTotal = frecuenciaEsperadaTotal;
    }

    /**
     * @return the aptitudes
     */
    public double[] getAptitudes() {
        return aptitudes;
    }

    /**
     * @param aptitudes the aptitudes to set
     */
    public void setAptitudes(double[] aptitudes) {
        this.aptitudes = aptitudes;
    }

    /**
     * @return the valoresEsperados
     */
    public double[] getValoresEsperados() {
        return valoresEsperados;
    }

    /**
     * @param valoresEsperados the valoresEsperados to set
     */
    public void setValoresEsperados(double[] valoresEsperados) {
        this.valoresEsperados = valoresEsperados;
    }

    /**
     * @return the r
     */
    public double getR() {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(double r) {
        this.r = r;
    }

    /**
     * @return the random
     */
    public java.util.Random getRandom() {
        return random;
    }

    /**
     * @param random the random to set
     */
    public void setRandom(java.util.Random random) {
        this.random = random;
    }

    /**
     * @return the indicesElegidos
     */
    public ArrayList<Integer> getIndicesElegidos() {
        return indicesElegidos;
    }

    /**
     * @param indicesElegidos the indicesElegidos to set
     */
    public void setIndicesElegidos(ArrayList<Integer> indicesElegidos) {
        this.indicesElegidos = indicesElegidos;
    }
}
