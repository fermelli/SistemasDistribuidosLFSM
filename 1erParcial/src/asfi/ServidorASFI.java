/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asfi;

import bnb.IOperacionesBNB;
import comun.Banco;
import comun.Cuenta;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.MalformedURLException;
import java.net.Socket;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
//import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author fermelli
 */
public class ServidorASFI extends UnicastRemoteObject implements IOperacionesCuenta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServidorASFI servidor;
        try {
            //LocateRegistry.createRegistry(1099); // ya esta registrado el servidor e RMI
            servidor = new ServidorASFI();
            Naming.bind("asfi", servidor);
            System.out.println("El servidor ASFI esta listo\n");
        } catch (MalformedURLException | AlreadyBoundException | RemoteException e) {
            System.out.println(e);
        }
    }

    public ServidorASFI() throws RemoteException {
        super();
    }

    public static ArrayList<Cuenta> cuentasBNB(String ci, String nombres, String apellidos) {
        IOperacionesBNB operacionesBNB;
        ArrayList<Cuenta> cuentas = new ArrayList<>();
        try {
            operacionesBNB = (IOperacionesBNB) Naming.lookup("rmi://localhost/bnb");
            cuentas = operacionesBNB.obtenerSaldo(ci, nombres, apellidos);
        } catch (MalformedURLException | NotBoundException | RemoteException e) {
            System.out.println(e);
        }
        return cuentas;
    }

    public static ArrayList<Cuenta> cuentasMercantil(String ci, String nombres, String apellidos) {
        int port = 5001;
        Socket client;
        ArrayList<Cuenta> cuentas = new ArrayList<>();
        try {
            client = new Socket("localhost", port);
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));

            toServer.println("Buscar:" + String.format("%s-%s-%s", ci, nombres, apellidos));
            String mensajeDesdeServidor = fromServer.readLine();
            String[] cadena = mensajeDesdeServidor.split(":");

            if (!"error".equals(cadena[0]) && !"".equals(cadena[0])) {
                for (String subcadena : cadena) {
                    String[] data = subcadena.split("-");
                    String nroCuenta = data[0];
                    double saldo = Double.parseDouble(data[1]);
                    Cuenta cuenta = new Cuenta(nroCuenta, ci, nombres, apellidos, saldo, Banco.BANCO_MERCANTIL);

                    cuentas.add(cuenta);
                }
            }

        } catch (IOException ex) {
            System.out.println(ex);
        }

        return cuentas;
    }

    public static ArrayList<Cuenta> cuentasBCP(String ci, String nombres, String apellidos) {
        int port = 6789;

        ArrayList<Cuenta> cuentas = new ArrayList<>();
        try {
            String mensajeToServer = String.format("Buscar:%s-%s-%s", ci, nombres, apellidos);
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
            String[] cadena = new String(response.getData()).split(":");

            if (!"error".equals(cadena[0]) && !"".equals(cadena[0])) {
                for (String subcadena : cadena) {
                    String[] data = subcadena.split("-");
                    String nroCuenta = data[0];
                    double saldo = Double.parseDouble(data[1]);
                    Cuenta cuenta = new Cuenta(nroCuenta, ci, nombres, apellidos, saldo, Banco.BANCO_BCP);

                    cuentas.add(cuenta);
                }
            }

            // Cerramos el socket
            socketUDP.close();

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
        return cuentas;
    }

    @Override
    public ArrayList<Cuenta> ListarCuentas(String ci, String nombres, String apellidos) {
        ArrayList<Cuenta> todasLasCuentas = new ArrayList<>();
        ArrayList<Cuenta> cuentasMercantil = cuentasMercantil(ci, nombres, apellidos);
        for (Cuenta cuenta : cuentasMercantil) {
            todasLasCuentas.add(cuenta);
        }
        ArrayList<Cuenta> cuentasBCP = cuentasBCP(ci, nombres, apellidos);
        for (Cuenta cuenta : cuentasBCP) {
            todasLasCuentas.add(cuenta);
        }
        IOperacionesBNB bnb;
        try {
            bnb = (IOperacionesBNB) Naming.lookup("rmi://localhost/bnb");
            ArrayList<Cuenta> cuentasBNB = bnb.obtenerSaldo(ci, nombres, apellidos);
            for (Cuenta cuenta : cuentasBNB) {
                todasLasCuentas.add(cuenta);
            }
            return todasLasCuentas;
        } catch (MalformedURLException | NotBoundException | RemoteException e) {
            System.out.println(e);
        }
        return todasLasCuentas;
    }

    public boolean retenerMontoBNB(double monto, Cuenta cuenta) {
        IOperacionesBNB bnb;
        try {
            bnb = (IOperacionesBNB) Naming.lookup("rmi://localhost/bnb");
            return bnb.congelarMonto(monto, cuenta);
        } catch (MalformedURLException | NotBoundException | RemoteException e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean retenerMontoBCP(double monto, Cuenta cuenta) {
        int port = 6789;
        try {
            String mensajeToServer = String.format("Congelar:%s-%s", cuenta.getNrocuenta(), monto);
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
            String[] cadena = new String(response.getData()).split("-");

            if (!"error".equals(cadena[0]) && !"".equals(cadena[0])) {
                if (cadena[0].equals("SI")) {
                    return true;
                }

                if (cadena[0].equals("NO")) {
                    return false;
                }
            }

            // Cerramos el socket
            socketUDP.close();

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
        return false;
    }

    public boolean retenerMontoMercantil(double monto, Cuenta cuenta) {
        int port = 5001;
        Socket client;
        try {
            client = new Socket("localhost", port);
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));

            toServer.println("Congelar:" + String.format("%s-%s", cuenta.getNrocuenta(), monto));
            String mensajeDesdeServidor = fromServer.readLine();
            String[] cadena = mensajeDesdeServidor.split("-");

            if (!"error".equals(cadena[0]) && !"".equals(cadena[0])) {
                if (cadena[0].equals("SI")) {
                    return true;
                }

                if (cadena[0].equals("NO")) {
                    return false;
                }
            }

        } catch (IOException ex) {
            System.out.println(ex);
        }

        return false;
    }

    @Override
    public boolean RetenerMonto(Cuenta cuenta, double monto, String glosa) {
        switch (cuenta.getBanco()) {
            case BANCO_BNB:
                return retenerMontoBNB(monto, cuenta);
            case BANCO_MERCANTIL:
                return retenerMontoMercantil(monto, cuenta);
            case BANCO_BCP:
                return retenerMontoBCP(monto, cuenta);
            default:
                return false;
        }
    }

}
