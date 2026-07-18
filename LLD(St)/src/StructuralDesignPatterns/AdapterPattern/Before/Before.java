package StructuralDesignPatterns.AdapterPattern.Before;

interface PaymentGateway {
    void pay(String orderId, double amount);
}
class PayUGateway implements PaymentGateway {
    @Override
    public void pay(String orderId, double amount) {
        System.out.println("Paying " + amount + " for order " + orderId + " using PayU Gateway");
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
class RazorPay{
    public void makePayment(String invoiceId, double amountInRupees) {
        System.out.println("Making payment of " + amountInRupees + " for invoice " + invoiceId + " using RazorPay");
    }
}

public class Before {
    public static void main(String[] args) {
        CheckOutService checkOutService = new CheckOutService(new PayUGateway());
        checkOutService.checkout("12345", 100.0);
    }
}
