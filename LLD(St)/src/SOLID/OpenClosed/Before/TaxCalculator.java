package SOLID.OpenClosed.Before;

public class TaxCalculator {
    public double calculateTax(double amount, String region) {
        if(region=="INDIA") {
            return amount * 0.18; // 18% tax
        } else if(region=="USA") {
            return amount * 0.07; // 7% tax
        }
        return amount ; 
    }   
}
