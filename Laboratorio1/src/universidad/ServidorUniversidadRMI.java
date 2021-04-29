/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.SocketException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import segip.IVerificarDatos;
import segip.Respuesta;

/**
 *
 * @author fermelli
 */
public class ServidorUniversidadRMI extends UnicastRemoteObject implements ITramites {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServidorUniversidadRMI servidor;
        try {
            //LocateRegistry.createRegistry(1231); // registrar el servidor e rmi register
            servidor = new ServidorUniversidadRMI();
            Naming.bind("TramitesUniversidad", servidor);
            System.out.println("El servidor UNIVERSIDAD esta listo\n");
        } catch (MalformedURLException | RemoteException | AlreadyBoundException e) {
            System.out.println(e);
        }
    }

    public ServidorUniversidadRMI() throws RemoteException {
        super();
    }

    public static String getFechaActual() {
        Calendar calendario = new GregorianCalendar();
        int anio = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        return String.format("%d/%d/%d", dia, mes + 1, anio);
    }

    public static String extraerPrimerosDosCaracteres(String cadena) {
        if (cadena.length() < 2) {
            return cadena.substring(0) + " ";
        }
        return cadena.substring(0, 2);
    }

    public static String mensajeSeduca(String nombres, String primerApellido, String segundoApellido, String fechaNacimiento) {
        int port = 5001;
        String mensaje = "";
        Socket client;
        try {
            client = new Socket("localhost", port);
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));

            String extractoFecha = fechaNacimiento.replace("-", "");
            String cNombres = extraerPrimerosDosCaracteres(nombres);
            String cPrimerApellido = extraerPrimerosDosCaracteres(primerApellido);
            String cSegundoApellido = extraerPrimerosDosCaracteres(segundoApellido);
            String rude = String.format("%s%s%s%s", cNombres, cPrimerApellido, cSegundoApellido, extractoFecha);

            toServer.println("verificar-" + rude);
            String mensajeDesdeServidor = fromServer.readLine();
            String[] data = mensajeDesdeServidor.split(":");

            if ("no".equals(data[0])) {
                mensaje += "\n" + data[1];
            }
        } catch (IOException ex) {
            Logger.getLogger(ServidorUniversidadRMI.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mensaje;
    }

    public static String mensajeSereci(String nombres, String apellidos, String fechaNacimiento) {
        int port = 6789;
        String mensaje = "";

        try {
            String mensajeToServer = String.format("Ver-fecha:%s,%s,%s", nombres, apellidos, fechaNacimiento);
            String ip = "localhost";
            DatagramSocket socketUDP = new DatagramSocket();
            byte[] mensajeBytes = mensajeToServer.getBytes();
            InetAddress hostServer = InetAddress.getByName(ip);

            // Construimos un datagrama para enviar el mensaje al servidor
            DatagramPacket request = new DatagramPacket(mensajeBytes, mensajeToServer.length(), hostServer, port);

            // Enviamos el datagrama
            socketUDP.send(request);

            // Construimos el DatagramPacket que contendrá la respuesta
            byte[] bufer = new byte[1000];
            DatagramPacket response = new DatagramPacket(bufer, bufer.length);
            socketUDP.receive(response);

            // Enviamos la respuesta del servidor a la salida estandar
            String[] mensajeServidorArray = new String(response.getData()).split(":");
            
            if ("no".equals(mensajeServidorArray[0])) {
                mensaje = "\n" + mensajeServidorArray[1];
            }

            // Cerramos el socket
            socketUDP.close();

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
        return mensaje;
    }

    @Override
    public Diploma emitirDiploma(String ci, String nombres, String primerApellido, String segundoApellido, String fechaNacimiento, String carrera) {
        IVerificarDatos segip;
        String apellidos = String.format("%s %s", primerApellido, segundoApellido);
        String mensajeDiploma = "";

        mensajeDiploma += mensajeSeduca(nombres, primerApellido, segundoApellido, fechaNacimiento);
        
        mensajeDiploma += mensajeSereci(nombres, apellidos, fechaNacimiento);

        try {
            segip = (IVerificarDatos) Naming.lookup("rmi://localhost/VerificacionSegip");
            Respuesta respuestaSegip = segip.verificar(ci, nombres, apellidos);
            if (!respuestaSegip.getEstado()) {
                mensajeDiploma += "\n" + respuestaSegip.getMensaje();
            }
            String nombreCompleto = String.format("%s %s", nombres, apellidos);
            String fecha = getFechaActual();
            return new Diploma(nombreCompleto, carrera, fecha, mensajeDiploma);

        } catch (MalformedURLException | NotBoundException | RemoteException e) {
            System.out.println(e);
        }
        return null;
    }
}
