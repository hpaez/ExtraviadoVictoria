package Modelo;

import Datos.PersonaVO;
import java.util.ArrayList;

/**
 *
 * @author erik
 */
public class Persona {

    public static void setPersona(Persona persona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private String rut;
    private String nombres;
    private String apellidos;
    private String fijo;
    private String movil;
    private String email;
    private String direccion;
    public static ArrayList<Persona> persona = new ArrayList<>();

    public Persona() {
    }

    public Persona(String rut, String nombres, String apellidos, String fijo, String movil, String email, String direccion) {
        this.rut = rut;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fijo = fijo;
        this.movil = movil;
        this.email = email;
        this.direccion = direccion;
        
        persona.add(this);
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

    public String getFijo() {
        return fijo;
    }

    public void setFijo(String fijo) {
        this.fijo = fijo;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
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

    public static ArrayList<Persona> getPersona() {
        return persona;
    }

    public static void setPersona(ArrayList<Persona> persona) {
        Persona.persona = persona;
    }
    
    

}


