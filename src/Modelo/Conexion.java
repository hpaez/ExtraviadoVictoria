/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author DerKow
 */
public class Conexion {
    Connection conexion;
    public Connection getConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/extraviado","root","123456");
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return conexion;
    }
}
