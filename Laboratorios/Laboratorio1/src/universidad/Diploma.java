/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad;

import java.io.Serializable;

/**
 *
 * @author fermelli
 */
public class Diploma implements Serializable {
    String nombreCompleto;
    String carrera;
    String fecha;
    String mensaje;

    public Diploma(String nombreCompleto, String carrera, String fecha, String mensaje) {
        this.nombreCompleto = nombreCompleto;
        this.carrera = carrera;
        this.fecha = fecha;
        this.mensaje = mensaje;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
