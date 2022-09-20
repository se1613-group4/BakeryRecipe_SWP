/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bakeryRecipe.utils;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.tomcat.dbcp.dbcp2.DataSourceConnectionFactory;

/**
 *
 * @author DELL
 */
public class DBConnection implements Serializable{
    private static Connection con;
    private static String URL="jdbc:mysql://localhost:3306/swp_bakery_recipe";
    private static String USER="root";
    private static String PASSWORD="123bakeryrecipe123";
 
    public static Connection getConnection() { //chua test connection
        con = null;
        try {
            // driver register
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(DataSourceConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (con);
    }
}
