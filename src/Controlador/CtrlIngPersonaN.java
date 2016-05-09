package Controlador;

import Modelo.Extraviado;
import Modelo.PersonaNatural;
import Vista.S1_IngresarExtraviado;
import Vista.S8_IngresarNatural;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author erik
 */
public class CtrlIngPersonaN implements ActionListener,KeyListener {
    S8_IngresarNatural vistaPersona;
    PersonaNatural persona;
    
    public CtrlIngPersonaN(S8_IngresarNatural vistaPersona, PersonaNatural persona) {
        this.vistaPersona = vistaPersona;
        this.persona = persona;
        this.vistaPersona.btn_guardar.addActionListener(this);
        this.vistaPersona.btn_limpiar.addActionListener(this);
        this.vistaPersona.btn_cancelar.addActionListener(this);
        
        //key listeners
        this.vistaPersona.txt_telefonoSolicitante.addKeyListener(this);
        this.vistaPersona.txt_movilSolicitante.addKeyListener(this);
        
    }
    
    public void Iniciar() {
        
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        //solo numeros para campo telefono y movil
        try{
            if (vistaPersona.txt_telefonoSolicitante == e.getSource() 
                    || vistaPersona.txt_movilSolicitante == e.getSource()) {
            try{
                if (!(Character.isDigit(e.getKeyChar())))
                e.consume();        
            }catch(Exception ex){
                //
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
            
        }catch(Exception ex){
            
        }    
    }

    @Override
    public void keyReleased(KeyEvent e) {
        try {
            
        }catch(Exception ex){
            
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            
        }catch(Exception ex){
            
        }
    }
    
    
    
}
