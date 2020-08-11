/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmogenetico;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class UAG {
    String Alfabet="ABCDEFGHIJKLMNOPKRSTUVYZa bcdefghijklmnopqrstuvwxyz";
    Random getnumA=new Random();
    int Poblacion_size=100;
    ArrayList<cromosomas> poblacion=new ArrayList<>();
    ArrayList<cromosomas> hijos=new ArrayList<>();
    Fitness funcionAptitud=new Fitness();
    SeleccionRuleta mecanismoseleccion;
    String objetivo;
    /**
     * inicializar lo valores de la población
     */
    public void inicializar(){
        poblacion.clear();
        hijos.clear();
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese la cadena objetivo");
        objetivo=leer.nextLine();
        System.out.println("Ingrese el tamaño de poblacion");
        Poblacion_size=leer.nextInt();
        for(int i=0;i<Poblacion_size;i++){            
            cromosomas individuo=new cromosomas();
            individuo.setAlfabeto(Alfabet);
            individuo.setRandom(getnumA);
            individuo.setTotalgenes(objetivo.length());
            individuo.inicializa();
            poblacion.add(individuo);
        }
        
        /*for(int i=0;i<Poblacion_size;i++){            
            
            System.out.println((i+1)+": "+poblacion.get(i).getCromo());
        }*/
        
    }
    
    public ArrayList<Integer> getFitness(){
        ArrayList<Integer> aptitudes =new ArrayList<>();
        for(cromosomas cromosomas:poblacion){
            aptitudes.add(Fitness.evalue(cromosomas,objetivo));
            
        }
        return aptitudes;        
    }
    public ArrayList<cromosomas> seleccion(){
        ArrayList<Integer> aptitud=this.getFitness();
        ArrayList<cromosomas> select=new ArrayList<>();
        for(int i=0;i<Poblacion_size;i++){            
            
            System.out.println("Poblacion "+(i+1)+": "+poblacion.get(i).getCromo()+"\t Aptitud: "+aptitud.get(i));
        }
        ArrayList<Integer> indexs;
        this.mecanismoseleccion = new SeleccionRuleta(aptitud,this.getnumA,this.Poblacion_size);        
        indexs=this.mecanismoseleccion.selectionRul(2);           
        for(int i=0;i<indexs.size();i++){                        
            select.add(this.poblacion.get(indexs.get(i)));
        }
        return select;
    }
    public void cruzar(){
        ArrayList<Integer> aptitud=this.getFitness();
        for(int i=0;i<Poblacion_size;i++){            
            
            System.out.println("Poblacion "+(i+1)+": "+poblacion.get(i).getCromo()+"\t Aptitud: "+aptitud.get(i));
        }
        ArrayList<Integer> indexs;
        cromosomas tmp1,tmp2;
        cromosomas[] tmp_hijos;
        this.mecanismoseleccion = new SeleccionRuleta(aptitud,this.getnumA,this.Poblacion_size);        
        
        //for(int x=0; x<this.Poblacion_size/2; x++){
        indexs=this.mecanismoseleccion.selectionRul(2);
        /*tmp1=this.poblacion.get(indexs.get(0));
            tmp2=this.poblacion.get(indexs.get(1));
            tmp_hijos = tmp1.cruza(tmp2);            
            this.hijos.add(tmp_hijos[0]);
            this.hijos.add(tmp_hijos[1]);*/                    
        //}
            
        for(int i=0;i<indexs.size();i++){                        
            System.out.println("Seleccionados: "+this.poblacion.get(indexs.get(i)));
        }
        
    }

    public static void main(String[] args) {
        UAG uno=new UAG();
        uno.inicializar();
        uno.cruzar();
    }
}
