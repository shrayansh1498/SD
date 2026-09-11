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

public class Main {
    
}
