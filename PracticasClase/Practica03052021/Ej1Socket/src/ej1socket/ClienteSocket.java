/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej1socket;

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
public class ClienteSocket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int port = 5001;
        String messageFromServer = "";
        do {
            try {
                Socket client = new Socket("localhost", port);
                PrintStream toServer = new PrintStream(client.getOutputStream());
                BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
                Scanner scanner = new Scanner(System.in);
                int opcion = menu();
                String messageToServer = "";

                switch (opcion) {
                    case 1:
                        System.out.print("Valor de a: ");
                        messageToServer = scanner.nextInt() + "-a";
                        break;
                    case 2:
                        System.out.print("Valor de b: ");
                        messageToServer = scanner.nextInt() + "-b";
                        break;
                    case 3:
                        System.out.print("Valor de c: ");
                        messageToServer = scanner.nextInt() + "-c";
                        break;
                    case 4:
                        messageToServer = "resultado";
                        break;
                        
                }

                toServer.println(messageToServer);

                messageFromServer = fromServer.readLine();
                System.out.println("server > " + messageFromServer);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } while (!messageFromServer.contains("El mayor es: "));
    }

    public static int menu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {

            System.out.println("--- Menú ---");
            System.out.println("1. Introducir a");
            System.out.println("2. Introducir b");
            System.out.println("3. Introducir c");
            System.out.println("4. Resultado");
            System.out.print("Valor de la opción: ");

            opcion = scanner.nextInt();

            if (opcion < 1 || opcion > 4) {
                System.out.println("¡Introduzca una opción válida!");
            }

        } while (opcion < 1 || opcion > 4);

        return opcion;
    }

}
