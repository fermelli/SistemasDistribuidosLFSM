/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arreglosrmi;

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
public class ServidorArreglos extends UnicastRemoteObject implements IArreglos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServidorArreglos servidor;
        try {
            LocateRegistry.createRegistry(1099); // registrar el servidor e rmi register
            servidor = new ServidorArreglos();
            Naming.bind("Arreglos", servidor);
            System.out.println("El servidor esta listo\n");
        } catch (MalformedURLException | AlreadyBoundException | RemoteException e) {
            System.out.println(e);
        }
    }

    public ServidorArreglos() throws RemoteException {
        super();
    }

    @Override
    public int[] suma(int[] arreglo1, int[] arreglo2) {
        return operacion("suma", arreglo1, arreglo2);
    }

    @Override
    public int[] resta(int[] arreglo1, int[] arreglo2) {
        return operacion("resta", arreglo1, arreglo2);
    }

    @Override
    public int[] multiplicacion(int[] arreglo1, int[] arreglo2) {
        return operacion("multiplicacion", arreglo1, arreglo2);
    }

    public int[] operacion(String operacion, int[] arreglo1, int[] arreglo2) {
        int dimension = arreglo1.length;
        int[] resultado = new int[dimension];
        for (int i = 0; i < dimension; i++) {
            if (operacion == "suma") {
                resultado[i] = arreglo1[i] + arreglo2[i];
            } else if (operacion == "resta") {
                resultado[i] = arreglo1[i] - arreglo2[i];
            } else {
                resultado[i] = arreglo1[i] * arreglo2[i];
            }
        }
        return resultado;
    }

}
