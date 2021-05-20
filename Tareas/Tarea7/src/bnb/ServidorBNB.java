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

    DatabaseBnb dbBnb = new DatabaseBnb("bd_bnb", "localhost", "root", "");
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServidorBNB servidor;
        try {
            LocateRegistry.createRegistry(1099);
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
        return dbBnb.obtenerCuentasCliente(ci, nombres, apellidos);
    }

    @Override
    public boolean congelarMonto(Cuenta cuenta, double monto) throws RemoteException {
        return dbBnb.congelarMonto(cuenta, monto);
    }
    
}
