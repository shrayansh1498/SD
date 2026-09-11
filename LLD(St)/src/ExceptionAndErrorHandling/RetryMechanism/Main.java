package ExceptionAndErrorHandling.RetryMechanism;

/*
    Retry mechanism
    1. Naive retry example
    2. Exponential Backoff startegy
*/ 

//Naive retry example
public String getETA(){
    int retries = 3;
    while(retries-- > 0){
        try{
            return etaService.getETA();
        }
        catch(Exception e){
            log.warn("Retrying ETA, attempts left " + retries);
        }
    }
    return "ETA unavailable";
}

//Exponential Backoff startegy
public String getETAwithBackoff throws InterruptedException(){
    int retries = 3;
    int delay = 1000; //1 second
    while(retries-- > 0){
        try{
            return etaService.getETA();
        }
        catch(Exception e){
            Thread.sleep(delay);
            delay *= 2;
            log.warn("Retrying ETA, attempts left " + retries);
        }
    }
    return "ETA unavailable";
}


public class Main {s
    
}
