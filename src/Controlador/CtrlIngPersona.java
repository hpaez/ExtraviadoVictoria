package Controlador;

import Modelo.Extraviado;
import Datos.PersonaVO;
import Modelo.Persona;
import Datos.PersonaDAO;
import Vista.S0_Principal;
import Vista.S1_IngresarExtraviado;
import Vista.S8_IngresarPersona;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author erik
 */
public class CtrlIngPersona implements ActionListener,KeyListener {
    private S8_IngresarPersona vistaPersona;
    public CtrlIngPersona ctrlPersona;
    public Persona persona;
    
    public CtrlIngPersona(S8_IngresarPersona vistaPersona, Persona persona) {
        this.vistaPersona = vistaPersona;
        
        //action listener
        this.vistaPersona.btn_siguiente.addActionListener(this);
        this.vistaPersona.btn_limpiar.addActionListener(this);
        this.vistaPersona.btn_volver.addActionListener(this);
        
        //key listeners
        this.vistaPersona.txt_fijo.addKeyListener(this);
        this.vistaPersona.txt_movil.addKeyListener(this);
        
    }
    
    public void iniciarPersona() {
        vistaPersona.setTitle("Ingresar Persona - Sistema de Búsqueda de Extraviado");
        vistaPersona.pack();
        vistaPersona.setLocationRelativeTo(null);
        vistaPersona.setVisible(true);
        vistaPersona.setResizable(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(vistaPersona.btn_siguiente == e.getSource()) {
            try {
                if(!vistaPersona.txt_rut.getText().trim().equals("") &&
                    !vistaPersona.txt_nombres.getText().trim().equals("") &&
                    !vistaPersona.txt_apellidos.getText().trim().equals("") &&
                    !vistaPersona.txt_direccion.getText().trim().equals("") &&
                    (!vistaPersona.txt_fijo.getText().trim().equals("") ||
                    !vistaPersona.txt_movil.getText().trim().equals(""))){
                    if(validarRut(vistaPersona.txt_rut.getText())){
                        int p = JOptionPane.showConfirmDialog(null, "¿Desea pasar a la siguente pantalla?", "Advertencia", JOptionPane.YES_NO_OPTION);
                        if (p == 0) {
                            String rut = CtrlIngExtraviado.formatear(vistaPersona.txt_rut.getText());
                            String nombre = vistaPersona.txt_nombres.getText().trim();
                            String apellido = vistaPersona.txt_apellidos.getText();
                            String fijo = vistaPersona.txt_fijo.getText();
                            String movil = vistaPersona.txt_movil.getText();
                            String correo = vistaPersona.txt_email.getText();
                            String direc = vistaPersona.txt_direccion.getText();
                            
                            Persona persona = new Persona(rut, nombre, apellido, fijo, movil, correo, direc);
                            
                            Extraviado extraviado = new Extraviado();
                            
                            S1_IngresarExtraviado vistaExtraviado = new S1_IngresarExtraviado();
                            CtrlIngExtraviado ctrlExtraviado = new CtrlIngExtraviado(vistaExtraviado, extraviado,persona) {};
                            
                            vistaPersona.dispose();
                            
                            ctrlExtraviado.iniciarExtraviado();
                        }
                    }else {
                        JOptionPane.showMessageDialog(null, "El rut ingresado es incorrecto.","Advertencia",JOptionPane.WARNING_MESSAGE);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Hay campos que no fueron ingresados.","Advertencia",JOptionPane.WARNING_MESSAGE);
                }    
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else if(vistaPersona.btn_limpiar == e.getSource()) {
            try {
                int p = JOptionPane.showConfirmDialog(null, "¿Desea limpiar todos los datos ingresado?", "Advertencia", JOptionPane.YES_NO_OPTION);
                if (p == 0) {
                    limpiarCampos();
                }
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else if(vistaPersona.btn_volver == e.getSource()) {
            try {
                int p = JOptionPane.showConfirmDialog(null, "¿Desea volver a la pantalla principal?", "Advertencia", JOptionPane.YES_NO_OPTION);
                if (p == 0) {
                    S0_Principal vistaPrincipal = new S0_Principal();
                    CtrlPrincipal ctrlPrincipal = new CtrlPrincipal(vistaPrincipal) {};
                    ctrlPrincipal.iniciarPrincipal();
                    vistaPersona.setVisible(false);
                }
                } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        //solo numeros para campo telefono y movil
        try{
            if (vistaPersona.txt_fijo == e.getSource() || vistaPersona.txt_movil == e.getSource()) {
                try{
                    if (!(Character.isDigit(e.getKeyChar()))){
                        e.consume();
                    }
                }catch(Exception ex){
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
    
    public boolean ingresarPersona(PersonaVO personavo) {
        boolean resp = false;
        PersonaDAO personadao = new PersonaDAO();
        if (personadao.insertarPersona(personavo)){
            JOptionPane.showMessageDialog(null, "Se ingreso la persona exitosamente.","Información",JOptionPane.INFORMATION_MESSAGE);
            resp = true;
        }else{
            JOptionPane.showMessageDialog(null, "No se pudo ingresar.","Advertencia",JOptionPane.WARNING_MESSAGE);
            resp = false;
        }
        return resp;
    }
    
    public void limpiarCampos(){     
        /*datos solicitante*/
        vistaPersona.txt_rut.setText("");
        vistaPersona.txt_nombres.setText("");
        vistaPersona.txt_apellidos.setText("");
        vistaPersona.txt_fijo.setText("");
        vistaPersona.txt_movil.setText("");
        vistaPersona.txt_email.setText("");
        vistaPersona.txt_direccion.setText("");
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
