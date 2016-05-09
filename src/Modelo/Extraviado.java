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
    
    public void ingresarExtraviado(ExtraviadoVO extraviadovo) {
        ExtraviadoDAO extraviadodao;
        if(vistaIngreso.buttonGroup1.getSelection() == null || !vistaIngreso.txt_nombre.getText().trim().equals("") || !vistaIngreso.txt_apellidos.getText().trim().equals("") || vistaIngreso.combo_cOjos.getSelectedIndex() > 0 || vistaIngreso.combo_cPelo.getSelectedIndex() > 0 || vistaIngreso.combo_cPiel.getSelectedIndex() > 0 || vistaIngreso.combo_contextura.getSelectedIndex() > 0){
            if(vistaIngreso.radio_rut.isSelected() == true && !vistaIngreso.txt_radioOption.getText().trim().equals("")){
                if(validarRut(vistaIngreso.txt_radioOption.getText()) == true){
                    extraviadodao = new ExtraviadoDAO();
                    extraviadodao.insertarExtraviado(extraviadovo);
                } else {
                    JOptionPane.showMessageDialog(null, "Rut ingresado es incorrecto.","Advertencia",JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe ingresar el rut.","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
            
            if(vistaIngreso.radio_pasaporte.isSelected() == true && !vistaIngreso.txt_radioOption.getText().trim().equals("")){
                extraviadodao = new ExtraviadoDAO();
                extraviadodao.insertarExtraviado(extraviadovo);
            } else {
                JOptionPane.showMessageDialog(null, "Debe ingresar el pasaporte.","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hay campos que no fueron ingresados.","Advertencia",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    /*limpia todos los campos del formulario*/
    public void limpiarCampos(){      
        /*datos extraviado*/
        habilitarExtraviado(false);
        
        vistaIngreso.radio_noAplica.setSelected(true);
        vistaIngreso.txt_radioOption.setText("");
        vistaIngreso.txt_nombre.setText("");
        vistaIngreso.txt_apellidos.setText("");
        
        vistaIngreso.combo_cOjos.setSelectedIndex(0);
        vistaIngreso.combo_cPelo.setSelectedIndex(0);
        vistaIngreso.combo_cPiel.setSelectedIndex(0);
        vistaIngreso.combo_contextura.setSelectedIndex(0);
        
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
}