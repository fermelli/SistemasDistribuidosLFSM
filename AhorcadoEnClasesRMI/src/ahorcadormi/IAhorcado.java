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

    int iniciar() throws RemoteException;

    void intento(char letra) throws RemoteException;

    Respuesta enviarRespuesta() throws RemoteException;

    String getPalabraOculta() throws RemoteException;
}
