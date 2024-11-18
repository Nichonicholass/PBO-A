public class EconomyTicket extends Ticket {

    public EconomyTicket(double baseFare, String passengerName, int passengerAge) {
        super(baseFare, passengerName, passengerAge, 15); 
    }

    @Override
    public double calculateFare() {
        return baseFare * 0.9; 
    }

    @Override
    public String getFacilities() {
        return "Standard seating";
    }

    @Override
    public String getDetails() {
        return super.getDetails() + "\nClass: Economy\n";
    }
}
