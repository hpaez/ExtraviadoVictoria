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
public class ConexionBD {
    public ConexionBD() {   
    }
    
    public Connection getConexion(){
        Connection con = null;
        try{
            Class.forName("con.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jbc:mysql://localhost:3306/extraviado","root","123456");
        } catch (SQLException ex){       
        } catch (Exception e){
        }
        return con;
    }
}