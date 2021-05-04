/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sumatcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author fermelli
 */
public class ServidorSumaTCP {

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
            client = server.accept(); //conexion
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
            System.out.println("Cliente se conecto");
            //System.out.println(fromClient.readLine());
            toClient = new PrintStream(client.getOutputStream()); 
            String data = fromClient.readLine();
            String[] nums = data.split(",");
            toClient.println(addNumbers(nums));
            System.out.println("Cliente se conecto");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static int addNumbers(String[] numbers) {
        int result = 0;
        for(int i = 0; i < numbers.length; i ++) {
            result += Integer.parseInt(numbers[i]);
        }
        
        return result;
    }
    
}
