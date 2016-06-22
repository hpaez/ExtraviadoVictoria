package Datos;

import AccesoDato.Conexion;
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

    public boolean insertarCaso(CasoVO caso, ExtraviadoVO extraviado_, PersonaVO persona) {
        boolean rptRegistro = false;
        int dato_;
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement("INSERT INTO `caso` (`IDEXTRAVIADO`, `IDPERSONA`, `ESTADOCASO`, `FECHACASO`) VALUES (?,?,?,?)");
            dato_ = verificarCasoExtraviado(extraviado_.getIdentificacion_ex());
            ps.setInt(1, dato_);
            ps.setString(2, persona.getId_persona());
            ps.setString(3, caso.getESTADOCASO());
            ps.setDate(4, (Date) caso.getFECHACASO());

            int numFilasAfectadas = ps.executeUpdate();
            ps.close();
            conexion.Desconectar();

            if (numFilasAfectadas > 0) {
                return true;
            }

        } catch (Exception e) {
            return false;
        }
        return rptRegistro;
    }

    public int verificarCasoExtraviado(String id) {
        int resultado = 0;
        Connection accesoDB = conexion.getConexion();
        try {
            Statement stmt = accesoDB.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT idextraviado FROM extraviado WHERE IDENTIFICACIONEXTRAVIAD = '" + id + "'");
            while (rs.next()) {
                resultado = rs.getInt("idextraviado");
            }
            rs.close();
            conexion.Desconectar();
            return resultado;

        } catch (Exception e) {
            return resultado;
        }
    }
}
