package bcp;

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
        DatabaseBcp dbBcp = new DatabaseBcp("bd_bcp", "localhost", 27017, "", "");
        String cadenaCuentas = dbBcp.obtenerCadenaCuentasCliente("8510425", "Luis Fernando", "Salgado Miguez");
        
        System.out.println(cadenaCuentas);
        
        ArrayList<Cuenta> cuentas = dbBcp.obtenerCuentasCliente("8510425", "Luis Fernando", "Salgado Miguez");
        
        System.out.println(dbBcp.congelarMonto(cuentas.get(0), 2000.40));
    }
    
}
