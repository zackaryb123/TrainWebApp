package Dao.Jdbc;

import Dao.TicketDao;
import Model.Ticket;

public class JdbcTicketDao implements TicketDao {
    @Override
    public void addTicket(Ticket ticket) {
        // Add ticket to DB
//        TrainDAO db = new TrainDAO();
//        db.pstmt = db.con.prepareStatement("INSERT INTO TICKETS VALUES (?,?,?,?,?,?,?,?)");
//        db.pstmt.setInt(1, counter);
//        db.pstmt.setString(2, pnr);
//        db.pstmt.setString(3, String.valueOf(travelDate));
//        db.pstmt.setInt(4, train.getTrainNo());
//        db.pstmt.setString(5, train.getTrainName());
//        db.pstmt.setString(6, train.getSource());
//        db.pstmt.setString(7, train.getDestination());
//        db.pstmt.setDouble(8, calculateTotalTicketPrice());
//        db.pstmt.execute();
    }
}
