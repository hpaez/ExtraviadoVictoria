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
    public void ingresarExtraviado(String idpersona, String idextraviado, String nombre, String apellido, int colorcabello, int colorpiel, int colorojo, Double medicion, int contextura, int peso, String comentario) {
        ExtraviadoVO extraviadovo = new ExtraviadoVO();
        ExtraviadoDAO extraviadodao = new ExtraviadoDAO();
        extraviadovo.setId_persona(idpersona);
        extraviadovo.setIdentificacion_ex(idextraviado);
        extraviadovo.setNombre_ex(nombre);
        extraviadovo.setApellido_ex(apellido);
        extraviadovo.setCabello_ex(colorcabello);
        extraviadovo.setPiel_ex(colorpiel);
        extraviadovo.setOjos_ex(colorojo);
        extraviadovo.setMedicion_ex(medicion);
        extraviadovo.setContextura_ex(contextura);
        extraviadovo.setPeso_ex(peso);
        extraviadovo.setComentario_ex(comentario);
        extraviadodao.insertarExtraviado(extraviadovo);
    }
    
    public void actualizarExtraviado(int idextraviado, String identificacion, String nombre, String apellido, int colorcabello, int colorpiel, int colorojo, Double medicion, int contextura, int peso, String comentario){
        ExtraviadoVO extraviadovo = new ExtraviadoVO();
        ExtraviadoDAO extraviadodao = new ExtraviadoDAO();
        extraviadovo.setIdentificacion_ex(identificacion);
        extraviadovo.setNombre_ex(nombre);
        extraviadovo.setApellido_ex(apellido);
        extraviadovo.setCabello_ex(colorcabello);
        extraviadovo.setPiel_ex(colorpiel);
        extraviadovo.setOjos_ex(colorojo);
        extraviadovo.setMedicion_ex(medicion);
        extraviadovo.setContextura_ex(contextura);
        extraviadovo.setPeso_ex(peso);
        extraviadovo.setComentario_ex(comentario);
        extraviadovo.setId_extraviado(idextraviado);
        extraviadodao.editarExtraviado(extraviadovo);
    }
}