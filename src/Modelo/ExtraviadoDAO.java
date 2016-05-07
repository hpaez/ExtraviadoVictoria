/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.sql.*;

/**
 *
 * @author DerKow
 */
public class ExtraviadoDAO {
    ConexionBD conexion;
    
    public ExtraviadoDAO(){
    }
    
    public Extraviado verficaPreparedStatement(String id_extraviado, String id_usuario, String id_persona, String identificacion_ex, String nombre_ex, String apellido_ex, String cabello_ex, String piel_ex, String ojo_ex, Double medicion_ex, String contextura_ex, int peso_ex, String comentario_ex){
        Extraviado extraviado = null;
        Connection accesoDB = conexion.getConexion();
        try{
            PreparedStatement ps = accesoDB.prepareStatement("select * from extraviado");
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                extraviado = new Extraviado();
                extraviado.setId_extraviado(rs.getString(1));
                extraviado.setId_persona(rs.getString(2));
                extraviado.setId_persona(rs.getString(3));
                extraviado.setIdentificacion_ex(rs.getString(4));
                extraviado.setNombre_ex(rs.getString(5));
                extraviado.setApellido_ex(rs.getString(6));
                extraviado.setCabello_ex(rs.getString(7));
                extraviado.setPiel_ex(rs.getString(8));
                extraviado.setOjo_ex(rs.getString(9));
                extraviado.setMedicion_ex(rs.getDouble(10));
                extraviado.setContextura_ex(rs.getString(11));
                extraviado.setPeso_ex(rs.getInt(12));
                extraviado.setComentario_ex(rs.getString(13));
            }
        } catch (Exception e) {
        }
        return extraviado;
    }
}
