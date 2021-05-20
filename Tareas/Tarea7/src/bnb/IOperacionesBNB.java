package bnb;

import comun.Cuenta;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author fermelli
 */
public interface IOperacionesBNB  extends Remote {

    ArrayList<Cuenta> obtenerSaldo(String ci, String nombres, String apellidos) throws RemoteException;
    
    boolean congelarMonto(Cuenta cuenta, double monto) throws RemoteException;
}
