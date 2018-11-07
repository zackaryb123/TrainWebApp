package Dao.Jdbc;

import Dao.TrainDao;
import Model.Train;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static Dao.Jdbc.ConnectionHelper.*;

public class JdbcTrainDao implements TrainDao {
    @Override
    public Train findTrain(int trainNo) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getMySqlConnection();
            pstmt = conn.prepareStatement("SELECT * FROM TRAINS WHERE TRAIN_NO = ?");
            pstmt.setInt(1, trainNo);
            rs = pstmt.executeQuery();

            Train train = new Train();
            if(rs.next()){
                train.setTrainNo(rs.getInt("train_no"));
                train.setTrainName(rs.getString("train_name"));
                train.setSource(rs.getString("source"));
                train.setDestination(rs.getString("destination"));
                train.setTicketPrice(rs.getDouble("ticket_price"));
            }
            conn.close();
            return train;
        } catch (ClassNotFoundException | SQLException | IOException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            cleanup(conn, pstmt, rs);
        }
    }
}
