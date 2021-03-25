/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

import java.util.Scanner;

/**
 *
 * @author fermelli
 */
public class Fibonacci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int number = validate();
        int fiboN = FibonacciUmpteenth(number);
        System.out.println("El " + number + "° elemento de la serie fibonacci es: " + fiboN);
    }
    
    public static int validate() {
        Scanner sc = new Scanner(System.in);
        int n;
        do {
            System.out.print("Introduzca un número: ");
            n = sc.nextInt();
            if (n <= 0) {
                System.out.println("¡El número debe ser positivo!");
            }
        } while (n <= 0);
        return n;
    }
    
    public static int FibonacciUmpteenth(int n) {
        int f0 = 0;
        int f1 = 1;
        if(n == 1) return f0;
        if(n == 2) return f1;
        int f2 = 0;
        for (int i = 2; i < n; i++) {
            f2 = f0 + f1;
            f0 = f1;
            f1 = f2;
        }
        return f2;
    }
    
}
