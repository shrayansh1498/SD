package SOLID.OpenClosed;

interface TaxCalculator {
    double calculateTax(double amount);
}

class IndiaTaxCalculator implements TaxCalculator {
    @Override
    public double calculateTax(double amount) {
        return amount * 0.18; // 18% tax
    }
}
class USATaxCalculator implements TaxCalculator {
    @Override
    public double calculateTax(double amount) {
        return amount * 0.07; // 7% tax
    }
}

class InvoiceService {
    public void calculate() {
        TaxCalculator taxCalculator = new IndiaTaxCalculator(); // or new USATaxCalculator()
        taxCalculator.calculateTax(100);
    }
}

public class Main {
    public static void main(String[] args) {
        InvoiceService invoiceService = new InvoiceService();
        invoiceService.calculate();
        System.out.println("Tax calculation completed.");
    }
}