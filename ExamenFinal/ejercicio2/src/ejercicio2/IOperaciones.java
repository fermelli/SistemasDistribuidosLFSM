package ejercicio2;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author fermelli
 */
public interface IOperaciones extends Remote {

    Respuesta operacion(Solicitud sol) throws RemoteException;

    Respuesta introducir(String nStr) throws RemoteException;

    Respuesta cadena(String str) throws RemoteException;

    Respuesta factorial() throws RemoteException;

    Respuesta serieFibonacci() throws RemoteException;

    Respuesta invertir() throws RemoteException;

    Respuesta oracion() throws RemoteException;
}
