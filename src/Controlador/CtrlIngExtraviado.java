package Controlador;

import Modelo.Extraviado;
import Modelo.ExtraviadoVO;
import Modelo.ExtraviadoDAO;
import Vista.S0_Principal;
import Vista.S1_IngresarExtraviado;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CtrlIngExtraviado implements ActionListener,KeyListener {
    private S1_IngresarExtraviado vistaIngreso;
    private S0_Principal vistaPrincipal;
    private CtrlIngExtraviado controladorExtraviado;
    private Extraviado extraviado;
    
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
        habilitarExtraviado(false);
        vistaIngreso.radio_noAplica.setSelected(true);
        
    }
    
    public void actionPerformed(ActionEvent e) {
        if(vistaIngreso.btn_ingresar == e.getSource()) {
            try {
                ExtraviadoVO extraviadovo=new ExtraviadoVO();
                //extraviadovo.setId_persona(vistaIngreso.txt_rutSolicitante.getText());
                extraviadovo.setIdentificacion_ex(vistaIngreso.txt_radioOption.getText());
                extraviadovo.setNombre_ex(vistaIngreso.txt_nombre.getText());
                extraviadovo.setApellido_ex(vistaIngreso.txt_apellidos.getText());
                extraviadovo.setCabello_ex(vistaIngreso.combo_cPelo.getSelectedItem().toString());
                extraviadovo.setPiel_ex(vistaIngreso.combo_cPiel.getSelectedItem().toString());
                extraviadovo.setOjos_ex(vistaIngreso.combo_cOjos.getSelectedItem().toString());
                extraviadovo.setMedicion_ex(Double.parseDouble(vistaIngreso.txt_altura.getText()));
                extraviadovo.setContextura_ex("");
                extraviadovo.setPeso_ex(Integer.parseInt("0"));
                extraviadovo.setComentario_ex(vistaIngreso.textarea_comentario.getText());
                ingresarExtraviado(extraviadovo);
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else if(vistaIngreso.btn_limpiar == e.getSource()) {
            try {
               limpiarCampos();
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        
        /*habilita campo de texto rut,pasaporte,aplica al momento de seleccionar uno,sino queda desabilitado*/
        if (vistaIngreso.radio_rut.isSelected()) {
            habilitarExtraviado(true);
            vistaIngreso.txt_radioOption.requestFocus();
            vistaIngreso.txt_radioOption.setText("");
        }
        if (vistaIngreso.radio_pasaporte.isSelected()) {
            habilitarExtraviado(true);
            vistaIngreso.txt_radioOption.requestFocus();
            vistaIngreso.txt_radioOption.setText("");
        }
        if (vistaIngreso.radio_noAplica.isSelected()) {
            habilitarExtraviado(false);
            vistaIngreso.txt_radioOption.setText("");
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
