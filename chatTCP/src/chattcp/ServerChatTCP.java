/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chattcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author fermelli
 */
public class ServerChatTCP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int port = 5001;
        String messageFromClient;
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Se inicio el servidor");
            Socket client;
            PrintStream toClient;

            System.out.println("Cliente se conecto");
            do {
                client = server.accept(); //conexion
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
                messageFromClient = fromClient.readLine();
                System.out.println(String.format("client > %s", messageFromClient));

                Scanner sc = new Scanner(System.in);
                String message = sc.nextLine();

                toClient = new PrintStream(client.getOutputStream());
                toClient.println(message);
            } while (!"exit".equals(messageFromClient));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
