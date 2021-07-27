package ejercicio2;

import java.io.Serializable;

/**
 *
 * @author fermelli
 */
public class Respuesta implements Serializable {

    private String clave;
    private String valor;

    public Respuesta(String clave, String valor) {
        this.clave = clave;
        this.valor = valor;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
