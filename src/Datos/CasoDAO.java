package Datos;

import Modelo.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author erik
 */
public class CasoDAO {
    Conexion conexion;
    
    public CasoDAO() {
        conexion = new Conexion();
       
    }
    
    public boolean insertarCaso(CasoVO caso,ExtraviadoVO extraviado_,PersonaVO persona) {
        boolean rptRegistro = false;
        int dato_=0;
        try {
            Connection accesoDB = conexion.getConexion();
//            PreparedStatement ps = accesoDB.prepareStatement("INSERT INTO caso(IDEXTRAVIADO,IDPERSONA,ESTADOCASO,FECHACASO) VALUES (?,?,?,?)");
            PreparedStatement ps = accesoDB.prepareStatement("INSERT INTO `caso` (`IDCASO`, `IDEXTRAVIADO`, `IDPERSONA`, `ESTADOCASO`, `FECHACASO`) VALUES (?,?,?,?,?)");
                dato_ = verificarCasoExtraviado(extraviado_.getIdentificacion_ex());
                ps.setInt(1, 1);
                ps.setInt(2, dato_);
                ps.setString(3, persona.getId_persona());
                ps.setString(4, caso.getESTADOCASO());
                ps.setDate(5, (Date) caso.getFECHACASO());
              
                int numFilasAfectadas = ps.executeUpdate();
                ps.close();
                conexion.Desconectar();
            
                if(numFilasAfectadas>0){
                    return true;
                }
            
        } catch (Exception e) {
            return false;
        }
        return rptRegistro;
    }
    //************CORREGIR ESTO
     public int verificarCasoExtraviado(String id) {
        int resultado=0;
        Connection accesoDB = conexion.getConexion();
        try {
            Statement stmt = accesoDB.createStatement();
//            PreparedStatement ps = accesoDB.prepareStatement("SELECT idextraviado FROM extraviado WHERE IDENTIFICACIONEXTRAVIAD = '?'");
//            ps.setString(1, id);
//            
            ResultSet rs = stmt.executeQuery("SELECT idextraviado FROM extraviado WHERE IDENTIFICACIONEXTRAVIAD = '"+id+"'");
            
//            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                resultado = rs.getInt("idextraviado");
            }
            rs.close();
            conexion.Desconectar();
            return resultado;
            
        } catch (Exception e) {
             return resultado;
        }
    }
    
//    public CasoVO select(String id) {
//        CasoVO caso=null;
//        Connection accesoDB = conexion.getConexion();
//        try {
//            PreparedStatement ps = accesoDB.prepareStatement("SELECT * FROM extraviado WHERE IDENTIFICACIONEXTRAVIAD=?");
//            ps.setString(1, id);
//            
//            ResultSet rs = ps.executeQuery();
//            if(rs.next()){
//               caso = new CasoVO();
////               caso.setESTADOCASO(rs.getInt(1));
////               caso.setId_persona(rs.getString(2));
////               caso.setIdentificacion_ex(rs.getString(3));
////               caso.setNombre_ex(rs.getString(4));
////               caso.setApellido_ex(rs.getString(5));
////               caso.setCabello_ex(rs.getInt(6));
////               caso.setPiel_ex(rs.getInt(7));
////               caso.setOjos_ex(rs.getInt(8));
////               caso.setMedicion_ex(rs.getDouble(9));
////               caso.setContextura_ex(rs.getInt(10));
////               caso.setPeso_ex(rs.getInt(11));
////               caso.setComentario_ex(rs.getString(12));
//               return caso;
//            }
//        } catch (Exception e) {
//        }
//        return caso;
//    }
//    
//    public ArrayList<CasoVO> listCaso() {
//        ArrayList listaExtraviado = new ArrayList();
//        ExtraviadoVO extraviado;
//        try {
//            Connection acceDB = conexion.getConexion();
//            PreparedStatement ps = acceDB.prepareStatement("SELECT * FROM extraviado");
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                extraviado = new ExtraviadoVO();
//                extraviado.setId_extraviado(rs.getInt(1));
//                extraviado.setId_persona(rs.getString(2));
//                extraviado.setIdentificacion_ex(rs.getString(3));
//                extraviado.setNombre_ex(rs.getString(4));
//                extraviado.setApellido_ex(rs.getString(5));
//                extraviado.setCabello_ex(rs.getInt(6));
//                extraviado.setPiel_ex(rs.getInt(7));
//                extraviado.setOjos_ex(rs.getInt(8));
//                extraviado.setMedicion_ex(rs.getDouble(9));
//                extraviado.setContextura_ex(rs.getInt(10));
//                extraviado.setPeso_ex(rs.getInt(11));
//                extraviado.setComentario_ex(rs.getString(12));
//                listaExtraviado.add(extraviado);
//            }
//        } catch (Exception e) {
//        }
//        return listaExtraviado;
//    }
//    
//    public int editarExtraviado(ExtraviadoVO extraviado) {
//        int filAfectadas=0;
//        try {
//            Connection accesoDB = conexion.getConexion();
//            PreparedStatement ps = accesoDB.prepareStatement("UPDATE extraviado SET IDENTIFICACIONEXTRAVIAD=?,NOMBREEXTRAVIADO=?,APELLIDOSEXTRAVIADO=?,COLORCABELLOEXTRAVIADO=?,COLORPIELEXTRAVIADO=?,COLOROJOSEXTRAVIADO=?,MEDICIONEXTRAVIADO=?,CONTEXTURAEXTRAVIADO=?,PESOEXTRAVIADO=?,COMENTARIOEXTRAVIADO=? WHERE IDEXTRAVIADO=?");
//            ps.setString(1, extraviado.getIdentificacion_ex());
//            ps.setString(2, extraviado.getNombre_ex());
//            ps.setString(3, extraviado.getApellido_ex());
//            ps.setInt(4, extraviado.getCabello_ex());
//            ps.setInt(5, extraviado.getPiel_ex());
//            ps.setInt(6, extraviado.getOjos_ex());
//            ps.setDouble(7, extraviado.getMedicion_ex());
//            ps.setInt(8, extraviado.getContextura_ex());
//            ps.setInt(9, extraviado.getPeso_ex());
//            ps.setString(10, extraviado.getComentario_ex());
//            ps.setInt(11, extraviado.getId_extraviado());
//            filAfectadas = ps.executeUpdate();
//            ps.close();
//            conexion.Desconectar();
//            JOptionPane.showMessageDialog(null, "Se actualizo el extraviado exitosamente.","Información",JOptionPane.INFORMATION_MESSAGE);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "No se pudo actualizar");
//        }
//        return filAfectadas;  
//    }
}
