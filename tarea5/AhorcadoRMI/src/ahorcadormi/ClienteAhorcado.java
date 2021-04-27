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

/**
 *
 * @author fermelli
 */
public class ClienteAhorcado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IAhorcado ahorcado;
        try {
            ahorcado = (IAhorcado) Naming.lookup("rmi://localhost/Ahorcado");
            ahorcado.iniciar();
            Scanner teclado = new Scanner(System.in);
            System.out.print("Introduzca la letra del intento: ");
            char letra = teclado.next().charAt(0);
            boolean respuesta = ahorcado.intento(letra);
        } catch (MalformedURLException | NotBoundException | RemoteException e) {
            System.out.println(e);
        }
    }
    
}
