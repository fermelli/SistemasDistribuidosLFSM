/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segip;

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
public class ServidorSegipRMI extends UnicastRemoteObject implements IVerificarDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServidorSegipRMI servidor;
        try {
            LocateRegistry.createRegistry(1099); // registrar el servidor e rmi register
            servidor = new ServidorSegipRMI();
            Naming.bind("VerificacionSegip", servidor);
            System.out.println("El servidor SEGIP esta listo\n");
        } catch (MalformedURLException | RemoteException | AlreadyBoundException ex) {
            System.out.println(ex);
        }
    }
    
    public ServidorSegipRMI() throws RemoteException {
        super();
    }

    @Override
    public Respuesta verificar(String ci, String nombres, String apellidos) {
        String ciValido = "1140506";
        String nombresValido = "walter jhamil";
        String apellidosValido = "segovia arellano";
        if (ci.equals(ciValido) && nombres.equals(nombresValido) && apellidos.equals(apellidosValido)) {
            return new Respuesta(true, "Los datos son correctos");
        }
        return new Respuesta(false, "Los Datos del CI no son correctos");
    }
    
}
