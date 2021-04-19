package practicaoperacionesrmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author fermelli
 */
public class ClienteSeries {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ISeries series;
        int opcion;
        int number;
        int resp;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Introduzca un número: ");
            number = sc.nextInt();
            opcion = menu();
            try {
                series = (ISeries) Naming.lookup("rmi://localhost/Series");
                switch (opcion) {
                    case 1:
                        System.out.println(String.format("El fibonacci de %d es: %d", number, series.fibonacci(number)));
                        break;
                    case 2:
                        System.out.println(String.format("El factorial de %d es: %d", number, series.factorial(number)));
                        break;
                    default:
                        System.out.println(String.format("La sumatoria de %d es: %d", number, series.sumatoria(number)));
                        break;
                }
            } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                Logger.getLogger(ClienteSeries.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Otro numero?");
            System.out.println("1. Si");
            System.out.println("2. No");
            resp = sc.nextInt();
            System.out.println(resp);
        } while (resp == 1);
        System.out.println("...Saliendo...");
    }

    public static int menu() {
        int op;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("--- Menú ---");
            System.out.println("1. Fibonacci");
            System.out.println("2. Factorial");
            System.out.println("3. Sumatoria");
            op = sc.nextInt();
            if (op != 1 && op != 2 && op != 3) {
                System.out.println("Opción no Válida");
            }
        } while (op != 1 && op != 2 && op != 3);
        return op;
    }

}
