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
<<<<<<< HEAD
    public void ingresarExtraviado(String idpersona, String idextraviado, String nombre, String apellido, String colorcabello, String colorpiel, String colorojo, Double medicion, String contextura, int peso, String comentario) {
        ExtraviadoVO extraviadovo = new ExtraviadoVO();
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
=======
    
>>>>>>> origin/master
}