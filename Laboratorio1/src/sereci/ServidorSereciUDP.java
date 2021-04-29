/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sereci;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author fermelli
 */
public class ServidorSereciUDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int port = 6789;
        try {

            DatagramSocket socketUDP = new DatagramSocket(port);
            byte[] bufer = new byte[1000];

            System.out.print("Servidor SERECI listo");
            while (true) {
                // Construimos el DatagramPacket para recibir peticiones
                DatagramPacket request = new DatagramPacket(bufer, bufer.length);

                // Leemos una petición del DatagramSocket
                socketUDP.receive(request);

                System.out.print("Datagrama recibido del host: " + request.getAddress());
                System.out.println(" desde el puerto remoto: " + request.getPort());

                String mensajeDesdeCliente = new String(request.getData()).replaceAll("\\P{Print}", "");

                String[] cadena = mensajeDesdeCliente.split(":");

                String[] datos = cadena[1].split(",");

                String nombresValido = "walter jhamil";
                String apellidosValido = "segovia arellano";
                String fechaNacimientoValido = "11-02-1996";

                String mensajeRespuesta;
                if (datos[0].equals(nombresValido) && datos[1].equals(apellidosValido) && datos[2].equals(fechaNacimientoValido)) {
                    mensajeRespuesta = "si:Verificación correcta";
                } else {
                    mensajeRespuesta = "no:Error fecha nacimiento no correcta";
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
