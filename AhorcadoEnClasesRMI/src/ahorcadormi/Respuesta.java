/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcadormi;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author fermelli
 */
public class Respuesta implements Serializable {

    private char letra;
    private ArrayList<Integer> posiciones;

    public ArrayList<Integer> getPosiciones() {
        return posiciones;
    }

    public void setPosiciones(ArrayList<Integer> posiciones) {
        this.posiciones = posiciones;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public Respuesta(char letra, ArrayList<Integer> posiciones) {
        this.letra = letra;
        this.posiciones = posiciones;
    }

}
