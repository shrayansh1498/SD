package SOLID.InterfaceSegregation;

interface RiderInterface {
    void bookRide();
    void payRide();
}
interface DriverInterface {
    void acceptRide();
    void drive();
    void endRide();
}

class Rider implements RiderInterface {
    public void bookRide() {
        System.out.println("Booking a ride");
    }
    public void payRide() {
        System.out.println("Paying for the ride");
    }
}
class Driver implements DriverInterface {
    public void acceptRide() {
        System.out.println("Accepting a ride");
    }
    public void drive() {
        System.out.println("Driving a ride");
    }
    public void endRide() {
        System.out.println("Ending a ride");
    }
}
public class Main {
    public static void main(String[] args) {
        Rider rider = new Rider();
        rider.bookRide();
        rider.payRide();

        Driver driver = new Driver();
        driver.acceptRide();
        driver.drive();
        driver.endRide();
    }
}