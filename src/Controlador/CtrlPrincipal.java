package Controlador;

import Vista.S0_Principal;
import Vista.S8_IngresarPersona;
import Controlador.Pantallas;
import Datos.CasoDAO;
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
    S0_Principal ventanaPrincipal;
    
    public CtrlPrincipal(S0_Principal vistaPrincipal) {
        this.ventanaPrincipal = vistaPrincipal;
        this.ventanaPrincipal.btn_ingresarExtraviado.addActionListener(this);
        
        this.ventanaPrincipal.btn_modificar.addActionListener(this);
    }
    
    public void iniciarPrincipal() {
        ventanaPrincipal.setTitle("Principal - Sistema de Búsqueda de Extraviado");
        ventanaPrincipal.pack();
        ventanaPrincipal.setLocationRelativeTo(null);
        ventanaPrincipal.setVisible(true);
        ventanaPrincipal.setResizable(false);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(ventanaPrincipal.btn_ingresarExtraviado == e.getSource()){           
            Persona persona = new Persona();
            S8_IngresarPersona vistaPersona = new S8_IngresarPersona();
            CtrlIngPersona ctrlPersona = new CtrlIngPersona(vistaPersona, persona) {};
            ventanaPrincipal.setVisible(false);
            ventanaPrincipal.dispose();
            ctrlPersona.iniciarPersona();
        }
        if (ventanaPrincipal.btn_modificar == e.getSource()) {
            CasoDAO casodao = new CasoDAO();
            int gato = casodao.verificarCasoExtraviado("No aplica");
            System.out.println(gato);
            System.out.println(".");
        }
        
    }
}
