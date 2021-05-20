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
            DatabaseMercantil bdMercantil = new DatabaseMercantil("bd_mercantil", "localhost", 5432, "postgres", "PostgreSQL13");
            do {
                client = server.accept();
                System.out.println("Cliente se conecto SERVIDOR MERCANTIL");
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
                toClient = new PrintStream(client.getOutputStream());
                String messageFromClient = fromClient.readLine();
                String[] cadena = messageFromClient.split(":");
                String[] datos = cadena[1].split("-");
                String comando = cadena[0];
                String messageToClient = "";
                switch (comando) {
                    case "Buscar":
                        String ci = datos[0];
                        String nombres = datos[1];
                        String apellidos = datos[2];
                        messageToClient = bdMercantil.obtenerCadenaCuentasCliente(ci, nombres, apellidos);
                        break;
                    case "Congelar":
                        String nroCuenta = datos[0];
                        double monto = Double.parseDouble(datos[1]);
                        if (bdMercantil.congelarMonto(nroCuenta, monto)) {
                            messageToClient = "si-" + nroCuenta;
                        } else {
                            messageToClient = "no-no encontrado";
                        }
                        break;
                    default:
                        messageToClient = "error:comando";
                        break;
                }

                toClient.println(messageToClient);
            } while (true);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
