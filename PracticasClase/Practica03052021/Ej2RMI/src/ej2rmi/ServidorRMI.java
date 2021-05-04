/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej2rmi;

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
public class ServidorRMI extends UnicastRemoteObject implements ICadena {

    public String cadena;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServidorRMI servidor;
        try {
            LocateRegistry.createRegistry(1099); // registrar el servidor e rmi register
            servidor = new ServidorRMI();
            Naming.bind("Cadena", servidor);
            System.out.println("El servidor esta listo\n");
        } catch (MalformedURLException | AlreadyBoundException | RemoteException e) {
            System.out.println(e);
        }
    }

    public String getCadena() {
        return cadena;
    }

    public ServidorRMI() throws RemoteException {
        super();
    }

    @Override
    public boolean introducirValor(String cadena) throws RemoteException {
        this.cadena = cadena;
        return true;
    }

    @Override
    public String invertir() throws RemoteException {
        String cadenaInvertida = "";
        for (int i = this.cadena.length() - 1; i >= 0; i --) {
            cadenaInvertida += this.cadena.charAt(i);
        }
        return cadenaInvertida;
    }

    @Override
    public String aumentarEspacios(int numeroEspacios) throws RemoteException {
        String cadenaConEspacios = "";
        String espacios = "";
        for (int i = 0; i < numeroEspacios; i++) {
            espacios += " ";
        }
        
        String[] cadenaArray = this.cadena.split(" ");
        
        for (int j = 0; j < cadenaArray.length; j++) {
            cadenaConEspacios += cadenaArray[j] + espacios;
        }
        
        return cadenaConEspacios;
    }

    @Override
    public String aumentar(String cadena) throws RemoteException {
        return this.cadena + " " + cadena;
    }

}
