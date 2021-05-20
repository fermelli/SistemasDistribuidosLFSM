/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juez;

import asfi.IOperacionesCuenta;
import comun.Cuenta;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author fermelli
 */
public class ClienteJuez {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IOperacionesCuenta asfi;
        try {
            System.out.println("--- DATOS ---");
            Scanner sc = new Scanner(System.in);
            System.out.print("C.I.: ");
            String ci = sc.nextLine();
            System.out.print("Nombres: ");
            String nombres = sc.nextLine();
            System.out.print("Apellidos: ");
            String apellidos = sc.nextLine();
            asfi = (IOperacionesCuenta) Naming.lookup("rmi://localhost/asfi");
            ArrayList<Cuenta> cuentas = asfi.ListarCuentas(ci, nombres, apellidos);
            
            System.out.println("--- SELECCIONA UNA CUENTA ---");
            int i = 0;
            for (Cuenta cuenta : cuentas) {
                i++;
                System.out.println(i + ". CUENTA");
                System.out.println(String.format("\tBanco: %s", cuenta.getBanco()));
                System.out.println(String.format("\tN° Cuenta: %s", cuenta.getNrocuenta()));
                System.out.println(String.format("\tSaldo: %s", cuenta.getSaldo()));
            }
            System.out.print("Elegir cuenta: ");
            int opcion = sc.nextInt();
            Cuenta cuentaSeleccionada = cuentas.get(opcion - 1);
            System.out.print("Glosa: ");
            String glosa = sc.next();
            System.out.print("Monto a retener: ");
            double monto = sc.nextDouble();
            boolean respuesta = asfi.RetenerMonto(cuentaSeleccionada, monto, glosa);
            if (respuesta) {
                System.out.println("¡Transaccion con exito!");
            } else {
                System.out.println("¡No se pudo hacer la retención!");
            }
        } catch (MalformedURLException | NotBoundException | RemoteException e) {
            System.out.println(e);
        }
    }

}
