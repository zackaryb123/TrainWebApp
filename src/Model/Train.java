package Model;

public class Train {
    private int trainNo;
    private String trainName;
    private String source;
    private String destination;
    private double ticketPrice;

    public Train(int trainNo, String trainName, String source, String destination, double ticketPrice) {
        this.trainNo = trainNo;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.ticketPrice = ticketPrice;
    }

    public Train() {
        this.trainNo = 0;
        this.trainName = "default";
        this.source = "default";
        this.destination = "default";
        this.ticketPrice = 0;
    }

    public void setTrainNo(int trainNo) {
        this.trainNo = trainNo;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getTrainNo() {
        return trainNo;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }
}
