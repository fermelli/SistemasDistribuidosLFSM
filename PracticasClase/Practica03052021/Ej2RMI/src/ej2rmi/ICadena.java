/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej2rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author fermelli
 */
public interface ICadena extends Remote {

    boolean introducirValor(String cadena) throws RemoteException;
    
    String invertir() throws RemoteException;
    
    String aumentarEspacios(int numeroEspacios) throws RemoteException;
    
    String aumentar(String cadena) throws RemoteException;
    
    String getCadena() throws RemoteException;
}
