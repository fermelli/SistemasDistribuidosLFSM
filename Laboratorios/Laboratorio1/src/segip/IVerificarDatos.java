/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segip;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author fermelli
 */
public interface IVerificarDatos extends Remote {

    Respuesta verificar(String ci, String nombres, String apellidos) throws RemoteException;
}
