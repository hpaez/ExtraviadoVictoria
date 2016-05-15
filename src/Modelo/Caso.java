package Modelo;

import java.util.Date;

/**
 *
 * @author erik
 */
public class Caso {
    private String estado;
    private Date fecha;

    public Caso() {
    }

    public Caso(String estado, Date fecha) {
        this.estado = estado;
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
        
}