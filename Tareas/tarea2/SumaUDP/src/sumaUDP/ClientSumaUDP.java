package sumaUDP;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fermelli
 */
public class ClientSumaUDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int port = 5432;
        try {
            String data = "4,2,7,1,0,3";
            String ip = "localhost";
            DatagramSocket socketUDP = new DatagramSocket();
            byte[] mensaje = data.getBytes();
            InetAddress hostServer = InetAddress.getByName(ip);

            // Construimos un datagrama para enviar el mensaje al servidor
            DatagramPacket request = new DatagramPacket(mensaje, data.length(), hostServer, port);

            // Enviamos el datagrama
            socketUDP.send(request);

            // Construimos el DatagramPacket que contendrá la respuesta
            byte[] bufer = new byte[1000];
            DatagramPacket response = new DatagramPacket(bufer, bufer.length);
            socketUDP.receive(response);

            // Enviamos la respuesta del servidor a la salida estandar
            System.out.println(String.format("La suma de %s es: %d", data, bytesArrayToInt(response.getData())));

            // Cerramos el socket
            socketUDP.close();

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
    }
    
    public static int bytesArrayToInt(byte[] byteArray) {
        return ByteBuffer.wrap(byteArray).getInt();
    }
}
