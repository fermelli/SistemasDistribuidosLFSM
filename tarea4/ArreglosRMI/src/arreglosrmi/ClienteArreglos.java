/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arreglosrmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fermelli
 */
public class ClienteArreglos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IArreglos operacionesArreglos;
        int opcion;
        int dimension;
        int[] arreglo1;
        int[] arreglo2;
        int[] resultadoArreglo;
        int resultado;
        int resp;
        try {
            do {
                operacionesArreglos = (IArreglos) Naming.lookup("rmi://localhost/Arreglos");
                dimension = validarDimension();
                arreglo1 = llenarArreglo(dimension, 1);
                arreglo2 = llenarArreglo(dimension, 2);
                opcion = menu();
                switch (opcion) {
                    case 1:
                        resultadoArreglo = operacionesArreglos.suma(arreglo1, arreglo2);
                        imprimirArreglo(resultadoArreglo);
                        break;
                    case 2:
                        resultadoArreglo = operacionesArreglos.resta(arreglo1, arreglo2);
                        imprimirArreglo(resultadoArreglo);
                        break;
                    case 3:
                        resultado = operacionesArreglos.multiplicacion(arreglo1, arreglo2);
                        System.out.print(String.format("El resultado de la multiplicación es: %d\n", resultado));
                        break;
                    default:
                        System.out.println("...Saliendo...");
                }
                System.out.println("¿Realizar otra operacion con arreglos? \n1. Si\nOtro. No");
                Scanner sc = new Scanner(System.in);
                resp = sc.nextInt();
            } while (resp == 1);
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(ClienteArreglos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int validarDimension() {
        Scanner sc = new Scanner(System.in);
        int dimension;
        do {
            System.out.print("Introducir la dimensión de los arreglos: ");
            dimension = sc.nextInt();
            if (dimension <= 0) {
                System.out.println("¡La dimensión del arreglo debe ser positiva!");
            }
        } while (dimension <= 0);
        return dimension;
    }

    public static int[] llenarArreglo(int dimesion, int orden) {
        int[] arreglo = new int[dimesion];
        Scanner sc = new Scanner(System.in);
        System.out.println(String.format("Introduzca los elementos del %d° arreglo", orden));
        for (int i = 0; i < dimesion; i++) {
            System.out.print(String.format("[%d]: ", i));
            arreglo[i] = sc.nextInt();
        }
        return arreglo;
    }

    public static int menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- OPERACIONES CON LOS ARREGLOS ---");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Salir");
        return sc.nextInt();
    }

    public static void imprimirArreglo(int[] arreglo) {
        System.out.print("El arreglo resultante es:\n[");
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i]);
            if (i < arreglo.length - 1) {
                System.out.print(",  ");
            }
        }
        System.out.println("]");
    }
}
