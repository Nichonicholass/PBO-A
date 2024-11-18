public class FirstClassTicket extends Ticket {

    public FirstClassTicket(double baseFare, String passengerName, int passengerAge) {
        super(baseFare, passengerName, passengerAge, 40); 
    }

    @Override
    public double calculateFare() {
        return baseFare * 1.5; 
    }

    @Override
    public String getFacilities() {
        return "Luxury seats, meals, drink, and snack, lounge access, priority boarding.";
    }

    @Override
    public String getDetails() {
        return super.getDetails() + "\nClass: First Class\n";
    }
}
