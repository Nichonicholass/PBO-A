public class BusinessTicket extends Ticket {

    public BusinessTicket(double baseFare, String passengerName, int passengerAge) {
        super(baseFare, passengerName, passengerAge, 25);
    }

    @Override
    public double calculateFare() {
        return baseFare * 1.25; 
    }

    @Override
    public String getFacilities() {
        return "Reclining seats, complimentary meals, priority boarding.";
    }

    @Override
    public String getDetails() {
        return super.getDetails() + "\nClass: Business\n";
    }
}
