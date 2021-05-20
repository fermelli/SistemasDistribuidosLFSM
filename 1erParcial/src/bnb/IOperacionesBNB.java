/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    boolean congelarMonto(double monto, Cuenta cuenta) throws RemoteException;
}
