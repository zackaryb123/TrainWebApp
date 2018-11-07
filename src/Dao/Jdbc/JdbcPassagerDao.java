package Dao.Jdbc;

import Dao.PassengerDao;

public class JdbcPassagerDao implements PassengerDao {
    @Override
    public void addPassenger(String name, int age, char gender) {
//        Passenger p = new Passenger(name, age, gender);
//        double fare = calcPassengerFare(p);
//
//        // Add passenger to tree map
//        this.passengers.put(p, fare);
//
//        // Add passenger to the db
//        TrainDAO db = new TrainDAO();
//        db.pstmt = db.con.prepareStatement("INSERT INTO PASSENGER VALUES (?, ?, ?)");
//        db.pstmt.setString(1, name);
//        db.pstmt.setInt(2, age);
//        db.pstmt.setString(3, String.valueOf(gender));
//        db.pstmt.execute();
    }
}
