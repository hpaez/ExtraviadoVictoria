package Vista;

import Controlador.CtrlIngExtraviado;
import Modelo.Extraviado;

public class main {

    public static void main(String[] args) {
        CtrlIngExtraviado _controlIngExtra = new CtrlIngExtraviado();
        Extraviado extraviado = new Extraviado();
        S1_IngresarExtraviado ingresarExtraviado = new S1_IngresarExtraviado();
        ingresarExtraviado.setVisible(true);
        
    }
    
}
