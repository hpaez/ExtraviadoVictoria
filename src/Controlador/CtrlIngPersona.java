package Controlador;

import Modelo.Extraviado;
import Modelo.Persona;
import Vista.S0_Principal;
import Vista.S1_IngresarExtraviado;
import Vista.S8_IngresarPersona;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

/**
 *
 * @author erik
 */
public class CtrlIngPersona implements ActionListener, KeyListener {

    private S8_IngresarPersona vistaPersona;
    private CtrlIngPersona ctrlPersona;
    private Persona persona;
    private Validador validar;

    public CtrlIngPersona(S8_IngresarPersona vistaPersona, Persona persona) {
        this.vistaPersona = vistaPersona;

        //action listener
        this.vistaPersona.btn_siguiente.addActionListener(this);
        this.vistaPersona.btn_limpiar.addActionListener(this);
        this.vistaPersona.btn_volver.addActionListener(this);

        //key listeners
        this.vistaPersona.txt_rut.addKeyListener(this);
        this.vistaPersona.txt_nombres.addKeyListener(this);
        this.vistaPersona.txt_apellidos.addKeyListener(this);
        this.vistaPersona.txt_fijo.addKeyListener(this);
        this.vistaPersona.txt_movil.addKeyListener(this);
        this.vistaPersona.txt_email.addKeyListener(this);
        this.vistaPersona.txt_direccion.addKeyListener(this);
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
        if (vistaPersona.btn_siguiente == e.getSource()) {
            try {
                if (!vistaPersona.txt_rut.getText().trim().equals("")
                        && !vistaPersona.txt_nombres.getText().trim().equals("")
                        && !vistaPersona.txt_apellidos.getText().trim().equals("")
                        && !vistaPersona.txt_direccion.getText().trim().equals("")
                        && (!vistaPersona.txt_fijo.getText().trim().equals("")
                        || !vistaPersona.txt_movil.getText().trim().equals(""))) {
                    if (validar.validarRut(vistaPersona.txt_rut.getText())) {
                        int p = JOptionPane.showConfirmDialog(null, "¿Desea pasar a la siguente pantalla?", "Advertencia", JOptionPane.YES_NO_OPTION);
                        if (p == 0) {
                            String rut = validar.formatear(vistaPersona.txt_rut.getText());
                            String nombre = vistaPersona.txt_nombres.getText().trim();
                            String apellido = vistaPersona.txt_apellidos.getText();
                            String fijo = vistaPersona.txt_fijo.getText();
                            String movil = vistaPersona.txt_movil.getText();
                            String correo = vistaPersona.txt_email.getText();
                            String direc = vistaPersona.txt_direccion.getText();

                            Persona persona = new Persona(rut, nombre, apellido, fijo, movil, correo, direc);

                            Extraviado extraviado = new Extraviado();

                            S1_IngresarExtraviado vistaExtraviado = new S1_IngresarExtraviado();
                            CtrlIngExtraviado ctrlExtraviado = new CtrlIngExtraviado(vistaExtraviado, extraviado, persona) {
                            };

                            vistaPersona.dispose();

                            ctrlExtraviado.iniciarExtraviado();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El rut ingresado es incorrecto.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Hay campos que no fueron ingresados.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else if (vistaPersona.btn_limpiar == e.getSource()) {
            try {
                int p = JOptionPane.showConfirmDialog(null, "¿Desea limpiar todos los datos ingresado?", "Advertencia", JOptionPane.YES_NO_OPTION);
                if (p == 0) {
                    limpiarCampos();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else if (vistaPersona.btn_volver == e.getSource()) {
            try {
                int p = JOptionPane.showConfirmDialog(null, "¿Desea volver a la pantalla principal?", "Advertencia", JOptionPane.YES_NO_OPTION);
                if (p == 0) {
                    S0_Principal vistaPrincipal = new S0_Principal();
                    CtrlPrincipal ctrlPrincipal = new CtrlPrincipal(vistaPrincipal) {
                    };
                    ctrlPrincipal.iniciarPrincipal();
                    vistaPersona.setVisible(false);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //solo numeros para campo telefono y movil
        if (vistaPersona.txt_fijo == e.getSource() || vistaPersona.txt_movil == e.getSource()) {
            if (!(Character.isDigit(e.getKeyChar()))) {
                e.consume();
            }
        }
        //limite de campo rut
        if (vistaPersona.txt_rut.getText().trim().length() == 12) {
            e.consume();
        }
        //limite de campo nombre
        if (vistaPersona.txt_nombres.getText().trim().length() == 20) {
            e.consume();
        }
        //limite de campo apellido
        if (vistaPersona.txt_apellidos.getText().trim().length() == 30) {
            e.consume();
        }
        //limite de campo telefono fijo
        if (vistaPersona.txt_fijo.getText().trim().length() == 15) {
            e.consume();
        }
        //limite de campo telefono movil
        if (vistaPersona.txt_movil.getText().trim().length() == 15) {
            e.consume();
        }
        //limite de campo telefono email
        if (vistaPersona.txt_email.getText().trim().length() == 90) {
            e.consume();
        }
        //limite de campo telefono direccion
        if (vistaPersona.txt_direccion.getText().trim().length() == 90) {
            e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        try {
        } catch (Exception ex) {
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        try {
        } catch (Exception ex) {
        }
    }

    public void limpiarCampos() {
        /*datos solicitante*/
        vistaPersona.txt_rut.setText("");
        vistaPersona.txt_nombres.setText("");
        vistaPersona.txt_apellidos.setText("");
        vistaPersona.txt_fijo.setText("");
        vistaPersona.txt_movil.setText("");
        vistaPersona.txt_email.setText("");
        vistaPersona.txt_direccion.setText("");

        vistaPersona.txt_rut.requestFocus();
    }

}
