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
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author fermelli
 */
public class ClientChatTCP {

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
                Scanner sc = new Scanner(System.in);
                String message = sc.nextLine();
                toServer.println(message);
                messageFromServer = fromServer.readLine();
                System.out.println(String.format("server > %s", messageFromServer));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } while (!"exit".equals(messageFromServer));
    }

}
