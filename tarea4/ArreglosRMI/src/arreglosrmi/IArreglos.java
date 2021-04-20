/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arreglosrmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author fermelli
 */
public interface IArreglos extends Remote {

    int[] suma(int[] arreglo1, int[] arreglo2) throws RemoteException;

    int[] resta(int[] arreglo1, int[] arreglo2) throws RemoteException;

    int[] multiplicacion(int[] arreglo1, int[] arreglo2) throws RemoteException;
}
