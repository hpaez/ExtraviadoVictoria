package Modelo;

import Datos.PersonaVO;

/**
 *
 * @author erik
 */
public class Persona {
    private String rut;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String telefono_movil;
    private String email;
    private String direccion;

    public Persona() {
    }

    public Persona(String rut, String nombres, String apellidos, String telefono, String telefono_movil, String email, String direccion) {
        this.rut = rut;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.telefono_movil = telefono_movil;
        this.email = email;
        this.direccion = direccion;
    }
    
    public String getRut() {
        return rut;
    }

    public void setRut(String Rut) {
        this.rut = Rut;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono_movil() {
        return telefono_movil;
    }

    public void setTelefono_movil(String telefono_movil) {
        this.telefono_movil = telefono_movil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    // before
//    public void ingresarPersona(String rut, String nombre, String apellido, String fijo, String movil, String email, String direccion) {
//        PersonaVO personavo = new PersonaVO();
//        personavo.setId_persona(rut);
//        personavo.setNombre_per(nombre);
//        personavo.setApellido_per(apellido);
//        personavo.setFijo_per(fijo);
//        personavo.setMovil_per(movil);
//        personavo.setCorreo_per(email);
//        personavo.setDireccion_per(direccion);
//    }
}