/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcadormi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author fermelli
 */
public interface IAhorcado extends Remote {

    void iniciar() throws RemoteException;

    boolean intento(char letra) throws RemoteException;
    
    String getPalabraOculta() throws RemoteException;
    
    int getNumeroIntentos() throws RemoteException;
    
    boolean esGanador() throws RemoteException;
}
