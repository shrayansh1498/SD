package SOLID.OpenClosed.Before;

public class InvoiceService {
    public void calculate() {
        TaxCalculator taxCalculator = new TaxCalculator();
        taxCalculator.calculateTax(1000, "INDIA");
    }
}
