package Controlador;

import Vista.S0_Principal;
import Vista.S8_IngresarPersona;
import Controlador.CtrlIngPersona;
import Modelo.Persona;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author erik
 */
public class CtrlPrincipal implements ActionListener {
    S0_Principal vistaPrincipal;
    
    public CtrlPrincipal(S0_Principal vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;
        this.vistaPrincipal.btn_ingresarExtraviado.addActionListener(this);
    }
    
    public void Iniciar() {
        vistaPrincipal.setTitle("Sistema de Búsqueda de Extraviado");
        vistaPrincipal.pack();
        vistaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vistaPrincipal.setLocationRelativeTo(null);
        vistaPrincipal.setVisible(true);
        vistaPrincipal.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(vistaPrincipal.btn_ingresarExtraviado == e.getSource()){
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch(Exception ee) {
                JOptionPane.showMessageDialog(null, ee);
            }
            
            Persona persona = new Persona();
            S8_IngresarPersona vista = new S8_IngresarPersona();
            CtrlIngPersona controlador = new CtrlIngPersona(vista, persona) {};
            controlador.Iniciar();
        }
    }
    
}
