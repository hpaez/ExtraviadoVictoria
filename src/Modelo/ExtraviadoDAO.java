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
    
    public String insertarExtraviado(ExtraviadoVO extraviado) {
        String rptRegistro = null;
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement("INSERT INTO extraviado(IDPERSONA,IDENTIFICACIONEXTRAVIAD,NOMBREEXTRAVIADO,APELLIDOSEXTRAVIADO,COLORCABELLOEXTRAVIADO,COLORPIELEXTRAVIADO,COLOROJOSEXTRAVIADO,MEDICIONEXTRAVIADO,CONTEXTURAEXTRAVIADO,PESOEXTRAVIADO,COMENTARIOEXTRAVIADO) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, extraviado.getId_persona());
            ps.setString(2, extraviado.getIdentificacion_ex());
            ps.setString(3, extraviado.getNombre_ex());
            ps.setString(4, extraviado.getApellido_ex());
            ps.setInt(5, extraviado.getCabello_ex());
            ps.setInt(6, extraviado.getPiel_ex());
            ps.setInt(7, extraviado.getOjos_ex());
            ps.setDouble(8, extraviado.getMedicion_ex());
            ps.setInt(9, extraviado.getContextura_ex());
            ps.setInt(10, extraviado.getPeso_ex());
            ps.setString(11, extraviado.getComentario_ex());
            
            int numFilasAfectadas = ps.executeUpdate();
            ps.close();
            conexion.Desconectar();
            
            if(numFilasAfectadas>0){
                JOptionPane.showMessageDialog(null, "Se ingreso el extraviado exitosamente.","Información",JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo ingresar.");
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
               extraviado.setIdentificacion_ex(rs.getString(3));
               extraviado.setNombre_ex(rs.getString(4));
               extraviado.setApellido_ex(rs.getString(5));
               extraviado.setCabello_ex(rs.getInt(6));
               extraviado.setPiel_ex(rs.getInt(7));
               extraviado.setOjos_ex(rs.getInt(8));
               extraviado.setMedicion_ex(rs.getDouble(9));
               extraviado.setContextura_ex(rs.getInt(10));
               extraviado.setPeso_ex(rs.getInt(11));
               extraviado.setComentario_ex(rs.getString(12));
               return extraviado;
            }
        } catch (Exception e) {
        }
        return extraviado;
    }
    
    public ArrayList<ExtraviadoVO> listExtraviado() {
        ArrayList listaExtraviado = new ArrayList();
        ExtraviadoVO extraviado;
        try {
            Connection acceDB = conexion.getConexion();
            PreparedStatement ps = acceDB.prepareStatement("SELECT * FROM extraviado");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                extraviado = new ExtraviadoVO();
                extraviado.setId_extraviado(rs.getInt(1));
                extraviado.setId_persona(rs.getString(2));
                extraviado.setIdentificacion_ex(rs.getString(3));
                extraviado.setNombre_ex(rs.getString(4));
                extraviado.setApellido_ex(rs.getString(5));
                extraviado.setCabello_ex(rs.getInt(6));
                extraviado.setPiel_ex(rs.getInt(7));
                extraviado.setOjos_ex(rs.getInt(8));
                extraviado.setMedicion_ex(rs.getDouble(9));
                extraviado.setContextura_ex(rs.getInt(10));
                extraviado.setPeso_ex(rs.getInt(11));
                extraviado.setComentario_ex(rs.getString(12));
                listaExtraviado.add(extraviado);
            }
        } catch (Exception e) {
        }
        return listaExtraviado;
    }
    
    public int editarExtraviado(ExtraviadoVO extraviado) {
        int filAfectadas=0;
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement("UPDATE extraviado SET IDENTIFICACIONEXTRAVIAD=?,NOMBREEXTRAVIADO=?,APELLIDOSEXTRAVIADO=?,COLORCABELLOEXTRAVIADO=?,COLORPIELEXTRAVIADO=?,COLOROJOSEXTRAVIADO=?,MEDICIONEXTRAVIADO=?,CONTEXTURAEXTRAVIADO=?,PESOEXTRAVIADO=?,COMENTARIOEXTRAVIADO=? WHERE IDEXTRAVIADO=?");
            ps.setString(1, extraviado.getIdentificacion_ex());
            ps.setString(2, extraviado.getNombre_ex());
            ps.setString(3, extraviado.getApellido_ex());
            ps.setInt(4, extraviado.getCabello_ex());
            ps.setInt(5, extraviado.getPiel_ex());
            ps.setInt(6, extraviado.getOjos_ex());
            ps.setDouble(7, extraviado.getMedicion_ex());
            ps.setInt(8, extraviado.getContextura_ex());
            ps.setInt(9, extraviado.getPeso_ex());
            ps.setString(10, extraviado.getComentario_ex());
            ps.setInt(11, extraviado.getId_extraviado());
            filAfectadas = ps.executeUpdate();
            ps.close();
            conexion.Desconectar();
            JOptionPane.showMessageDialog(null, "Se actualizo el extraviado exitosamente.","Información",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar");
        }
        return filAfectadas;  
    }
}
