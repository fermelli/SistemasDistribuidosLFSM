/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnormi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author fermelli
 */
public class ServidorCRUDAlumno extends UnicastRemoteObject implements ICRUDAlumno {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServidorCRUDAlumno servidor;
        try {
            LocateRegistry.createRegistry(1099); // registrar el servidor e rmi register
            servidor = new ServidorCRUDAlumno();
            Naming.bind("CRUDAlumno", servidor);
            System.out.println("El servidor esta listo\n");
        } catch (MalformedURLException | AlreadyBoundException | RemoteException e) {
            System.out.println(e);
        }
    }

    public ServidorCRUDAlumno() throws RemoteException {
        super();
    }

    @Override
    public boolean insertar(Alumno alumno) {
        System.out.println(alumno.getNombres());
        System.out.println(alumno.getApellidos());
        return true;
    }

}
