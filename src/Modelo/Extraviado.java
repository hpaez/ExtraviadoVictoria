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
    S1_IngresarExtraviado vistaIngreso;
    CtrlIngExtraviado controladorExtraviado;
        
    public void ingresarExtraviado(){
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
    public void limpiarExtraviado(){
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
    
    public void habilitarExtraviado(boolean sw){
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
        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
        }
        return validacion;
    }
}