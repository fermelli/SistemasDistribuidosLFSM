/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorialTCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author fermelli
 */
public class ClienteFactorial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int port = 5001;
        try {
            Socket client = new Socket("localhost", port); 
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String num = "5";
            toServer.println(num);
            String result = fromServer.readLine();  
            System.out.println("El factorial de " + num + " es: " + result);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
