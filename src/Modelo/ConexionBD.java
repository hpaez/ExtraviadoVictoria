/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author DerKow
 */
public class ConexionBD {
    static String bd = "Extraviado";

    static String login = "root";
    static String password = "123456";
    static String url = "jdbc:mysql://localhost/" + bd;
    static Connection conn;

    ConexionBD() {
        this.conectarBD();
    }

    ConexionBD(String b1, String l1, String p1) {
        this.bd = b1;
        this.login = l1;
        this.password = p1;
        this.url = "jdbc:mysql://localhost/" + bd;
        this.conectarBD();
    }

    void conectarBD() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, login, password);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un problema, causado por: " + e);
        }
    }
}
