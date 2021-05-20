package comun;

import java.io.Serializable;

/**
 *
 * @author fermelli
 */
public class Cuenta implements Serializable {

    String ci;
    String nombres;
    String apellidos;
    String nrocuenta;
    double saldo;
    Banco banco;

    public Cuenta(String ci, String nombres, String apellidos, String nrocuenta, double saldo, Banco banco) {
        this.ci = ci;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.nrocuenta = nrocuenta;
        this.saldo = saldo;
        this.banco = banco;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNrocuenta() {
        return nrocuenta;
    }

    public void setNrocuenta(String nrocuenta) {
        this.nrocuenta = nrocuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }
}
