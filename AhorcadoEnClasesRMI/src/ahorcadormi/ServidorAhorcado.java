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
import java.util.ArrayList;

/**
 *
 * @author fermelli
 */
public class ServidorAhorcado extends UnicastRemoteObject implements IAhorcado {

    String[] palabras = {"prueba", "juego", "dos", "cuatro", "paralelepipedo"};
    int indicePalabraSeleccionada;
    String palabraSeleccionada;
    ArrayList<Respuesta> historial;
    String palabraOculta;

    public String[] getPalabras() {
        return palabras;
    }

    public void setPalabras(String[] palabras) {
        this.palabras = palabras;
    }

    public ServidorAhorcado() throws RemoteException {
        super();
    }

    @Override
    public int iniciar() {
        this.indicePalabraSeleccionada = (int) Math.floor(Math.random() * this.palabras.length);
        this.palabraSeleccionada = this.palabras[this.indicePalabraSeleccionada];
        this.setPalabraOculta();
        return this.palabraSeleccionada.length();
    }

    @Override
    public void intento(char letra) {

        ArrayList<Integer> posiciones = new ArrayList<>();
        for (int i = 0; i < this.palabraSeleccionada.length(); i++) {
            if (this.palabraSeleccionada.charAt(i) == letra) {
                posiciones.add(i);
            }
        }
        
        StringBuilder palabra = new StringBuilder(this.palabraOculta);
        for (Integer posicion : posiciones) {
            palabra.setCharAt(posicion, letra);   
        }
        this.palabraOculta = palabra.toString();
//        Respuesta respuesta = new Respuesta(letra, posiciones);
//        historial.add(respuesta);
    }

    @Override
    public Respuesta enviarRespuesta() {
        return historial.get(historial.size());
    }

    public void setPalabraOculta() {
        this.palabraOculta = "";
        for (int i = 0; i < palabraSeleccionada.length(); i++) {
            this.palabraOculta += "*";
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String getPalabraOculta() {
        return this.palabraOculta;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServidorAhorcado servidor;
        try {
            LocateRegistry.createRegistry(1099);
            servidor = new ServidorAhorcado();
            Naming.bind("Ahorcado", servidor);
            System.out.println("El servidor esta listo\n");
        } catch (MalformedURLException | AlreadyBoundException | RemoteException e) {
            System.out.println(e);
        }
    }

}
