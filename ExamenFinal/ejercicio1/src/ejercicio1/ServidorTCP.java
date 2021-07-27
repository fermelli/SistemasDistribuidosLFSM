package ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int port = 5001;

        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Se inicio el servidor");
            Socket client;
            PrintStream toClient;
            int numero = -1;
            String cadena = "";
            String resultado = "";
            do {
                client = server.accept(); //conexion
                System.out.println("Cliente se conecto");
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
                toClient = new PrintStream(client.getOutputStream());
                String messageFromClient = fromClient.readLine();
                String comando;
                String argumento = "";
                if (messageFromClient.contains(":")) {
                    String[] data = messageFromClient.split(":");
                    if (data.length == 2) {
                        comando = data[0];
                        argumento = data[1];
                        switch (comando) {
                            case "introducir":
                                if (!"".equals(argumento)) {
                                    numero = Integer.parseInt(argumento);
                                    resultado = "exito:true";
                                } else {
                                    resultado = "exito:false";
                                }
                                break;
                            case "cadena":
                                if (!"".equals(argumento)) {
                                    cadena = argumento;
                                    resultado = "exito:true";
                                } else {
                                    resultado = "exito:false";
                                }
                                break;
                        }
                    } else {
                        resultado = "exito:false";
                    }
                } else {
                    comando = messageFromClient;
                    switch (comando) {
                        case "factorial":
                            resultado = "resultado:" + factorial(numero);
                            break;
                        case "fibonacci":
                            resultado = "resultado:" + serieFibonacci(numero);
                            break;
                        case "invertir":
                            resultado = "resultado:" + invertir(cadena);
                            break;
                        case "oracion":
                            resultado = "resultado:" + oracion(cadena);
                            break;
                        default:
                            resultado = "";
                    }
                }

                toClient.println(resultado);
            } while (true);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String factorial(int n) {
        if (n != -1) {
            int factorial = 1;
            for (int i = 1; i <= n; i++) {
                factorial *= i;
            }
            return String.format("%d", factorial);
        }
        return "no_n";

    }

    public static String serieFibonacci(int n) {
        if (n != -1) {
            String serie = "";
            int f0 = 0;
            int f1 = 1;
            if (n == 1) {
                serie = String.format("%d", f0);
            } else {
                serie = String.format("%d, %d", f0, f1);
                if (n >= 3) {
                    serie = String.format("%d, %d", f0, f1);
                    for (int i = 3; i <= n; i++) {
                        int f2 = f0 + f1;
                        serie += String.format(", %d", f2);
                        f0 = f1;
                        f1 = f2;
                    }
                }

            }
            return serie;
        }
        return "no_n";
    }

    public static String invertir(String cadena) {
        if (!"".equals(cadena)) {
            StringBuilder invertida = new StringBuilder();
            for (int i = (cadena.length() - 1); i >= 0; i--) {
                invertida.append(cadena.charAt(i));
            }
            return invertida.toString();
        }
        return "no_string";
    }

    public static String oracion(String cadena) {
        if (!"".equals(cadena)) {
            String primeraLetra = cadena.substring(0, 1).toUpperCase();
            return primeraLetra + cadena.substring(1, cadena.length());
        }
        return "no_string";
    }
}
