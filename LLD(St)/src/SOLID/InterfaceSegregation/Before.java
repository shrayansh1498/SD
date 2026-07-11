package SOLID.InterfaceSegregation;

interface Uber {
    void bookRide();
    void acceptRide();
    void drive();
    void endRide();
    void payRide();
}

class Rider implements Uber {
    public void bookRide() {
        System.out.println("Booking a ride");
    }
    public void acceptRide() {
        System.out.println("Accepting a ride");
    }
    public void drive() {
        System.out.println("Driving a ride");
    }
    public void endRide() {
        System.out.println("Ending a ride");
    }
    public void payRide() {
        System.out.println("Paying for the ride");
    }
}
public class Before {
    public static void main(String[] args) {
        Rider rider = new Rider();
        rider.bookRide();
        rider.acceptRide();
        rider.drive();
        rider.endRide();
        rider.payRide();
    }
}
