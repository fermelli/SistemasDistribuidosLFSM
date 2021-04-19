/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnormi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 *
 * @author fermelli
 */
public class ClienteCRUDAlumno {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ICRUDAlumno crudAlumno;
        Carrera carrera = new Carrera(231, "Ing. en Ciencias de la Computación");
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombres: ");
        String nombres = sc.next();
        System.out.print("Apellidos: ");
        String apellidos = sc.next();
        System.out.print("Edad: ");
        int edad = sc.nextInt();
        Alumno alumno = new Alumno(nombres, apellidos, edad, carrera);
        try {
            crudAlumno = (ICRUDAlumno) Naming.lookup("rmi://localhost/CRUDAlumno");
            crudAlumno.insertar(alumno);
        } catch (MalformedURLException | NotBoundException | RemoteException e) {
        }
    }

}
