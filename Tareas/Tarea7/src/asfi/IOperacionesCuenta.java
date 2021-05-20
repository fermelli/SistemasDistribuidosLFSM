package asfi;

import comun.Cuenta;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author fermelli
 */
public interface IOperacionesCuenta extends Remote {

    ArrayList<Cuenta> ListarCuentas(String ci, String nombres, String apellidos) throws RemoteException;

    boolean RetenerMonto(Cuenta cuenta, double monto, String glosa) throws RemoteException;

}
