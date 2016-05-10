package Controlador;

import Modelo.Extraviado;
import Modelo.ExtraviadoDAO;
import Modelo.ExtraviadoVO;
import Vista.S1_IngresarExtraviado;
import Vista.S8_IngresarPersona;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CtrlIngExtraviado implements ActionListener,KeyListener {
    private S1_IngresarExtraviado vistaExtraviado = null;
    private S8_IngresarPersona vistaPersona = null;
    private Extraviado modeloExtraviado = null;
    
    public CtrlIngExtraviado(S1_IngresarExtraviado vistaExtraviado, Extraviado modeloIngreso) {
        this.modeloExtraviado = modeloIngreso;
        this.vistaExtraviado    = vistaExtraviado;
        
        this.vistaExtraviado.btn_ingresar.addActionListener(this);
        this.vistaExtraviado.btn_limpiar.addActionListener(this);
        
        this.vistaExtraviado.radio_rut.addActionListener(this);
        this.vistaExtraviado.radio_pasaporte.addActionListener(this);
        this.vistaExtraviado.radio_noAplica.addActionListener(this);
    }
    
    public void iniciarExtraviado() {
        vistaExtraviado.setTitle("Ingresar Extraviado - Sistema de Búsqueda de Extraviado");
        vistaExtraviado.pack();
        vistaExtraviado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vistaExtraviado.setLocationRelativeTo(null);
        vistaExtraviado.setVisible(true);
        vistaExtraviado.setResizable(false);
        vistaExtraviado.radio_noAplica.setSelected(true);
        habilitarExtraviado(false);
    }
    
    public void actionPerformed(ActionEvent e) {
        if(vistaExtraviado.btn_ingresar == e.getSource()) {
            try {
                if(vistaExtraviado.buttonGroup1.getSelection() == null || !vistaExtraviado.txt_nombre.getText().trim().equals("") || !vistaExtraviado.txt_apellidos.getText().trim().equals("") || vistaExtraviado.combo_cOjos.getSelectedIndex() > 0 || vistaExtraviado.combo_cPelo.getSelectedIndex() > 0 || vistaExtraviado.combo_cPiel.getSelectedIndex() > 0 || vistaExtraviado.combo_contextura.getSelectedIndex() > 0){
                    if(vistaExtraviado.radio_rut.isSelected() == true && !vistaExtraviado.txt_radioOption.getText().trim().equals("")){
                        if(validarRut(vistaExtraviado.txt_radioOption.getText())){
                            ExtraviadoVO extraviadovo=new ExtraviadoVO();
                            extraviadovo.setId_persona(vistaPersona.txt_rut.getText());
                            extraviadovo.setIdentificacion_ex(vistaExtraviado.txt_radioOption.getText());
                            extraviadovo.setNombre_ex(vistaExtraviado.txt_nombre.getText());
                            extraviadovo.setApellido_ex(vistaExtraviado.txt_apellidos.getText());
                            extraviadovo.setCabello_ex(vistaExtraviado.combo_cPelo.getSelectedIndex());
                            extraviadovo.setPiel_ex(vistaExtraviado.combo_cPiel.getSelectedIndex());
                            extraviadovo.setOjos_ex(vistaExtraviado.combo_cOjos.getSelectedIndex());
                            extraviadovo.setMedicion_ex(Double.parseDouble(vistaExtraviado.txt_altura.getText()));
                            extraviadovo.setContextura_ex(vistaExtraviado.combo_contextura.getSelectedIndex());
                            extraviadovo.setPeso_ex(Integer.parseInt(vistaExtraviado.txt_peso.getText()));
                            extraviadovo.setComentario_ex(vistaExtraviado.textarea_comentario.getText());
                            ingresarExtraviado(extraviadovo);
                        } else {
                            JOptionPane.showMessageDialog(null, "Debe ingresar un rut válido.","Advertencia",JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe ingresar un rut.","Advertencia",JOptionPane.WARNING_MESSAGE);
                    }
                    
                    if(vistaExtraviado.radio_pasaporte.isSelected() == true && !vistaExtraviado.txt_radioOption.getText().trim().equals("")){
                        ExtraviadoVO extraviadovo=new ExtraviadoVO();
                        extraviadovo.setId_persona(vistaPersona.txt_rut.getText());
                        extraviadovo.setIdentificacion_ex(vistaExtraviado.txt_radioOption.getText());
                        extraviadovo.setNombre_ex(vistaExtraviado.txt_nombre.getText());
                        extraviadovo.setApellido_ex(vistaExtraviado.txt_apellidos.getText());
                        extraviadovo.setCabello_ex(vistaExtraviado.combo_cPelo.getSelectedIndex());
                        extraviadovo.setPiel_ex(vistaExtraviado.combo_cPiel.getSelectedIndex());
                        extraviadovo.setOjos_ex(vistaExtraviado.combo_cOjos.getSelectedIndex());
                        extraviadovo.setMedicion_ex(Double.parseDouble(vistaExtraviado.txt_altura.getText()));
                        extraviadovo.setContextura_ex(vistaExtraviado.combo_contextura.getSelectedIndex());
                        extraviadovo.setPeso_ex(Integer.parseInt(vistaExtraviado.txt_peso.getText()));
                        extraviadovo.setComentario_ex(vistaExtraviado.textarea_comentario.getText());
                        ingresarExtraviado(extraviadovo);
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe escribir su pasaporte","Advertencia",JOptionPane.WARNING_MESSAGE);
                    }
                    
                    if(vistaExtraviado.radio_noAplica.isSelected() == true){
                        ExtraviadoVO extraviadovo=new ExtraviadoVO();
                        extraviadovo.setId_persona(vistaPersona.txt_rut.getText());
                        extraviadovo.setIdentificacion_ex(vistaExtraviado.txt_radioOption.getText());
                        extraviadovo.setNombre_ex(vistaExtraviado.txt_nombre.getText());
                        extraviadovo.setApellido_ex(vistaExtraviado.txt_apellidos.getText());
                        extraviadovo.setCabello_ex(vistaExtraviado.combo_cPelo.getSelectedIndex());
                        extraviadovo.setPiel_ex(vistaExtraviado.combo_cPiel.getSelectedIndex());
                        extraviadovo.setOjos_ex(vistaExtraviado.combo_cOjos.getSelectedIndex());
                        extraviadovo.setMedicion_ex(Double.parseDouble(vistaExtraviado.txt_altura.getText()));
                        extraviadovo.setContextura_ex(vistaExtraviado.combo_contextura.getSelectedIndex());
                        extraviadovo.setPeso_ex(Integer.parseInt(vistaExtraviado.txt_peso.getText()));
                        extraviadovo.setComentario_ex(vistaExtraviado.textarea_comentario.getText());
                        ingresarExtraviado(extraviadovo);
                    } else {
                        JOptionPane.showMessageDialog(null, "Hubo un problema, debe seleccionar su identificador.","Advertencia",JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Hay campos que no fueron ingresados.","Advertencia",JOptionPane.WARNING_MESSAGE);
                }
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else if(vistaExtraviado.btn_limpiar == e.getSource()) {
            try {
               limpiarCampos();
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        
        /*habilita campo de texto rut,pasaporte,aplica al momento de seleccionar uno,sino queda desabilitado*/
        if (vistaExtraviado.radio_rut.isSelected()) {
            habilitarExtraviado(true);
            vistaExtraviado.txt_radioOption.requestFocus();
            vistaExtraviado.txt_radioOption.setText("");
        }
        if (vistaExtraviado.radio_pasaporte.isSelected()) {
            habilitarExtraviado(true);
            vistaExtraviado.txt_radioOption.requestFocus();
            vistaExtraviado.txt_radioOption.setText("");
        }
        if (vistaExtraviado.radio_noAplica.isSelected()) {
            habilitarExtraviado(false);
            vistaExtraviado.txt_radioOption.setText("");
        }
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        try {
            
        }catch(Exception ex) {
            
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        try {
            
        }catch(Exception ex) {
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        try {
            
        }catch(Exception ex) {
            
        }
    }
    
    public void ingresarExtraviado(ExtraviadoVO extraviadovo) {
        ExtraviadoDAO extraviadodao;
        extraviadodao = new ExtraviadoDAO();
        extraviadodao.insertarExtraviado(extraviadovo);
    }

    
    /*limpia todos los campos del formulario*/
    public void limpiarCampos(){      
        /*datos extraviado*/
        habilitarExtraviado(false);
        
        vistaExtraviado.radio_noAplica.setSelected(true);
        vistaExtraviado.txt_radioOption.setText("");
        vistaExtraviado.txt_nombre.setText("");
        vistaExtraviado.txt_apellidos.setText("");
        
        vistaExtraviado.combo_cOjos.setSelectedIndex(0);
        vistaExtraviado.combo_cPelo.setSelectedIndex(0);
        vistaExtraviado.combo_cPiel.setSelectedIndex(0);
        vistaExtraviado.combo_contextura.setSelectedIndex(0);
        
        vistaExtraviado.txt_altura.setText("");
        vistaExtraviado.textarea_comentario.setText("");
        
    }
    
    public void habilitarExtraviado(boolean sw) {
        vistaExtraviado.txt_radioOption.setEnabled(sw);
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
