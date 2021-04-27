/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcadormi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author fermelli
 */
public class ServidorAhorcado extends UnicastRemoteObject implements IAhorcado {

    String[] palabras = {"requerimientos", "laravel", "javascript", "programacion", "computadora", "objetos", "lenguaje", "compilador", "interfaz", "clases"};
    String palabraSeleccionada;
    String palabraOculta;
    int tamañoPalabraSeleccionada;
    int numeroIntentos;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServidorAhorcado servidor;
        try {
            LocateRegistry.createRegistry(1099); // registrar el servidor e rmi register
            servidor = new ServidorAhorcado();
            Naming.bind("Ahorcado", servidor);
            System.out.println("El servidor esta listo\n");
        } catch (MalformedURLException | AlreadyBoundException | RemoteException e) {
            System.out.println(e);
        }
    }

    public ServidorAhorcado() throws RemoteException {
        super();
    }

    public String getPalabraSeleccionada() {
        return palabraSeleccionada;
    }

    public void setPalabraSeleccionada() {
        int indice = (int) Math.floor(Math.random() * this.palabras.length);
        this.palabraSeleccionada = this.palabras[indice];
    }

    public int getTamañoPalabraSeleccionada() {
        return tamañoPalabraSeleccionada;
    }

    public void setTamañoPalabraSeleccionada() {
        if (this.palabraSeleccionada != null) {
            this.tamañoPalabraSeleccionada = this.palabraSeleccionada.length();
        } else {
            this.tamañoPalabraSeleccionada = 0;
        }
    }

    @Override
    public int getNumeroIntentos() {
        return numeroIntentos;
    }

    public void setNumeroIntentos(int numeroIntentos) {
        this.numeroIntentos = numeroIntentos;
    }

    public void decrementarNumeroIntentos() {
        if (this.numeroIntentos > 0) {
            this.numeroIntentos--;
        }
    }

    @Override
    public String getPalabraOculta() {
        String palabra = "";
        for (String letra : this.palabraOculta.toUpperCase().split("")) {
            palabra += " " + letra + " ";
        }
        return palabra;
    }

    public void setPalabraOculta() {
        this.palabraOculta = "";
        for (int i = 0; i < this.tamañoPalabraSeleccionada; i++) {
            this.palabraOculta += "_";
        }
    }
    
    @Override
    public boolean esGanador() {
        return !this.palabraOculta.contains("_");
    }

    @Override
    public void iniciar() {
        this.setPalabraSeleccionada();
        this.setTamañoPalabraSeleccionada();
        this.setPalabraOculta();
        this.setNumeroIntentos(5);
    }

    @Override
    public boolean intento(char letra) {
        boolean esCorrecto = this.palabraSeleccionada.indexOf(letra) != -1;
        if (esCorrecto && this.numeroIntentos > 0) {
            String[] letras = this.palabraOculta.split("");
            for (int i = 0; i < this.tamañoPalabraSeleccionada; i++) {
                if (this.palabraSeleccionada.charAt(i) == letra) {
                    letras[i] = Character.toString(letra);
                }
            }
            String p = "";
            for (String l : letras) {
                p += l;
            }
            this.palabraOculta = p;
        } else {
            this.decrementarNumeroIntentos();
        }

        return esCorrecto;
    }

}
