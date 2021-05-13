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
            Scanner sc = new Scanner(System.in);
            System.out.print("C.I.: ");
            String ci = sc.nextLine();
            System.out.print("Nombres: ");
            String nombres = sc.nextLine();
            System.out.print("Apellidos: ");
            String apellidos = sc.nextLine();
            asfi = (IOperacionesCuenta) Naming.lookup("rmi://localhost/asfi");
            ArrayList<Cuenta> cuentas = asfi.ListarCuentas(ci, nombres, apellidos);
            for (Cuenta cuenta : cuentas) {
                System.out.println(String.format("Banco: ", cuenta.getBanco()));
                System.out.println(String.format("N° Cuenta: ", cuenta.getNrocuenta()));
                System.out.println(String.format("Saldo: ", cuenta.getSaldo()));
            }
        } catch (MalformedURLException | NotBoundException | RemoteException e) {
            System.out.println(e);
        }
    }

}
