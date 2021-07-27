package ejercicio2;

import java.io.Serializable;

/**
 *
 * @author fermelli
 */
public class Solicitud implements Serializable {

    private String comando;
    private String data;

    public Solicitud(String comando) {
        this.comando = comando;
    }

    public Solicitud(String comando, String data) {
        this.comando = comando;
        this.data = data;
    }

    public String getComando() {
        return comando;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
