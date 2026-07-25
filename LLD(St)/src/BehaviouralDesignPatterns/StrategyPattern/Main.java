package BehaviouralDesignPatterns.StrategyPattern;
interface MatchingStrategy{ 
    void match(String riderLocation); 
}

class NearestDriverStrategy implements MatchingStrategy{
    @Override
    public void match(String riderLocation) {
        //Find Nearest Driver
        System.out.println("Matching with the Nearest available driver to " + riderLocation);
    }
}
class AirportQueueStrategy implements MatchingStrategy{
    @Override
    public void match(String riderLocation) {
        //Use FIFO based airport queue logic
        System.out.println("Matching using FIFO airport queue for " + riderLocation);
    }
}
class SurgePriorityStrategy implements MatchingStrategy{
    @Override
    public void match(String riderLocation) {
        //Match rider based on surge logic
        System.out.println("Matching using surge priority for " + riderLocation);
    }
}

class RideMatchingService{
    private MatchingStrategy strategy;
    public RideMatchingService(MatchingStrategy strategy){
        this.strategy = strategy;
    }
    public void setStrategy(MatchingStrategy strategy){
        this.strategy = strategy;
    }
    public void matchRider(String location){
        strategy.match(location);
    }
}
public class Main {
    public static void main(String[] args) {
        RideMatchingService rideMatchingService = new RideMatchingService(new NearestDriverStrategy());
        rideMatchingService.matchRider("Jubilee Circle");
        rideMatchingService.setStrategy(new SurgePriorityStrategy());
        rideMatchingService.matchRider("City Centre");
        rideMatchingService.setStrategy(new AirportQueueStrategy());
        rideMatchingService.matchRider("Canada Gate");
    }
}
