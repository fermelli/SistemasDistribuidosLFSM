/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaoperacionesrmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author fermelli
 */
public interface ISeries extends Remote {

    int fibonacci(int number) throws RemoteException;

    int factorial(int number) throws RemoteException;

    int sumatoria(int number) throws RemoteException;
}
