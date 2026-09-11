package ExceptionAndErrorHandling.CircuitBreaker;

@Service
class PaymentService{
    @CircuitBreaker(name = "paymentService", fallbackMethod = "paymentFallback")
    public String charge(String userId, double amount){
        //Real payment logic
        return externalPaymentAPI.charge(userId, amount);
    }

    public String paymentFallback(String userId, double amount, RuntimeException e){
        log.error("Payment service down. Fallback triggered.");
        return "Payment Failed: " + e.getMessage();
    }
}

/*
    @CircuitBreaker(name = "paymentService", fallbackMethod = "paymentFallback")
    Wrap this method with circuit breaker named "paymentService"
    If the method fails, say due to exception, etc, use the fallback method "paymentFallback"
    Actual configuration is like - 
    How many failuers cause it to open the circuuit
    How long it stays open
    What counts as failure

    ...is deifined in application.yml or application.properties or via a Java config bean.

    yml file example - 
    resilience4j:
        circuitbreaker:
            instances:
                paymentService:
                    registerHealthIndicator: true
                    slidingWindowsSize: 10
                    slidingWindowType: COUNT_BASED
                    miniumNumberOfCalls: 5
                    failureRateThreshold: 50
                    waitDurationInOpenState: 10000
                    permittedNumberOfCallsInHalfOpenState: 3
                    automaticTransitionFromOpenToHalfOpenEnabled: true


    @Bean
    public Customizer<CircuitBreakerConfigCustomizer> paymentCircuitBreakerConfig() {
        return CircuitBreakerConfigCustomizer
            .of("paymentService", builder -> builder
            .slidingWindow(10, TimeUnit.SECONDS)
            .permittedNumberOfCallsInHalfOpenState(3)
            .failureRateThreshold(50)
            .waitDurationInOpenState(10000)
            .automaticTransitionFromOpenToHalfOpenEnabled(true));
        
    }
*/

public class Main {
    
}
