package ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author fermelli
 */
public class ClienteTCP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int port = 5001;
        int op = 7;
        do {
            try {
                Socket client = new Socket("localhost", port);
                PrintStream toServer = new PrintStream(client.getOutputStream());
                BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
                Scanner teclado = new Scanner(System.in);

                String operacion;
                String data = "";
                op = menu();
                switch (op) {
                    case 1:
                        System.out.print("Introduzca una número: ");
                        data = teclado.nextLine();
                        operacion = "introducir";
                        break;
                    case 2:
                        System.out.print("Introduzca una cadena: ");
                        data = teclado.nextLine();
                        operacion = "cadena";
                        break;
                    case 3:
                        operacion = "factorial";
                        break;
                    case 4:
                        operacion = "fibonacci";
                        break;
                    case 5:
                        operacion = "invertir";
                        break;
                    case 6:
                        operacion = "oracion";
                        break;
                    default:
                        operacion = "novalido";
                }
                String comando = formatearComando(operacion, data);
                toServer.println(comando);
                String resultado = fromServer.readLine();
                System.out.println(resultado);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } while (op != 7);

    }

    public static int menu() {
        Scanner teclado = new Scanner(System.in);
        int opcion;
        System.out.println("--- MENU ---");
        System.out.println("1. Introducir n");
        System.out.println("2. Introducir cadena");
        System.out.println("3. Factorial");
        System.out.println("4. Fibonacci");
        System.out.println("5. Invertir");
        System.out.println("6. Oración");
        System.out.println("7. Salir");

        do {
            System.out.print("Introduzca una opción: ");
            opcion = teclado.nextInt();
            if (opcion <= 0 && opcion >= 8) {
                System.out.print("¡Introduzca una opción válida!");
            }
        } while (opcion <= 0 && opcion >= 8);
        return opcion;
    }

    public static String formatearComando(String operacion, String data) {
        if (!"".equals(data)) {
            return String.format("%s:%s", operacion, data);
        }
        return operacion;
    }
}
