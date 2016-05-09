package Controlador;

import Modelo.PersonaVO;
import Modelo.Persona;
import Vista.S8_IngresarPersona;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author erik
 */
public class CtrlIngPersona implements ActionListener,KeyListener {
    S8_IngresarPersona vistaPersona;
    Persona persona;
    
    public CtrlIngPersona(S8_IngresarPersona vistaPersona, Persona persona) {
        this.vistaPersona = vistaPersona;
        this.persona = persona;
        
        //action listener
        this.vistaPersona.btn_guardar.addActionListener(this);
        this.vistaPersona.btn_limpiar.addActionListener(this);
        this.vistaPersona.btn_cancelar.addActionListener(this);
        
        //key listeners
        this.vistaPersona.txt_fijo.addKeyListener(this);
        this.vistaPersona.txt_movil.addKeyListener(this);
        
    }
    
    public void Iniciar() {
        vistaPersona.setTitle("Ingresar Persona - Sistema de Búsqueda de Extraviado");
        vistaPersona.pack();
        vistaPersona.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vistaPersona.setLocationRelativeTo(null);
        vistaPersona.setVisible(true);
        vistaPersona.setResizable(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(vistaPersona.btn_guardar == e.getSource()) {
            try {
                PersonaVO personavo=new PersonaVO();
                personavo.setId_persona(vistaPersona.txt_rut.getText());
                personavo.setNombre_per(vistaPersona.txt_nombres.getText());
                personavo.setApellido_per(vistaPersona.txt_apellidos.getText());
                personavo.setFijo_per(vistaPersona.txt_fijo.getText());
                personavo.setMovil_per(vistaPersona.txt_movil.getText());
                personavo.setCorreo_per(vistaPersona.txt_email.getText());
                personavo.setDireccion_per(vistaPersona.txt_direccion.getText());
                persona.ingresarPersona(personavo);
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else if(vistaPersona.btn_limpiar == e.getSource()) {
            try {
               persona.limpiarCampos();
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else if(vistaPersona.btn_cancelar == e.getSource()) {
            
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        //solo numeros para campo telefono y movil
        try{
            if (vistaPersona.txt_fijo == e.getSource() 
                    || vistaPersona.txt_movil == e.getSource()) {
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
            
        }catch(Exception ex) {
            
        }    
    }

    @Override
    public void keyReleased(KeyEvent e) {
        try {
            
        }catch(Exception ex) {
            
        }
    }
}
