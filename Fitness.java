/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmogenetico;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 *
 * @author Daniel
 */
public class Fitness {
    public static int evalue (cromosomas individuo,String objetivo){
        int aptitud=1;
        //int res=0;
        boolean prueba=true;
        String cad=individuo.getCromo();
        for(int i=0;i<individuo.getCromo().length();i++){
            prueba=true;
            if(objetivo.charAt(i)==cad.charAt(i)){
                aptitud+=3;
                
            }else{
                for(int j=0;j<cad.length()&&prueba;j++){
                    //while(prueba){
                        if(objetivo.charAt(j)==cad.charAt(i)){
                            aptitud+=2;
                            prueba=false;
                        }
                    //}
                }
            }
        }
        return aptitud;
    }
}
