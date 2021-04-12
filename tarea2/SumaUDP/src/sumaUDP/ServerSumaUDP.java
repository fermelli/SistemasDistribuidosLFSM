package sumaUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
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
public class ServerSumaUDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int port = 5432;
        try {

            DatagramSocket socketUDP = new DatagramSocket(port);
            byte[] bufer = new byte[1000];

            while (true) {
                // Construimos el DatagramPacket para recibir peticiones
                DatagramPacket request = new DatagramPacket(bufer, bufer.length);

                // Leemos una petición del DatagramSocket
                socketUDP.receive(request);

                System.out.print("Datagrama recibido del host: " + request.getAddress());
                System.out.println(" desde el puerto remoto: " + request.getPort());

                String[] numbers = new String(request.getData()).split(",");
                int sum = addNumbers(numbers);
                byte[] responseBuffer = intToBytesArray(sum);
                // Construimos el DatagramPacket para enviar la respuesta
                DatagramPacket response = new DatagramPacket(responseBuffer,
                    responseBuffer.length,
                    request.getAddress(),
                    request.getPort());
                // Enviamos la respuesta, que es un eco
                socketUDP.send(response);
            }

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
    }

    public static int addNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number.replaceAll("\\P{Print}", "")); // quitar caracteres no imprimibles
        }
        return sum;
    }

    public static byte[] intToBytesArray(int integerNumber) {
        return ByteBuffer.allocate(4).putInt(integerNumber).array();
    }
}
