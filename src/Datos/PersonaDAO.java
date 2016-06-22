package Datos;

import AccesoDato.Conexion;
import java.sql.*;

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

            if (numFilasAfectadas > 0) {
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

            if (numFilasAfectadas > 0) {
                resultado = true;
            }
        } catch (Exception e) {
            resultado = false;
        }
        return resultado;
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

            if (numFilasAfectadas > 0) {
                resultado = true;
            }
        } catch (Exception e) {
            resultado = false;
        }
        return resultado;
    }
}
