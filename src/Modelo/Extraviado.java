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
public class Extraviado {
    String id_extraviado;
    String id_usuario;
    String id_persona;
    String identificacion_ex;
    String nombre_ex;
    String apellido_ex;
    String cabello_ex;
    String piel_ex;
    String ojo_ex;
    Double medicion_ex;
    String contextura_ex;
    int peso_ex;
    String comentario_ex;

    public Extraviado() {
        id_extraviado="";
        id_usuario="";
        id_persona="";
        identificacion_ex="";
        nombre_ex="";
        apellido_ex="";
        cabello_ex="";
        piel_ex="";
        ojo_ex="";
        medicion_ex=0.0;
        peso_ex=0;
        contextura_ex="";
        comentario_ex="";
    }

    public String getId_extraviado() {
        return id_extraviado;
    }

    public void setId_extraviado(String id_extraviado) {
        this.id_extraviado = id_extraviado;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getId_persona() {
        return id_persona;
    }

    public void setId_persona(String id_persona) {
        this.id_persona = id_persona;
    }

    public String getIdentificacion_ex() {
        return identificacion_ex;
    }

    public void setIdentificacion_ex(String identificacion_ex) {
        this.identificacion_ex = identificacion_ex;
    }

    public String getNombre_ex() {
        return nombre_ex;
    }

    public void setNombre_ex(String nombre_ex) {
        this.nombre_ex = nombre_ex;
    }

    public String getApellido_ex() {
        return apellido_ex;
    }

    public void setApellido_ex(String apellido_ex) {
        this.apellido_ex = apellido_ex;
    }

    public String getCabello_ex() {
        return cabello_ex;
    }

    public void setCabello_ex(String cabello_ex) {
        this.cabello_ex = cabello_ex;
    }

    public String getPiel_ex() {
        return piel_ex;
    }

    public void setPiel_ex(String piel_ex) {
        this.piel_ex = piel_ex;
    }

    public String getOjo_ex() {
        return ojo_ex;
    }

    public void setOjo_ex(String ojo_ex) {
        this.ojo_ex = ojo_ex;
    }

    public Double getMedicion_ex() {
        return medicion_ex;
    }

    public void setMedicion_ex(Double medicion_ex) {
        this.medicion_ex = medicion_ex;
    }

    public String getContextura_ex() {
        return contextura_ex;
    }

    public void setContextura_ex(String contextura_ex) {
        this.contextura_ex = contextura_ex;
    }

    public int getPeso_ex() {
        return peso_ex;
    }

    public void setPeso_ex(int peso_ex) {
        this.peso_ex = peso_ex;
    }

    public String getComentario_ex() {
        return comentario_ex;
    }

    public void setComentario_ex(String comentario_ex) {
        this.comentario_ex = comentario_ex;
    }
    
    
}
