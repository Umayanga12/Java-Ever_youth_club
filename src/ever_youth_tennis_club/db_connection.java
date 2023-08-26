/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ever_youth_tennis_club;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class db_connection {
    public static Connection DB_conneConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tennis_club" 
                + "", "root", "");
        return c;
    }
    
}
