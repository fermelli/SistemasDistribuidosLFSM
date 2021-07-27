package ejercicio2;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author fermelli
 */
public class ServidorRMI extends UnicastRemoteObject implements IOperaciones {

    int numero = -1;
    String cadena = "";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServidorRMI servidor;
        try {
            LocateRegistry.createRegistry(1099);
            servidor = new ServidorRMI();
            Naming.bind("Ejercicio2", servidor);
            System.out.println("El servidor esta listo\n");
        } catch (MalformedURLException | AlreadyBoundException | RemoteException e) {
            System.out.println(e);
        }
    }

    public ServidorRMI() throws RemoteException {
        super();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    @Override
    public Respuesta introducir(String numStr) {
        int n = Integer.parseInt(numStr);
        if (n != -1) {
            setNumero(n);
            return new Respuesta("exito", "true");
        }
        return new Respuesta("exito", "false");
    }

    @Override
    public Respuesta cadena(String str) {
        if (!"".equals(str)) {
            setCadena(str);
            return new Respuesta("exito", "true");
        }
        return new Respuesta("exito", "false");
    }

    @Override
    public Respuesta factorial() {
        if (numero != -1) {
            int factorial = 1;
            for (int i = 1; i <= numero; i++) {
                factorial *= i;
            }
            return new Respuesta("resultado", String.format("%d", factorial));
        }
        return new Respuesta("resultado", "no_n");
    }

    @Override
    public Respuesta serieFibonacci() {
        if (numero != -1) {
            String serie = "";
            int f0 = 0;
            int f1 = 1;
            if (numero == 1) {
                serie = String.format("%d", f0);
            } else {
                serie = String.format("%d, %d", f0, f1);
                if (numero >= 3) {
                    serie = String.format("%d, %d", f0, f1);
                    for (int i = 3; i <= numero; i++) {
                        int f2 = f0 + f1;
                        serie += String.format(", %d", f2);
                        f0 = f1;
                        f1 = f2;
                    }
                }

            }
            return new Respuesta("resultado", serie);
        }
        return new Respuesta("resultado", "no_n");
    }

    @Override
    public Respuesta invertir() {
        if (!"".equals(cadena)) {
            StringBuilder invertida = new StringBuilder();
            for (int i = (cadena.length() - 1); i >= 0; i--) {
                invertida.append(cadena.charAt(i));
            }
            return new Respuesta("resultado", invertida.toString());
        }
        return new Respuesta("resultado", "no_string");
    }

    @Override
    public Respuesta oracion() {
        if (!"".equals(cadena)) {
            String primeraLetra = cadena.substring(0, 1).toUpperCase();
            String valor = primeraLetra + cadena.substring(1, cadena.length());
            return new Respuesta("resultado", valor);
        }
        return new Respuesta("resultado", "no_string");
    }

    @Override
    public Respuesta operacion(Solicitud solicitud) {
        switch (solicitud.getComando()) {
            case "introducir":
                return introducir(solicitud.getData());
            case "cadena":
                return cadena(solicitud.getData());
            case "factorial":
                return factorial();
            case "fibonacci":
                return serieFibonacci();
            case "invertir":
                return invertir();
            case "oracion":
                return oracion();
            default:
                return new Respuesta("novalido", "");
        }
    }
}
