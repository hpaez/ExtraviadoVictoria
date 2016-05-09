package Modelo;

import Controlador.CtrlIngPersonaN;
import Vista.S8_IngresarNatural;

/**
 *
 * @author erik
 */
public class PersonaNatural {
    private S8_IngresarNatural vistaPersona;
    private CtrlIngPersonaN controladorPersona;
    
    public void limpiarCampos(){     
    
        /*datos solicitante*/
        vistaPersona.txt_rutSolicitante.setText("");
        vistaPersona.txt_nombreSolicitante.setText("");
        vistaPersona.txt_apellidoSolicitante.setText("");
        vistaPersona.txt_telefonoSolicitante.setText("");
        vistaPersona.txt_movilSolicitante.setText("");
        vistaPersona.txt_emailSolicitante.setText("");
        
    }
}
