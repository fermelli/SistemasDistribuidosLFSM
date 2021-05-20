package bnb;

import comun.Cuenta;
import java.util.ArrayList;

/**
 *
 * @author fermelli
 */
public class DatabaseTesting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DatabaseBnb dbBnb = new DatabaseBnb("bd_bnb", "localhost", "root", "");
        ArrayList<Cuenta> cuentas = dbBnb.obtenerCuentasCliente("8510425", "Luis Fernando", "Salgado Miguez");
        for (Cuenta cuenta : cuentas) {
            System.out.println(cuenta.getNrocuenta());
            System.out.println(cuenta.getSaldo());
        }
        
        System.out.println(dbBnb.congelarMonto(cuentas.get(0), 20.40));
    }
    
}
