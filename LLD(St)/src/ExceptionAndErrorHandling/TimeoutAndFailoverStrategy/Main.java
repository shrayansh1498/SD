package ExceptionAndErrorHandling.TimeoutAndFailoverStrategy;

//Timeout is 5 sec for connection and 10 sec for read
HttpClient client = new HttpClient.builder()
    .connectTimeout(Duration.ofSeconds(5))
    .readTimeout(Duration.ofSeconds(10))
    .build();


//Failover
public String getData(){
        try{
            return primaryService.get();
        }
        catch (Exception e){
            return secondaryService.get();  //Failover service
        }
}

/*
    Summary of Error hHandling
    1. Temporary Spike - Retry with backoff
    2. Persistent Error - Circuit Breaker
    3. Third party delay - Timeout
    4. Degraded experince - Fallback UI or cache
    5. Avoid Flooding - Queue or Rate Limit
    6. Highly critical service - Failover service
*/

public class Main {
    
}
