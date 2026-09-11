package ExceptionAndErrorHandling.GracefulDegradationStrategy;

import java.util.List;

/* 
    Graceful Degradation Strategy
    1. Return cached data
    2. Show fallback UI
    3. Queue requests
*/

//1. Return cached data
class RecommendationService{
    public List<String> getRecommendedItems(Strinf userId){
        try{
            return recommendationService.fetchLiveRecommendations(userId);
        }
        catch (Exception e){
            log.warn("Live service failed, falling vback to cached data");
            return cacheService.getCachedRecommendations(userId);
        }
    }

    public List<String> fetchLiveRecommendations(String userId){
        return List.of("movie1", "movie2");
    }
}

//2. Show fallback UI and 3. Queue requests
public class ErrorHandling{
    //Show fallback UI
    public Menu getMenu(String restaurantId){
        try{
            return menuService.fetchMenu(restaurantId);
        }
        catch (Exception e){
            return new Menu("Menu currently unavailable. Please try again later.");
        }
    }

    //Queue requests
    public void placeOrder(Order order){
        try{
            paymentService.charge(order);
        }
        catch (Exception e){
            orderRetryQueue.enqueue(order);
            log.warn("Payment failed, Queued for retry");
        }
    }
}

public class Main {
    
}
