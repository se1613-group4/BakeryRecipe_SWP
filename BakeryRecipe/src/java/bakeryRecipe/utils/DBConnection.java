/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bakeryRecipe.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.tomcat.dbcp.dbcp2.DataSourceConnectionFactory;

/**
 *
 * @author LamVo
 */
public class DBConnection implements Serializable {

    private static Connection connection;
    private static String URL = "jdbc:mysql://localhost:3306/bakery_recipe";
    private static String USER = "root";
    private static String PASSWORD = "123456";
    
    // Function: get connection from MySQL
    public static Connection getConnection() throws SQLException {        
        connection = null;
        // Register driver
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        // Get connection
        connection = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
        return connection;
    }
}
