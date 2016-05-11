package Datos;

import Modelo.Conexion;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author DerKow
 */
public class PersonaDAO {
    Conexion conexion;
    
    public PersonaDAO() {
        conexion = new Conexion();
    }
    
    public boolean insertarPersona(PersonaVO persona) {
        boolean resultado = false;
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement("INSERT INTO persona VALUES (?,?,?,?,?,?,?)");
            ps.setString(1, persona.getId_persona());
            ps.setString(2, persona.getNombre_per());
            ps.setString(3, persona.getApellido_per());
            ps.setString(4, persona.getFijo_per());
            ps.setString(5, persona.getMovil_per());
            ps.setString(6, persona.getCorreo_per());
            ps.setString(7, persona.getDireccion_per());
            
            int numFilasAfectadas = ps.executeUpdate();
            ps.close();
            conexion.Desconectar();
            
            if(numFilasAfectadas>0){
                resultado = true;
            }
        } catch (Exception e) {
            resultado = false;
        }
        return resultado;
    }
    
    public boolean verificaPersona(String id) {
        boolean resultado = false;
        Connection accesoDB = conexion.getConexion();
        try {
            PreparedStatement ps = accesoDB.prepareStatement("SELECT * FROM persona WHERE IDPERSONA=?");
            ps.setString(1, id);
            
            int numFilasAfectadas = ps.executeUpdate();
            ps.close();
            conexion.Desconectar();
            
            if(numFilasAfectadas>0){
                resultado = true;
            }
        } catch (Exception e) {
                resultado = false;
        }
        return resultado;
    }
    
    public ArrayList<PersonaVO> listPersona() {
        ArrayList listaPersona = new ArrayList();
        PersonaVO persona;
        try {
            Connection acceDB = conexion.getConexion();
            PreparedStatement ps = acceDB.prepareStatement("SELECT * FROM persona");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                persona = new PersonaVO();
                persona.setId_persona(rs.getString(1));
                persona.setNombre_per(rs.getString(2));
                persona.setApellido_per(rs.getString(3));
                persona.setFijo_per(rs.getString(4));
                persona.setMovil_per(rs.getString(5));
                persona.setCorreo_per(rs.getString(6));
                persona.setDireccion_per(rs.getString(7));
                listaPersona.add(persona);
            }
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "No se pudo actualizar","Advertencia",JOptionPane.WARNING_MESSAGE);
        }
        return listaPersona;
    }
    
    public boolean editarPersona(PersonaVO persona) {
        boolean resultado = false;
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement("UPDATE persona SET NOMBREPERSONA=?, APELLIDOPERSONA=?, TELEFONOFIJOPERSONA=?, TELEFONOMOVILPERSONA=?, CORREOPERSONA=?, DIRECCIONPERSONA=? WHERE IDPERSONA=?");
            ps.setString(1, persona.getNombre_per());
            ps.setString(2, persona.getApellido_per());
            ps.setString(3, persona.getFijo_per());
            ps.setString(4, persona.getMovil_per());
            ps.setString(5, persona.getCorreo_per());
            ps.setString(6, persona.getDireccion_per());
            ps.setString(6, persona.getId_persona());
            int numFilasAfectadas = ps.executeUpdate();
            ps.close();
            conexion.Desconectar();
            
            if(numFilasAfectadas>0){
                resultado = true;
            }
        } catch (Exception e) {
            resultado = false;
        }
        return resultado;  
    }
}