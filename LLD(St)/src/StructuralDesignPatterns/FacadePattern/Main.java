package StructuralDesignPatterns.FacadePattern;

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
class MovieBookingFacade {
    private PaymentService paymentService;
    private SeatReservationService seatReservationService;
    private NotificationService notificationService;
    private LoyalPointService loyalPointService;
    private TicketService ticketService;

    public MovieBookingFacade() {
        this.paymentService = new PaymentService();
        this.seatReservationService = new SeatReservationService();
        this.notificationService = new NotificationService();
        this.loyalPointService = new LoyalPointService();
        this.ticketService = new TicketService();
    }

    public void bookMovieTicket(String accountId, String movieId, String seatNumber, double amount, String userEmail) {
        paymentService.makePayment(accountId, amount);
        seatReservationService.reserveSeat(movieId, seatNumber);
        notificationService.sendBookingConfirmation(userEmail);
        loyalPointService.addLoyaltyPoints(accountId, 100);
        ticketService.generateTicket(movieId, seatNumber);
    }
}   
public class Main {
    public static void main(String[] args) {

        MovieBookingFacade movieBookingFacade = new MovieBookingFacade();
        movieBookingFacade.bookMovieTicket("12345", "MOV123", "A1", 1500.0, "user@example.com");
    }
}
