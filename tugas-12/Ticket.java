public abstract class Ticket {
    protected double baseFare;
    protected String passengerName;
    protected int passengerAge;
    protected int baggageLimit; 

    public Ticket(double baseFare, String passengerName, int passengerAge, int baggageLimit) {
        this.baseFare = baseFare;
        this.passengerName = passengerName;
        this.passengerAge = passengerAge;
        this.baggageLimit = baggageLimit;
    }

    public abstract double calculateFare();

    public abstract String getFacilities();

    public String getDetails() {
        return "Passenger Name: " + passengerName + "\n" +
               "Age: " + passengerAge + "\n" +
               "Fare: " + calculateFare() + "\n" +
               "Baggage Limit: " + baggageLimit + "kg\n" +
               "Facilities: " + getFacilities();
    }
}
