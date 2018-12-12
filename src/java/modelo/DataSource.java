/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Administrador
 */
public class DataSource {
    Connection conn;
    public void conectar() throws Exception{
        String user, password,url;
        user="root";
        password="";
        url = "jdbc:mysql://localhost/mydb";
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, password);
    }
    public void desconectar() throws Exception{
        if(!conn.isClosed()){
            conn.close();
        }
    }
}
