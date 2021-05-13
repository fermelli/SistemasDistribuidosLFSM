/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bnb;

import comun.Cuenta;
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
public class ServidorBNB extends UnicastRemoteObject implements IOperacionesBNB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServidorBNB servidor;
        try {
            LocateRegistry.createRegistry(1099); // registrar el servidor e RMI register
            servidor = new ServidorBNB();
            Naming.bind("bnb", servidor);
            System.out.println("El servidor BNB esta listo\n");
        } catch (MalformedURLException | AlreadyBoundException | RemoteException e) {
            System.out.println(e);
        }
    }
    
    public ServidorBNB() throws RemoteException {
        super();
    }

    @Override
    public ArrayList<Cuenta> obtenerSaldo(String ci, String nombres, String apellidos) throws RemoteException {
        ArrayList<Cuenta> cuentas = new ArrayList<>();
        
        String ciValido = "11021654";
        String nombresValidos = "Juan Perez";
        String apellidosValidos = "Segovia";
        
        if (ciValido.equals(ci) &&
            nombresValidos.equals(nombres) &&
            apellidosValidos.equals(apellidos)) {
            cuentas.add(new Cuenta("4657657", ci, nombres, apellidos, 123.43, "Banco BNB"));
        }
        
        return cuentas;
    }
    
}
