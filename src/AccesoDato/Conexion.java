package AccesoDato;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author DerKow
 */
public class Conexion {

    Connection conexion = null;
    static String bd = "extraviado";
    static String login = "root";
    static String password = "123456";
    static String url = "jdbc:mysql://localhost/" + bd;

    public Connection getConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(url, login, password);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return conexion;
    }

    public void Desconectar() {
        Connection conexion = null;
    }
}
