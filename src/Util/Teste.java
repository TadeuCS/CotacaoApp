/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tadeu
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] linha= new String[]{"nome","sexo","idade"};
        String[] linha2= new String[]{"nome2","sexo2","idade2"};
        String[] linha3= new String[]{"nome3","sexo3","idade3"};
        List<String[]> lista= new ArrayList<>();
        lista.add(linha);
        lista.add(linha2);
        lista.add(linha3);
        System.out.println(lista.get(0));
    }
    
}
