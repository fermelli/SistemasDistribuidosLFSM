/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seduca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author fermelli
 */
public class ServidorSeducaTCP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int port = 5001;

        try {
                ServerSocket server = new ServerSocket(port);
                System.out.println("Se inicio el servidor SEDUCA");
                Socket client;
                PrintStream toClient;
            do {
                client = server.accept(); //conexion
                System.out.println("Cliente se conecto SERVIDOR UNIVERSIDAD");
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
                toClient = new PrintStream(client.getOutputStream());
                String messageFromClient = fromClient.readLine();
                String[] data = messageFromClient.split("-");
                String messageToClient;
                if ("wasear11021996".equals(data[1])) {
                    messageToClient = "si:Verificado con éxito";
                } else {
                    messageToClient = "no:No se encontró el titulo de bachiller";
                }
                toClient.println(messageToClient);
            } while (true);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
