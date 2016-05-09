/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Extraviado;
import Modelo.ExtraviadoVO;
import Modelo.ExtraviadoDAO;
import Vista.S1_IngresarExtraviado;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author DerKow
 */
public class CtrlIngExtraviado implements ActionListener,KeyListener {
    S1_IngresarExtraviado vistaIngreso;
    Extraviado extraviado;
    
    public CtrlIngExtraviado(S1_IngresarExtraviado vistaIngreso, Extraviado modeloIngreso) {
        this.vistaIngreso = vistaIngreso;
        this.extraviado = modeloIngreso;
        this.vistaIngreso.btn_ingresar.addActionListener(this);
        this.vistaIngreso.btn_limpiar.addActionListener(this);
        this.vistaIngreso.radio_noAplica.addActionListener(this);
        this.vistaIngreso.radio_rut.addActionListener(this);
        this.vistaIngreso.radio_pasaporte.addActionListener(this);
        //key listeners
        this.vistaIngreso.txt_telefonoSolicitante.addKeyListener(this);
        this.vistaIngreso.txt_movilSolicitante.addKeyListener(this);
    }
    
    public void Iniciar() {
        vistaIngreso.setTitle("Ingresar Extraviado - Sistema de Búsqueda de Extraviado");
        vistaIngreso.pack();
        vistaIngreso.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vistaIngreso.setLocationRelativeTo(null);
        vistaIngreso.setVisible(true);
        vistaIngreso.setResizable(false);
        extraviado.habilitarExtraviado(false);
        vistaIngreso.radio_noAplica.setSelected(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if(vistaIngreso.btn_ingresar == e.getSource()) {
            try {
                ExtraviadoVO extraviadovo=new ExtraviadoVO();
                extraviadovo.setId_persona(vistaIngreso.txt_rutSolicitante.getText());
                extraviadovo.setIdentificacion_ex(vistaIngreso.txt_radioOption.getText());
                extraviadovo.setNombre_ex(vistaIngreso.txt_nombreExtraviado.getText());
                extraviadovo.setApellido_ex(vistaIngreso.txt_apellidoP_Extraviado.getText() + " " + vistaIngreso.txt_apellidoM_Extraviado.getText());
                extraviadovo.setCabello_ex(vistaIngreso.txt_colorPelo.getText());
                extraviadovo.setPiel_ex(vistaIngreso.txt_colorPiel.getText());
                extraviadovo.setOjos_ex(vistaIngreso.txt_colorOjos.getText());
                extraviadovo.setMedicion_ex(Double.parseDouble(vistaIngreso.txt_altura.getText()));
                extraviadovo.setContextura_ex("");
                extraviadovo.setPeso_ex(Integer.parseInt("0"));
                extraviadovo.setComentario_ex(vistaIngreso.textarea_comentario.getText());
                extraviado.ingresarExtraviado(extraviadovo);
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else if(vistaIngreso.btn_limpiar == e.getSource()) {
            try {
               extraviado.limpiarCampos();
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        
        /*habilita campo de texto rut,pasaporte,aplica al momento de seleccionar uno,sino queda desabilitado*/
        if (vistaIngreso.radio_rut.isSelected()) {
            extraviado.habilitarExtraviado(true);
            vistaIngreso.txt_radioOption.requestFocus();
            vistaIngreso.txt_radioOption.setText("");
        }
        if (vistaIngreso.radio_pasaporte.isSelected()) {
            extraviado.habilitarExtraviado(true);
            vistaIngreso.txt_radioOption.requestFocus();
            vistaIngreso.txt_radioOption.setText("");
        }
        if (vistaIngreso.radio_noAplica.isSelected()) {
            extraviado.habilitarExtraviado(false);
            vistaIngreso.txt_radioOption.setText("");
        }
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //solo numeros para campo telefono y movil
        try{
            if (vistaIngreso.txt_telefonoSolicitante == e.getSource() 
                    || vistaIngreso.txt_movilSolicitante == e.getSource()) {
                try{
                    if (!(Character.isDigit(e.getKeyChar())))
                    e.consume();        
                }catch(Exception ex){
                    //
                }
            }
        }catch (Exception ex){
            
        }    
        //limite de caracteres
//        if (_campo.length() == _limitecaracteres) {
//            e.consume();
//        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        try {
            
        }catch(Exception ex){
            
        }    
    }

    @Override
    public void keyReleased(KeyEvent e) {
        try {
            
        }catch(Exception ex){
            
        }
    }
}