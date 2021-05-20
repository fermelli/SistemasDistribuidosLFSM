package database;

import comun.Cuenta;
import java.util.ArrayList;

/**
 *
 * @author fermelli
 */
public interface IDatabase {

    public void conectar();

    public void desconectar();
    
    public int obtenerIdCliente(String ci, String nombres, String apellidos);
    
    public ArrayList<Cuenta> obtenerCuentasCliente(String ci, String nombres, String apellidos);
    
    public String obtenerCadenaCuentasCliente(String ci, String nombres, String apellidos);
    
    public boolean congelarMonto(Cuenta cuenta, double monto);
    
    public boolean congelarMonto(String nroCuenta, double monto);
}
