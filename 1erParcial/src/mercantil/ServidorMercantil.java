/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercantil;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author fermelli
 */
public class ServidorMercantil {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int port = 5001;
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Se inicio el servidor MERCANTIL");
            Socket client;
            PrintStream toClient;
            do {
                client = server.accept(); //conexion aceptada
                System.out.println("Cliente se conecto SERVIDOR MERCANTIL");
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
                toClient = new PrintStream(client.getOutputStream());
                String messageFromClient = fromClient.readLine();
                String[] cadena = messageFromClient.split(":");
                String[] datos = cadena[1].split("-");
                String comando = cadena[0];
                String messageToClient = "";

                String ciValido = "11021654";
                String nombresValidos = "Juan Perez";
                String apellidosValidos = "Segovia";

                String ci = datos[0];
                String nombres = datos[1];
                String apellidos = datos[2];

                if (comando.equals("Buscar")) {
                    if (ciValido.equals(ci)
                        && nombresValidos.equals(nombres)
                        && apellidosValidos.equals(apellidos)) {
                        messageToClient = "";
                    } else {
                        messageToClient = "error:datos"; //consultaria una BD
                    }
                } else {
                    messageToClient = "error:comando";
                }

                toClient.println(messageToClient);
            } while (true);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
