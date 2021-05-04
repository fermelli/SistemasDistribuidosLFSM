/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej2rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 *
 * @author fermelli
 */
public class ClienteRMI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ICadena operacionesCadena;
        Scanner scanner = new Scanner(System.in);
        int opcion;
        String cadena;

        try {
            operacionesCadena = (ICadena) Naming.lookup("rmi://localhost/Cadena");
            do {
                opcion = menu();

                switch (opcion) {
                    case 1:
                        System.out.println("--- Introducir cadena ---");
                        System.out.print("Introduzca una cadena: ");
                        cadena = scanner.nextLine();

                        if (operacionesCadena.introducirValor(cadena)) {
                            System.out.println("Cadena introducida correctamente");
                        }
                        break;
                    case 2:
                        if (operacionesCadena.getCadena() != null) {
                            System.out.println("--- Invertir cadena ---");
                            System.out.println("Cadena invertida: " + operacionesCadena.invertir());
                        } else {
                            System.out.println("Primero introduzca la cadena");
                        }
                        break;
                    case 3:
                        if (operacionesCadena.getCadena() != null) {
                            System.out.println("--- Aumentar espacios ---");
                            System.out.print("Cantidad de espacios a aumentar: ");
                            int espacios = scanner.nextInt();
                            System.out.println("Cadena con espacios aumentados: " + operacionesCadena.aumentarEspacios(espacios));
                        } else {
                            System.out.println("Primero introduzca la cadena");
                        }
                        break;
                    case 4:
                        if (operacionesCadena.getCadena() != null) {
                            System.out.println("--- Aumentar a la cadena ---");
                            System.out.print("Introduzca cadena a aumentar: ");
                            cadena = scanner.nextLine();
                            System.out.println("Cadena aumentada: " + operacionesCadena.aumentar(cadena));
                        } else {
                            System.out.println("Primero introduzca la cadena");
                        }
                        break;
                    default:
                        System.out.println("Saliendo...");
                }

            } while (opcion != 5);
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            System.out.println(ex);
        }
    }

    public static int menu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("---- Menú ----");
            System.out.println("1. Introducir");
            System.out.println("2. Invertir");
            System.out.println("3. Aumentar espacios");
            System.out.println("4. Aumentar");
            System.out.println("5. Salir");
            System.out.print("Introducir opcion (1-5): ");
            opcion = scanner.nextInt();
            if (opcion < 1 || opcion > 5) {
                System.out.println("¡Opción no válida!");
            }
        } while (opcion < 1 || opcion > 5);

        return opcion;
    }

}
