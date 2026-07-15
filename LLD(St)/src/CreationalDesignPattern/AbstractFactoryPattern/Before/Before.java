interface PaymentGateway{
    void processPayment(double amount);
}
class RazorpayGateway implements PaymentGateway{
    public void processPayment(double amount){
        System.out.println("Processing INR payment through Razorpay: " + amount);
    }
}
class PayUGateway implements PaymentGateway{
    public void processPayment(double amount){
        System.out.println("Processing INR payment through PayU: " + amount);
    }
}
interface Invoice{
    void generateInvoice();
}
class GSTInvoice implements Invoice{
    public void generateInvoice(){
        System.out.println("Generating GST invoice for India");
    }
}
class USInvoice implements Invoice{
    public void generateInvoice(){
        System.out.println("Generating invoice for the US");
    }
}
class CheckoutService{
    private String gatewayType;

    public CheckoutService(String gatewayType){
        this.gatewayType = gatewayType;
    }

    // I also  violates Single Responsibility Principle and Open/Closed Principle because if we want to add a new payment gateway or invoice type, we have to modify this method.
    public void checkout(double amount){
        PaymentGateway paymentGateway;

        if(gatewayType.equals("Razorpay")){
            paymentGateway = new RazorpayGateway();
        } else if(gatewayType.equals("PayU")){
            paymentGateway = new PayUGateway();
        } 
        else {
            throw new IllegalArgumentException("Unsupported gateway type");
        }
        paymentGateway.processPayment(amount);
        Invoice invoice = new GSTInvoice();
        invoice.generateInvoice();
    }
}

public class Before{
    public static void main(String[] args){
        CheckoutService checkoutService = new CheckoutService("Razorpay");
        checkoutService.checkout(1000.0);
    }
}