/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author DerKow
 */
public class PersonaDAO {
    Conexion conexion;
    
    public PersonaDAO() {
        conexion = new Conexion();
    }
    
    public String insertarPersona(PersonaVO persona) {
        String rptRegistro = null;
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
                JOptionPane.showMessageDialog(null, "Se ingreso la persona exitosamente.","Información",JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo ingresar.");
        }
        return rptRegistro;
    }
    
    public PersonaVO verificaPersona(String id) {
        PersonaVO persona=null;
        Connection accesoDB = conexion.getConexion();
        try {
            PreparedStatement ps = accesoDB.prepareStatement("SELECT * FROM persona WHERE IDPERSONA=?");
            ps.setString(1, id);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
               persona = new PersonaVO();
               persona.setId_persona(rs.getString(1));
               persona.setNombre_per(rs.getString(2));
               persona.setApellido_per(rs.getString(3));
               persona.setFijo_per(rs.getString(4));
               persona.setMovil_per(rs.getString(5));
               persona.setCorreo_per(rs.getString(6));
               persona.setDireccion_per(rs.getString(7));
               return persona;
            }
        } catch (Exception e) {
        }
        return persona;
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
        }
        return listaPersona;
    }
    
    public int editarPersona(PersonaVO persona) {
        int filAfectadas=0;
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
            filAfectadas = ps.executeUpdate();
            ps.close();
            conexion.Desconectar();
            JOptionPane.showMessageDialog(null, "Se actualizo la persona exitosamente.","Información",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar");
        }
        return filAfectadas;  
    }
}