package CreationalDesignPattern.AbstractFactoryPattern;
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
class StripeGateway implements PaymentGateway{
    public void processPayment(double amount){
        System.out.println("Processing USD payment through Stripe: " + amount);
    }
}
class PaypalGateway implements PaymentGateway{
    public void processPayment(double amount){
        System.out.println("Processing USD payment through Paypal: " + amount);
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
interface RegionFactory{
    PaymentGateway createPaymentGateway(String gatewayType);
    Invoice createInvoice();
}
class IndiaFactory implements RegionFactory{
    public PaymentGateway createPaymentGateway(String gatewayType){
        switch(gatewayType){
            case "Razorpay":
                return new RazorpayGateway();
            case "PayU":
                return new PayUGateway();
            default:
                throw new IllegalArgumentException("Unsupported gateway type in India");
        }
    }
    public Invoice createInvoice(){
        return new GSTInvoice();
    }
}
class USFactory implements RegionFactory{
    public PaymentGateway createPaymentGateway(String gatewayType){
        switch(gatewayType){
            case "Stripe":
                return new StripeGateway();
            case "Paypal":
                return new PaypalGateway();
            default:
                throw new IllegalArgumentException("Unsupported gateway type in US");
        }
    }
    public Invoice createInvoice(){
        return new USInvoice();
    }
}
class CheckoutService{
    private PaymentGateway paymentGateway;
    private Invoice invoice;
    private String gatewayType;

    public CheckoutService(RegionFactory factory, String gatewayType){
        this.gatewayType = gatewayType;
        this.paymentGateway = factory.createPaymentGateway(gatewayType);
        this.invoice = factory.createInvoice();
    }

    public void checkout(double amount){
        paymentGateway.processPayment(amount);
        invoice.generateInvoice();
    }
}

public class Main{
    public static void main(String[] args){
        CheckoutService checkoutService = new CheckoutService(new IndiaFactory(), "Razorpay");
        checkoutService.checkout(1000.0);
        CheckoutService checkoutService2 = new CheckoutService(new USFactory(), "Stripe");
        checkoutService2.checkout(100.0);
    }
}