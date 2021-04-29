/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 *
 * @author fermelli
 */
public class ClienteUniversidad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ITramites tramites;
        try {
            tramites = (ITramites) Naming.lookup("rmi://localhost/TramitesUniversidad");
            String ci = leerDato("ci");
            String nombres = leerDato("nombres");
            String primerApellido = leerDato("primer apellido");
            String segundoApellido = leerDato("segundo apellido");
            String fechaNacimiento = leerDato("fecha de nacimiento");
            String carrera = leerDato("carrera");
            Diploma diploma = tramites.emitirDiploma(ci, nombres, primerApellido, segundoApellido, fechaNacimiento, carrera);
            if ("".equals(diploma.getMensaje())) {
                System.out.println("--- Datos Diploma ---");
                System.out.println("Nombre completo: " + diploma.getNombreCompleto());
                System.out.println("Carrera: " + diploma.getCarrera());
                System.out.println("Fecha: " + diploma.getFecha());
            } else {
                System.out.println("Mensaje: " + diploma.getMensaje());
            }
        } catch (MalformedURLException | NotBoundException | RemoteException e) {
            System.out.println(e);
        }
    }
    
    public static String leerDato(String nombreDato) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca " + nombreDato);
        return teclado.nextLine().toLowerCase();
    }
    
}
