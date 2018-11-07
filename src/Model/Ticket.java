package Model;

import Dao.Jdbc.JdbcPassagerDao;
import Dao.PassengerDao;

import java.io.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Ticket {

    /*****VARIABLES****/
    static Random r = new Random();
    static private int counter = r.nextInt(899) + 100;
    private String pnr;
    private LocalDate travelDate;
    private Train train;
    private TreeMap<Passenger, Double> passengers;
    private double totalPrice;

    /*****CONSTRUCTOR*****/
    public Ticket(LocalDate travelDate, Train train) {
        this.travelDate = travelDate;
        this.train = train;
        pnr = genatatePNR();
        passengers = new TreeMap<>();
    }

//    public Ticket() {
//
//    }

    /*****METHODS****/
    private String genatatePNR() {
        String s = String.valueOf(train.getSource().charAt(0));
        String d = String.valueOf(train.getDestination().charAt(0));

        String y = String.valueOf(travelDate.getYear());
        String m = String.valueOf(travelDate.getMonthValue());
        String day = String.valueOf(travelDate.getDayOfMonth());

        if(Integer.valueOf(m) < 10){ m = 0+m; }
        if(Integer.valueOf(day) < 10){ day = 0+day; }

        ++counter;

        return s+d+"_"+y+m+day+"_"+counter;
    }

    private double calcPassengerFare(Passenger p) {
        int age = p.getAge();
        char gender = p.getGender();
        double price = train.getTicketPrice();

        if(age <= 12){
            return .5 * price;
        } else if(age >= 60) {
            return .6 * price;
        } else if(gender == 'F') {
            return .25 * price;
        } else {
            return price;
        }
    }

    public double calculateTotalTicketPrice() {
        double sum = 0;
        for(Map.Entry<Passenger, Double> entry : passengers.entrySet()){
            Double value = entry.getValue();
            sum += value;
        }
        totalPrice = sum;
        return sum;
    }

    public void addPassenger(Passenger passenger) {
        // Add passenger to tree map
        if(passenger != null){
            double fare = calcPassengerFare(passenger);
            passengers.put(passenger, fare);

        }
        //TODO: Add passenger to the db
        //PassengerDao passengerDao = new JdbcPassagerDao();
        //passengerDao.addPassenger(name, age, gender);
    }

    private StringBuilder generateTicket() {
        String ticketStr =
                "PNR          : " + pnr+"\n"+
                "Train No     : " + String.valueOf(train.getTrainNo())+"\n"+
                "Train Name   : " + train.getTrainName()+"\n"+
                "From         : " + train.getSource()+"\n"+
                "To           : " + train.getDestination()+"\n"+
                "Travel Date  : " + travelDate+"\n\n"+
                "Passengers:\n" +
                "Name\t\t\tAge\t\t\tGender\t\t\tFare\n";

        StringBuilder sb = new StringBuilder(ticketStr);

        for(Map.Entry<Passenger, Double> entry : passengers.entrySet()){
            Double value = entry.getValue();
            Passenger p = entry.getKey();

            String passengerStr = p.getName()+"\t\t\t"+p.getAge()+"\t\t\t"+p.getGender()+"\t\t\t"+value+"\n";
            sb.append(passengerStr);
        }

        String tp = "Total Price: " + calculateTotalTicketPrice();
        sb.append(tp);

        return sb;
    }

    public void writeTicket() throws IOException {
        StringBuilder sb = generateTicket();
        File dir = new File("C:\\ticket_files");
        dir.mkdir();

        File f = new File("C:\\ticket_files\\" + pnr);
        f.createNewFile();

        FileOutputStream fos = null;
        BufferedOutputStream bos = null;

        try {
            fos = new FileOutputStream(f);
            bos = new BufferedOutputStream(fos);
            bos.write(String.valueOf(sb).getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not Found");
        } finally {
            try {
                if (bos != null) {
                    bos.flush();
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(fos != null){
                fos.close();
            }
        }
    }

    /*****SETTERS****/
    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public void setTravelDate(LocalDate travelDate) {
        this.travelDate = travelDate;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public void setPassengers(TreeMap<Passenger, Double> passengers) {
        this.passengers = passengers;
    }

    /*****GETTERS****/
    public int getCounter() {
        return counter;
    }

    public String getPnr() {
        return pnr;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public LocalDate getTravelDate() {
        return travelDate;
    }

    public Train getTrain() {
        return train;
    }

    public TreeMap<Passenger, Double> getPassengers() {
        return passengers;
    }
}
