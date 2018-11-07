package Dao.Jdbc;

import Dao.UserDao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUserDao implements UserDao {
    @Override
    public boolean isUser(String username, String password) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionHelper.getMySqlConnection();
            pstmt = conn.prepareStatement("SELECT * from LOGIN where USERNAME = ?");
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();

            if(rs.next()){
                String pass = rs.getString("password");
                return pass.equals(password);
            }
            return false;
        } catch (ClassNotFoundException | SQLException | IOException e) {
            throw  new RuntimeException(e.getMessage());
        } finally {
            ConnectionHelper.cleanup(conn, pstmt, rs);
        }
    }
}
