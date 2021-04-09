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
import java.net.Socket;

/**
 *
 * @author fermelli
 */
public class ClienteSumaTCP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int port = 5001;
        try {
            Socket client = new Socket("localhost", port); 
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String nums = "1,2,3,4,5";
            toServer.println(nums);
            String result = fromServer.readLine();  
            System.out.println("La suma de los números " + nums + " es: " + result);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
