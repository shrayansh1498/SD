package StructuralDesignPatterns.AdapterPattern;

interface PaymentGateway {
    void pay(String orderId, double amount);
}
class PayUGateway implements PaymentGateway {
    @Override
    public void pay(String orderId, double amount) {
        System.out.println("Paying " + amount + " for order " + orderId + " using PayU Gateway");
    }
}

class RazorPay{
    public void makePayment(String invoiceId, double amountInRupees) {
        System.out.println("Making payment of " + amountInRupees + " for invoice " + invoiceId + " using RazorPay");
    }
}
class RazorPayAdapter implements PaymentGateway {
    private RazorPay razorPay;
    public RazorPayAdapter() {
        this.razorPay = new RazorPay();
    }
    @Override
    public void pay(String orderId, double amount) {
        razorPay.makePayment(orderId, amount);
    }
}
class CheckOutService{
    private PaymentGateway paymentGateway;
    public CheckOutService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }
    public void checkout(String orderId, double amount) {
        paymentGateway.pay(orderId, amount);
    }
}
public class Main {
    public static void main(String[] args) {
        CheckOutService checkOutService = new CheckOutService(new PayUGateway());
        checkOutService.checkout("12345", 100.0);
        CheckOutService checkOutService2 = new CheckOutService(new RazorPayAdapter());
        checkOutService2.checkout("125", 1000.0);
    }
}
