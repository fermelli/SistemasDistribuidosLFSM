package ej1socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author fermelli
 */
public class ServidorSocket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int port = 5001;
        String messageFromClient;
        try {
            ServerSocket server = new ServerSocket(port);
            Socket client;
            PrintStream toClient;
            Integer a = null, b = null, c = null;

            System.out.println("Se inicio el servidor");
            System.out.println("Cliente se conecto");
            do {
                client = server.accept();
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
                toClient = new PrintStream(client.getOutputStream());

                messageFromClient = fromClient.readLine();

                System.out.println("client > " + messageFromClient);

                if ("resultado".equals(messageFromClient)) {
                    if (a != null && b != null && c != null) {
                        int mayor = calcularMayor(a, b, c);
                        toClient.println("El mayor es: " + mayor);
                    } else {
                        if (a == null) {
                            toClient.println("Falta el valor de a");
                        }
                        if (b == null) {
                            toClient.println("Falta el valor de b");
                        }
                        if (c == null) {
                            toClient.println("Falta el valor de c");
                        }
                    }
                } else {
                    String[] messageSplit = messageFromClient.split("-");
                    int numero = Integer.parseInt(messageSplit[0]);
                    String cadena = messageSplit[1];

                    if ("a".equals(cadena) || "b".equals(cadena) || "c".equals(cadena)) {

                        toClient.println(messageFromClient + "ok");

                        switch (cadena) {
                            case "a":
                                a = numero;
                                break;
                            case "b":
                                b = numero;
                                break;
                            case "c":
                                c = numero;
                                break;
                        }
                    }
                }

            } while (!"resultado".equals(messageFromClient) || a == null || b == null || c == null);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int calcularMayor(int a, int b, int c) {
        if (a > b) {
            if (a > c) {
                return a;
            } else {
                return c;
            }
        } else {
            if (b > c) {
                return b;
            } else {
                return c;
            }
        }
    }

}
