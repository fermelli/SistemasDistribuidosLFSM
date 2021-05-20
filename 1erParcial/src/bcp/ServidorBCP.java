/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

                String ciValido = "11021654";
                String nombresValidos = "Juan";
                String apellidosValidos = "Perez Segovia";

                String mensajeRespuesta;
                if (comando.equals("Buscar")) {
                    if (datos[0].equals(ciValido) && datos[1].equals(nombresValidos) && datos[2].equals(apellidosValidos)) {
                        mensajeRespuesta = "657654-2534.32";
                    } else {
                        mensajeRespuesta = "error:datos";
                    }
                } else if(comando.equals("Congelar")) {
                    String cuenta = datos[0];
                    if(cuenta.equals("657654")) {
                        mensajeRespuesta = "SI-657654";
                    } else {
                        mensajeRespuesta = "error:datos";
                    }
                } else {
                    mensajeRespuesta = "error:comando";
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
