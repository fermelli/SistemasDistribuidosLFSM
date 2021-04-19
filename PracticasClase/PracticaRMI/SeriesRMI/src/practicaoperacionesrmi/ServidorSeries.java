/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaoperacionesrmi;

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
public class ServidorSeries extends UnicastRemoteObject implements ISeries {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServidorSeries servidor;
        try {
            LocateRegistry.createRegistry(1099); // registrar el servidor e rmi register
            servidor = new ServidorSeries();
            Naming.bind("Series", servidor);
            System.out.println("El servidor esta listo\n");
        } catch (MalformedURLException | AlreadyBoundException | RemoteException e) {
            System.out.println(e);
        }
    }

    public ServidorSeries() throws RemoteException {
        super();
    }

    @Override
    public int fibonacci(int number) {
        int f0 = 0;
        int f1 = 1;
        if (number == 1) {
            return f0;
        }

        if (number == 2) {
            return f1;
        }

        int f2 = 0;
        for (int i = 2; i <= number; i++) {
            f2 = f1 + f0;
            f0 = f1;
            f1 = f2;
        }
        return f2;
    }

    @Override
    public int factorial(int number) {
        int fac = 1;
        for (int i = 2; i <= number; i++) {
            fac *= i;
        }
        return fac;
    }

    @Override
    public int sumatoria(int number) {
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            sum += i;
        }
        return sum;
    }

}
