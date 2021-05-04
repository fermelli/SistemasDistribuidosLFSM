/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author fermelli
 */
public interface ITramites extends Remote {

    Diploma emitirDiploma(String ci, String nombres, String primerApellido, String segundoApellido, String fechaNacimiento, String carrera) throws RemoteException;
}
