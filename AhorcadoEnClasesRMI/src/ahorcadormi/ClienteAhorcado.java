/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcadormi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fermelli
 */
public class ClienteAhorcado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IAhorcado operacionesAhorcado;
        try {
            operacionesAhorcado = (IAhorcado) Naming.lookup("rmi://localhost/Ahorcado");
            int tamañoPalabra = operacionesAhorcado.iniciar();
            System.out.println(String.format("La palabra oculta es: %s", operacionesAhorcado.getPalabraOculta()));
            Scanner sc = new Scanner(System.in);
            System.out.print("Escriba una letra: ");
            char letra = sc.next().charAt(0);
            System.out.println("La letra ingresada es: " + letra);
            operacionesAhorcado.intento(letra);
            System.out.println(String.format("La palabra oculta es: %s", operacionesAhorcado.getPalabraOculta()));
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(ClienteAhorcado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
