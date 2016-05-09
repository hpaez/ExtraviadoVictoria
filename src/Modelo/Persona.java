package Modelo;

/**
 *
 * @author erik
 */
public class Persona {
    public void ingresarPersona(String rut, String nombre, String apellido, String fijo, String movil, String email, String direccion) {
        PersonaVO personavo = new PersonaVO();
        personavo.setId_persona(rut);
        personavo.setNombre_per(nombre);
        personavo.setApellido_per(apellido);
        personavo.setFijo_per(fijo);
        personavo.setMovil_per(movil);
        personavo.setCorreo_per(email);
        personavo.setDireccion_per(direccion);
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