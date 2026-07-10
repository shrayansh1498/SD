package SOLID.OpenClosed;
class TaxCalculator {
    public double calculateTax(double amount, String region) {
        if(region=="INDIA") {
            return amount * 0.18; // 18% tax
        } else if(region=="USA") {
            return amount * 0.07; // 7% tax
        }
        return amount ; 
    }
}
class InvoiceService {
    public void calculate() {
        TaxCalculator taxCalculator = new TaxCalculator();
        double tax = taxCalculator.calculateTax(1000);
    }
}
public class Before {
    public static void main(String[] args) {
        InvoiceService invoiceService = new InvoiceService();
        invoiceService.calculate();
    }  
}
