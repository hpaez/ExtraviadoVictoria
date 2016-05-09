package Modelo;

import Controlador.CtrlIngPersona;
import Vista.S8_IngresarPersona;
import javax.swing.JOptionPane;

/**
 *
 * @author erik
 */
public class Persona {
    private S8_IngresarPersona vistaPersona;
    private CtrlIngPersona controladorPersona;
    
    public void ingresarPersona(PersonaVO personavo) {
        PersonaDAO personadao;
        if(!vistaPersona.txt_rut.getText().trim().equals("") && !vistaPersona.txt_nombres.getText().trim().equals("") && !vistaPersona.txt_apellidos.getText().trim().equals("") && !vistaPersona.txt_direccion.getText().trim().equals("") && (!vistaPersona.txt_fijo.getText().trim().equals("") || !vistaPersona.txt_movil.getText().trim().equals(""))){
            if(validarRut(vistaPersona.txt_rut.getText()) == true){
                personadao = new PersonaDAO();
                personadao.insertarPersona(personavo);
            } else {
                JOptionPane.showMessageDialog(null, "El rut ingresado es incorrecto.","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hay campos que no fueron ingresados.","Advertencia",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void limpiarCampos(){     
        /*datos solicitante*/
        vistaPersona.txt_rut.setText("");
        vistaPersona.txt_nombres.setText("");
        vistaPersona.txt_apellidos.setText("");
        vistaPersona.txt_fijo.setText("");
        vistaPersona.txt_movil.setText("");
        vistaPersona.txt_email.setText("");
    }
    
    public static boolean validarRut(String rut) {
        boolean validacion = false;
        try {
            rut = rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }
        } catch(Exception e) {
        }
        return validacion;
    }
}