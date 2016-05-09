/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author DerKow
 */
public class PersonaVO {
    private String id_persona;
    private String nombre_per;
    private String apellido_per;
    private String fijo_per;
    private String movil_per;
    private String correo_per;
    private String direccion_per;
    
    public PersonaVO(){
        id_persona = "";
        nombre_per = "";
        apellido_per = "";
        fijo_per = "";
        movil_per = "";
        correo_per = "";
        direccion_per = "";
    }    

    public String getId_persona() {
        return id_persona;
    }

    public void setId_persona(String id_persona) {
        this.id_persona = id_persona;
    }

    public String getNombre_per() {
        return nombre_per;
    }

    public void setNombre_per(String nombre_per) {
        this.nombre_per = nombre_per;
    }

    public String getApellido_per() {
        return apellido_per;
    }

    public void setApellido_per(String apellido_per) {
        this.apellido_per = apellido_per;
    }

    public String getFijo_per() {
        return fijo_per;
    }

    public void setFijo_per(String fijo_per) {
        this.fijo_per = fijo_per;
    }

    public String getMovil_per() {
        return movil_per;
    }

    public void setMovil_per(String movil_per) {
        this.movil_per = movil_per;
    }

    public String getCorreo_per() {
        return correo_per;
    }

    public void setCorreo_per(String correo_per) {
        this.correo_per = correo_per;
    }

    public String getDireccion_per() {
        return direccion_per;
    }

    public void setDireccion_per(String direccion_per) {
        this.direccion_per = direccion_per;
    }
}