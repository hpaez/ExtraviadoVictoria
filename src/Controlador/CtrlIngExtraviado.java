/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Extraviado;
import Vista.S1_IngresarExtraviado;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author DerKow
 */
public class CtrlIngExtraviado implements ActionListener{
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
    }
    
    public void Iniciar() {
        vistaIngreso.setTitle("Ingresar Extraviado - Sistema de Búsqueda de Extraviado");
        vistaIngreso.pack();
        vistaIngreso.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vistaIngreso.setLocationRelativeTo(null);
        vistaIngreso.setVisible(true);
        vistaIngreso.setResizable(false);
        extraviado.habilitarExtraviado(false);
    }
    
    public void actionPerformed(ActionEvent e) {
        if(vistaIngreso.btn_ingresar == e.getSource()) {
            try {
                extraviado.ingresarExtraviado();
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else {
            try {
                extraviado.limpiarExtraviado();
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        
        if(vistaIngreso.btn_limpiar == e.getSource()) {
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
        }
        if (vistaIngreso.radio_pasaporte.isSelected()) {
            extraviado.habilitarExtraviado(true);
            vistaIngreso.txt_radioOption.requestFocus();
        }
        if (vistaIngreso.radio_noAplica.isSelected()) {
            extraviado.habilitarExtraviado(false);
        }
        
    }

}