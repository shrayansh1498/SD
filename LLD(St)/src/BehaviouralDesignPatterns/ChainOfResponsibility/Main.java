package BehaviouralDesignPatterns.ChainOfResponsibility;

abstract class SupportHandler{
    protected SupportHandler nextHandler;
    public void setNextHandler(SupportHandler nextHandler){
        this.nextHandler = nextHandler;
    }
    public abstract void handleRequest(String requestType);
}

class GeneralSupport extends SupportHandler{
    @Override
    public void handleRequest(String requestType) {
        if(requestType.equals("general"))
            System.out.println("Handled by general support");
        else if(nextHandler != null)
            nextHandler.handleRequest(requestType);
    }
}
class BillingSupport extends SupportHandler{
    @Override
    public void handleRequest(String requestType) {
        if(requestType.equals("refund"))
            System.out.println("Handled by billiing support");
        else if(nextHandler != null)
            nextHandler.handleRequest(requestType);
    }
}
class TechnicalSupport extends SupportHandler{
    @Override
    public void handleRequest(String requestType) {
        if(requestType.equals("technical"))
            System.out.println("Handled by technical support");
        else if(nextHandler != null)
            nextHandler.handleRequest(requestType);
    }
}
class DeliverySupport extends SupportHandler{
    @Override
    public void handleRequest(String requestType) {
        if(requestType.equals("delivery"))
            System.out.println("Handled by Delivery support");
        else 
            System.out.println("Invalid request");
    }
}

public class Main {
    public static void main(String[] args) {
        SupportHandler generalSupport = new GeneralSupport();
        SupportHandler billingSupport = new BillingSupport();
        SupportHandler technicalSupport = new TechnicalSupport();
        SupportHandler deliverySupport = new DeliverySupport();

        generalSupport.setNextHandler(billingSupport);
        billingSupport.setNextHandler(technicalSupport);
        technicalSupport.setNextHandler(deliverySupport);

        generalSupport.handleRequest("general");

        generalSupport.handleRequest("refund");
    }
}
