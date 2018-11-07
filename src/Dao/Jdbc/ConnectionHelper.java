package Dao.Jdbc;

import java.io.IOException;
import java.sql.*;


public final class ConnectionHelper {

    public static Connection getMySqlConnection () throws ClassNotFoundException, SQLException, IOException
    {
        //Load the driver
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection("jdbc:oracle:thin:@localhost", "hr", "hr");
    }

    public static void cleanup(Connection conn, Statement stmt, ResultSet rs){
        try{
            if(rs != null){
                rs.close();
            }
            if(stmt != null){
                stmt.close();
            }
            if(conn != null){
                conn.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void cleanup(Connection conn, PreparedStatement stmt, ResultSet rs){
        try{
            if(rs != null){
                rs.close();
            }
            if(stmt != null){
                stmt.close();
            }
            if(conn != null){
                conn.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
