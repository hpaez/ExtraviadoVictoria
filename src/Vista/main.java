package Vista;

import Vista.S0_Principal;
import Controlador.CtrlPrincipal;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        S0_Principal vista = new S0_Principal();
        CtrlPrincipal controlador = new CtrlPrincipal(vista) {};
        controlador.Iniciar();
    }
    
}
