package BehaviouralDesignPatterns.StrategyPattern.Before;

class RideMatchingService {
    public void matchRider(String riderLocation, String matchingType){
        if(matchingType.equals("Nearest")){
            //Find Nearest Driver
        }
        else if(matchingType.equals("Surge_priority")){
            //Match rider based on surge logic
        }
        else if(matchingType.equals("Airport_Queue")){
            //Use FIFO based airport queue logic
        }

    }
}
public class Before {
    
}
