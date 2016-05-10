package Controlador;

import Vista.S0_Principal;
import Controlador.CtrlPrincipal;
import Modelo.Extraviado;
import Modelo.Persona;
import Vista.S0_Principal;
import Vista.S1_IngresarExtraviado;
import Vista.S8_IngresarPersona;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Pantallas {    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        S0_Principal ven_principal = new S0_Principal();
        S1_IngresarExtraviado ing_extraviado = new S1_IngresarExtraviado();
        S8_IngresarPersona ing_persona = new S8_IngresarPersona();
        
        CtrlPrincipal controlador = new CtrlPrincipal(ven_principal) {};
        
        
        controlador.iniciarPrincipal();
    }
    
}
