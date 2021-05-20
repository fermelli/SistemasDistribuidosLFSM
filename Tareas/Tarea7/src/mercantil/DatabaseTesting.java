package mercantil;

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
        DatabaseMercantil dbMercantil = new DatabaseMercantil("bd_mercantil", "localhost", 5432, "postgres", "PostgreSQL13");
        String cadenaCuentas = dbMercantil.obtenerCadenaCuentasCliente("8510425", "Luis Fernando", "Salgado Miguez");
        
        System.out.println(cadenaCuentas);
        
        ArrayList<Cuenta> cuentas = dbMercantil.obtenerCuentasCliente("8510425", "Luis Fernando", "Salgado Miguez");
        
        System.out.println(dbMercantil.congelarMonto(cuentas.get(0), 2000.40));
    }

}
