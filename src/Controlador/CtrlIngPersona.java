package Controlador;

import Modelo.Extraviado;
import Modelo.PersonaVO;
import Modelo.Persona;
import Modelo.PersonaDAO;
import Vista.S0_Principal;
import Vista.S1_IngresarExtraviado;
import Vista.S8_IngresarPersona;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;

/**
 *
 * @author erik
 */
public class CtrlIngPersona implements ActionListener,KeyListener {
    private S8_IngresarPersona vistaPersona;
    private Persona persona;
    CtrlIngPersona ctrlPersona;
    
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
    
    public void iniciarPersona() {
        vistaPersona.setTitle("Ingresar Persona - Sistema de Búsqueda de Extraviado");
        vistaPersona.pack();
        vistaPersona.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        vistaPersona.setLocationRelativeTo(null);
        vistaPersona.setVisible(true);
        vistaPersona.setResizable(false);
        
        vistaPersona.setDefaultCloseOperation(0);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(vistaPersona.btn_guardar == e.getSource()) {
            try {
                if(!vistaPersona.txt_rut.getText().trim().equals("") && !vistaPersona.txt_nombres.getText().trim().equals("") && !vistaPersona.txt_apellidos.getText().trim().equals("") && !vistaPersona.txt_direccion.getText().trim().equals("") && (!vistaPersona.txt_fijo.getText().trim().equals("") || !vistaPersona.txt_movil.getText().trim().equals(""))){
                    if(validarRut(vistaPersona.txt_rut.getText()) == true){
                            PersonaVO personavo=new PersonaVO();
                            personavo.setId_persona(vistaPersona.txt_rut.getText());
                            personavo.setNombre_per(vistaPersona.txt_nombres.getText());
                            personavo.setApellido_per(vistaPersona.txt_apellidos.getText());
                            personavo.setFijo_per(vistaPersona.txt_fijo.getText());
                            personavo.setMovil_per(vistaPersona.txt_movil.getText());
                            personavo.setCorreo_per(vistaPersona.txt_email.getText());
                            personavo.setDireccion_per(vistaPersona.txt_direccion.getText());
                            
                            if (ingresarPersona(personavo)) {
                                Extraviado extraviado = new Extraviado();
                                S1_IngresarExtraviado vistaExtraviado = new S1_IngresarExtraviado();
                                CtrlIngExtraviado ctrlExtraviado = new CtrlIngExtraviado(vistaExtraviado, extraviado) {};

                                vistaPersona.setVisible(false);
                                ctrlExtraviado.iniciarExtraviado();
                            }else{
                                limpiarCampos();
                            }
                    } else {
                        JOptionPane.showMessageDialog(null, "El rut ingresado es incorrecto.","Advertencia",JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Hay campos que no fueron ingresados.","Advertencia",JOptionPane.WARNING_MESSAGE);
                }    
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else if(vistaPersona.btn_limpiar == e.getSource()) {
            try {
               limpiarCampos();
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else if(vistaPersona.btn_cancelar == e.getSource()) {
            try {
                S0_Principal vistaPrincipal = new S0_Principal();
                CtrlPrincipal ctrlPrincipal = new CtrlPrincipal(vistaPrincipal) {};
                ctrlPrincipal.iniciarPrincipal();
                vistaPersona.setVisible(false);
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
