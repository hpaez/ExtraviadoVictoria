/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.S1_IngresarExtraviado;
import Controlador.CtrlIngExtraviado;
import javax.swing.JOptionPane;

/**
 *
 * @author DerKow
 */
public class Extraviado {
    private S1_IngresarExtraviado vistaIngreso;
    private CtrlIngExtraviado controladorExtraviado;
    
    private int id_extraviado;
    private String id_persona;
    private String idtentificacion_ex;
    private String nombre_ex;
    private String apellido_ex;
    private String cabello_ex;
    private String piel_ex;
    private String ojos_ex;
    private Double medicion_ex;
    private String contextura_ex;
    private int peso_ex;
    private String comentario_ex;
    
    public Extraviado() {
        id_extraviado=0;
        id_persona="";
        idtentificacion_ex="";
        nombre_ex="";
        apellido_ex="";
        cabello_ex="";
        piel_ex="";
        ojos_ex="";
        medicion_ex=0.0;
        contextura_ex="";
        peso_ex=0;
        comentario_ex="";
    }
    
    public void ingresarExtraviado() {
        if (vistaIngreso.txt_rutSolicitante.getText().trim().equals("") || vistaIngreso.txt_nombreSolicitante.getText().trim().equals("")
                || vistaIngreso.txt_apellidoSolicitante.getText().trim().equals("") || vistaIngreso.txt_telefonoSolicitante.getText().trim().equals("")
                || vistaIngreso.txt_movilSolicitante.getText().trim().equals("") || vistaIngreso.txt_emailSolicitante.getText().trim().equals("")
                ) {
            JOptionPane.showMessageDialog(null, "Debe completar todos los campos del Solicitante");
        }else if (!validarRut(vistaIngreso.txt_rutSolicitante.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Rut incorrecto");
            vistaIngreso.txt_rutSolicitante.requestFocus();
        }else if (vistaIngreso.radio_noAplica.isSelected()==false || vistaIngreso.radio_pasaporte.isSelected()==false || vistaIngreso.radio_rut.isSelected()==false){
            JOptionPane.showMessageDialog(null, "Debe seleccionar una opción");
        }
    }
    
        //Limpiar campos de la pantalla Ingresar Extraviado
    public void limpiarExtraviado() {
        vistaIngreso.txt_rutSolicitante.requestFocus();
        
        //Limpia campos del Solicitante
        vistaIngreso.txt_rutSolicitante.setText("");
        vistaIngreso.txt_nombreSolicitante.setText("");
        vistaIngreso.txt_apellidoSolicitante.setText("");
        vistaIngreso.txt_telefonoSolicitante.setText("");
        vistaIngreso.txt_movilSolicitante.setText("");
        vistaIngreso.txt_emailSolicitante.setText("");
        
        //Limpia campos del Extraviado
        habilitarExtraviado(false);
        vistaIngreso.txt_radioOption.setText("");
        vistaIngreso.txt_nombreExtraviado.setText("");
        vistaIngreso.txt_apellidoP_Extraviado.setText("");
        vistaIngreso.txt_apellidoM_Extraviado.setText("");
        vistaIngreso.txt_colorPelo.setText("");
        vistaIngreso.txt_colorPiel.setText("");
        vistaIngreso.txt_colorOjos.setText("");
        vistaIngreso.txt_altura.setText("");
        vistaIngreso.textarea_comentario.setText("");
    }
    
    public void habilitarExtraviado(boolean sw) {
        vistaIngreso.txt_radioOption.setEnabled(sw);
    }
    
    public static boolean validarRut(String rut) {
        boolean validacion = false;
        try {
            rut = rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }
        } catch(Exception e) {
        }
        return validacion;
    }

    public S1_IngresarExtraviado getVistaIngreso() {
        return vistaIngreso;
    }

    public void setVistaIngreso(S1_IngresarExtraviado vistaIngreso) {
        this.vistaIngreso = vistaIngreso;
    }

    public CtrlIngExtraviado getControladorExtraviado() {
        return controladorExtraviado;
    }

    public void setControladorExtraviado(CtrlIngExtraviado controladorExtraviado) {
        this.controladorExtraviado = controladorExtraviado;
    }

    public int getId_extraviado() {
        return id_extraviado;
    }

    public void setId_extraviado(int id_extraviado) {
        this.id_extraviado = id_extraviado;
    }

    public String getId_persona() {
        return id_persona;
    }

    public void setId_persona(String id_persona) {
        this.id_persona = id_persona;
    }

    public String getIdtentificacion_ex() {
        return idtentificacion_ex;
    }

    public void setIdtentificacion_ex(String idtentificacion_ex) {
        this.idtentificacion_ex = idtentificacion_ex;
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

    public String getOjos_ex() {
        return ojos_ex;
    }

    public void setOjos_ex(String ojos_ex) {
        this.ojos_ex = ojos_ex;
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