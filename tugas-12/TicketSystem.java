public class TicketSystem {
    public static void main(String[] args) {
        Ticket economyTicket = new EconomyTicket(1000, "Adi", 25);
        Ticket businessTicket = new BusinessTicket(2000, "Budi", 40);
        Ticket firstClassTicket = new FirstClassTicket(3000, "Toni", 35);

        Ticket[] tickets = {economyTicket, businessTicket, firstClassTicket};

        for (Ticket ticket : tickets) {
            System.out.println(ticket.getDetails());
        }
    }
}
