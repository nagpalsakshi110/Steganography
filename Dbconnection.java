/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;

/**
 *
 * @author Aman
 */
public class Dbconnection {
    static Connection dbconnect;
    public static Connection dbconnect()
    {
        Connection con=null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql:///stegano","root","0936");
        }catch(ClassNotFoundException | SQLException e)
        {
            System.out.println("Exception in making connection"+e);
        }
        return con;
    }
    
}


