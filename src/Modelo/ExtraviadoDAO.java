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
public class ExtraviadoDAO {
    Conexion conexion;
    
    public ExtraviadoDAO() {
        conexion = new Conexion();
    }
    
    public String insertarExtraviado(String id_persona, String identificacion_ex, String nombre_ex, String apellido_ex, String cabello_ex, String piel_ex, String ojo_ex, Double medicion_ex, String contextura_ex, int peso_ex, String comentario_ex) {
        String rptRegistro = null;
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement("INSERT INTO extraviado(IDPERSONA,IDENTIFICACIONEXTRAVIAD,NOMBREEXTRAVIADO,APELLIDOSEXTRAVIADO,COLORCABELLOEXTRAVIADO,COLORPIELEXTRAVIADO,COLOROJOSEXTRAVIADO,MEDICIONEXTRAVIADO,CONTEXTURAEXTRAVIADO,PESOEXTRAVIADO,COMENTARIOEXTRAVIADO) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, id_persona);
            ps.setString(2, identificacion_ex);
            ps.setString(3, nombre_ex);
            ps.setString(4, apellido_ex);
            ps.setString(5, cabello_ex);
            ps.setString(6, piel_ex);
            ps.setString(7, ojo_ex);
            ps.setDouble(8, medicion_ex);
            ps.setString(9, contextura_ex);
            ps.setInt(10, peso_ex);
            ps.setString(11, comentario_ex);
            
            int numFilasAfectadas = ps.executeUpdate();
            
            if(numFilasAfectadas>0){
                JOptionPane.showMessageDialog(null, "Se ingreso el extraviado exitosamente");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rptRegistro;
    }
    
    public ExtraviadoVO verificaExtraviado(String id) {
        ExtraviadoVO extraviado=null;
        Connection accesoDB = conexion.getConexion();
        try {
            PreparedStatement ps = accesoDB.prepareStatement("SELECT * FROM extraviado WHERE IDENTIFICACIONEXTRAVIAD=?");
            ps.setString(1, id);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
               extraviado = new ExtraviadoVO();
               extraviado.setId_extraviado(rs.getInt(1));
               extraviado.setId_persona(rs.getString(2));
               extraviado.setIdtentificacion_ex(rs.getString(3));
               extraviado.setNombre_ex(rs.getString(4));
               extraviado.setApellido_ex(rs.getString(5));
               extraviado.setCabello_ex(rs.getString(6));
               extraviado.setPiel_ex(rs.getString(7));
               extraviado.setOjos_ex(rs.getString(8));
               extraviado.setMedicion_ex(rs.getDouble(9));
               extraviado.setContextura_ex(rs.getString(10));
               extraviado.setPeso_ex(rs.getInt(11));
               extraviado.setComentario_ex(rs.getString(12));
               return extraviado;
            }
        } catch (Exception e) {
        }
        return extraviado;
    }
    
    public ArrayList<ExtraviadoVO> listPersona() {
        ArrayList listaPersona = new ArrayList();
        ExtraviadoVO extraviado;
        try {
            Connection acceDB = conexion.getConexion();
            PreparedStatement ps = acceDB.prepareStatement("SELECT * FROM extraviado");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                extraviado = new ExtraviadoVO();
                extraviado.setId_extraviado(rs.getInt(1));
                extraviado.setId_persona(rs.getString(2));
                extraviado.setIdtentificacion_ex(rs.getString(3));
                extraviado.setNombre_ex(rs.getString(4));
                extraviado.setApellido_ex(rs.getString(5));
                extraviado.setCabello_ex(rs.getString(6));
                extraviado.setPiel_ex(rs.getString(7));
                extraviado.setOjos_ex(rs.getString(8));
                extraviado.setMedicion_ex(rs.getDouble(9));
                extraviado.setContextura_ex(rs.getString(10));
                extraviado.setPeso_ex(rs.getInt(11));
                extraviado.setComentario_ex(rs.getString(12));
                listaPersona.add(extraviado);
            }
        } catch (Exception e) {
        }
        return listaPersona;
    }
    
    public int deletePersona(String identificacion_ex) {
        int filAfectadas= 0;
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement("DELETE FROM extraviado WhERE IDENTIFICACIONEXTRAVIAD=?");
            ps.setString(1, identificacion_ex);
            filAfectadas = ps.executeUpdate();
        } catch (Exception e) {
        }
        
        return filAfectadas;
    }
    
    public int editarExtraviado(String id_extraviado, String identificacion_ex, String nombre_ex, String apellido_ex, String cabello_ex, String piel_ex, String ojo_ex, Double medicion_ex, String contextura_ex, int peso_ex, String comentario_ex) {
        int filAfectadas=0;
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement("UPDATE extraviado SET IDEXTRAVIADO=?,IDPERSONA=?,IDENTIFICACIONEXTRAVIAD=?,NOMBREEXTRAVIADO=?,APELLIDOSEXTRAVIADO=?,COLORCABELLOEXTRAVIADO=?,COLORPIELEXTRAVIADO=?,COLOROJOSEXTRAVIADO=?,MEDICIONEXTRAVIADO=?,CONTEXTURAEXTRAVIADO=?,PESOEXTRAVIADO=?,COMENTARIOEXTRAVIADO=? WHERE IDEXTRAVIADO=?");
            ps.setString(1, identificacion_ex);
            ps.setString(2, nombre_ex);
            ps.setString(3, apellido_ex);
            ps.setString(4, cabello_ex);
            ps.setString(5, piel_ex);
            ps.setString(6, ojo_ex);
            ps.setDouble(7, medicion_ex);
            ps.setString(8, contextura_ex);
            ps.setInt(9, peso_ex);
            ps.setString(10, comentario_ex);
            ps.setString(11, id_extraviado);
            filAfectadas = ps.executeUpdate();
        } catch (Exception e) {
        }
        return filAfectadas;  
    }
}
