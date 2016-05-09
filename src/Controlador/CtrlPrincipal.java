package Controlador;

import Vista.S0_Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
