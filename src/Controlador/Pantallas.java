package Controlador;

import Vista.S0_Principal;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Pantallas {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        S0_Principal ven_principal = new S0_Principal();

        CtrlPrincipal controlador = new CtrlPrincipal(ven_principal) {
        };

        controlador.iniciarPrincipal();
    }

}
