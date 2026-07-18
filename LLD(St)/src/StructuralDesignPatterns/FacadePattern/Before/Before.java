package StructuralDesignPatterns.FacadePattern.Before;

class PaymentService {
    public void makePayment(String accountId, double amount) {
        System.out.println("Payment of $" + amount + " made from account " + accountId);
    }
}
class SeatReservationService {
    public void reserveSeat(String movieId, String seatNumber) {
        System.out.println("Seat " + seatNumber + " reserved for movie " + movieId);
    }
}
class NotificationService {
    public void sendBookingConfirmation(String userEmail) {
        System.out.println("Booking confirmation sent to " + userEmail);
    }
}
class LoyalPointService {
    public void addLoyaltyPoints(String accountId, int points) {
        System.out.println("" + points + " loyalty points added to account " + accountId);
    }
}
class TicketService{
    public void generateTicket(String movieId, String seatNumber) {
        System.out.println("Ticket generated for movie " + movieId + " and seat " + seatNumber);
    }
}
public class Before {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        paymentService.makePayment("12345", 1500.0);

        SeatReservationService seatReservationService = new SeatReservationService();
        seatReservationService.reserveSeat("MOV123", "A1"); 

        NotificationService notificationService = new NotificationService();
        notificationService.sendBookingConfirmation("user@example.com");

        LoyalPointService loyalPointService = new LoyalPointService();
        loyalPointService.addLoyaltyPoints("12345", 100);

        TicketService ticketService = new TicketService();
        ticketService.generateTicket("MOV123", "A1");
    }
}
