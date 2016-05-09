package Vista;

import Modelo.Extraviado;
import Vista.S1_IngresarExtraviado;
import Controlador.CtrlIngExtraviado;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        Extraviado extraviado = new Extraviado();
        S1_IngresarExtraviado vista = new S1_IngresarExtraviado();
        CtrlIngExtraviado controlador = new CtrlIngExtraviado(vista, extraviado) {};
        controlador.Iniciar();
    }
    
}
