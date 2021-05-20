package bcp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author fermelli
 */
public class ServidorBCP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int port = 6789;
        DatabaseBcp dbBcp = new DatabaseBcp("bd_bcp", "localhost", 27017, "", "");
        try {

            DatagramSocket socketUDP = new DatagramSocket(port);
            byte[] bufer = new byte[1000];

            System.out.print("Servidor BCP listo");
            while (true) {
                // Construimos el DatagramPacket para recibir peticiones
                DatagramPacket request = new DatagramPacket(bufer, bufer.length);

                // Leemos una petición del DatagramSocket
                socketUDP.receive(request);

                System.out.print("Datagrama recibido del host: " + request.getAddress());
                System.out.println(" desde el puerto remoto: " + request.getPort());

                String mensajeDesdeCliente = new String(request.getData()).replaceAll("\\P{Print}", "");

                String[] cadena = mensajeDesdeCliente.split(":");

                String comando = cadena[0];
                String[] datos = cadena[1].split("-");

                String mensajeRespuesta;
                switch (comando) {
                    case "Buscar":
                        String ci = datos[0];
                        String nombres = datos[1];
                        String apellidos = datos[2];
                        mensajeRespuesta = dbBcp.obtenerCadenaCuentasCliente(ci, nombres, apellidos);
                        break;
                    case "Congelar":
                        String nroCuenta = datos[0];
                        double monto = Double.parseDouble(datos[1]);
                        if (dbBcp.congelarMonto(nroCuenta, monto)) {
                            mensajeRespuesta = "si-" + nroCuenta;
                        } else {
                            mensajeRespuesta = "no-no encontrado";
                        }
                    default:
                        mensajeRespuesta = "error:comando";
                        break;
                }
                byte[] mensajeBytes = mensajeRespuesta.getBytes();

                // Construimos el DatagramPacket para enviar la respuesta
                DatagramPacket response = new DatagramPacket(mensajeBytes, mensajeRespuesta.length(), request.getAddress(), request.getPort());
                // Enviamos la respuesta, que es un eco
                socketUDP.send(response);
            }

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
    }

}
