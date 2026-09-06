package BehaviouralDesignPatterns.VisitorPattern.Before;

class PhysicalProduct{
    void printInvoice() {}
    double calculateShippingCost() {return 0;}
}

class DigitalProduct{
    void printInvoice() {}
}

class GiftCard{
    void printInvoice() {}
    double calculateDiscount() {return 0;}
}

public class Before {
    public static void main(String[] args) {
        
    }
}
