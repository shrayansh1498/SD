package BehaviouralDesignPatterns.VisitorPattern;
import java.util.*;

//Element interface
interface Item{
    void accept(ItemVisitor visitor);
}

class PhysicalProduct implements Item{
    String name;
    double weight;

    public PhysicalProduct(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }
    @Override
    public void accept(ItemVisitor visitor) {
        visitor.visit(this);
    }
}

class DigitalProduct implements Item{
    String name;
    double downloadSizeInMB;

    public DigitalProduct(String name, double downloadSizeInMB) {
        this.name = name;
        this.downloadSizeInMB = downloadSizeInMB;
    }
    @Override
    public void accept(ItemVisitor visitor) {
        visitor.visit(this);
    }
}

class GiftCard implements Item{
    String code;
    double amount;

    public GiftCard(String code, double amount) {
        this.code = code;
        this.amount = amount;
    }
    @Override
    public void accept(ItemVisitor visitor) {
        visitor.visit(this);
    }
}

//Visitor Interface
interface ItemVisitor{
    void visit(PhysicalProduct physicalProduct);
    void visit(DigitalProduct digitalProduct);
    void visit(GiftCard giftCard);
}

class InvoiceVisitor implements ItemVisitor{
    @Override
    public void visit(PhysicalProduct physicalProduct) {
        System.out.println("Invoice for " + physicalProduct.name + " ((" + physicalProduct.weight + "kg)");
    }
    @Override
    public void visit(DigitalProduct digitalProduct) {
        System.out.println("Invoice for " + digitalProduct.name + " (" + digitalProduct.downloadSizeInMB + "MB)");
    }
    @Override
    public void visit(GiftCard giftCard) {
        System.out.println("Invoice for " + giftCard.code + " (" + giftCard.amount + ")");
    }
}

class ShippingCostVisitor implements ItemVisitor{
    @Override
    public void visit(PhysicalProduct physicalProduct) {
        System.out.println("Shipping cost for " + physicalProduct.name + " is " + physicalProduct.weight*10 + " Rs");
    }
    @Override
    public void visit(DigitalProduct digitalProduct) {
        System.out.println("No Shipping cost for " + digitalProduct.name + " (" + digitalProduct.downloadSizeInMB + "MB)");
    }
    @Override
    public void visit(GiftCard giftCard) {
        System.out.println("No shipping cost for Gift card " + giftCard.code);
    }
}
public class Main {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<Item>();
        items.add(new PhysicalProduct("Laptop", 1.5));
        items.add(new PhysicalProduct("Mobile", 0.5));
        items.add(new DigitalProduct("Game", 10));
        items.add(new DigitalProduct("Movie", 20));
        items.add(new GiftCard("G1", 100));

        ItemVisitor invoiceVisitor = new InvoiceVisitor();
        ItemVisitor shippingCostVisitor = new ShippingCostVisitor();
        for(Item item : items) {
            item.accept(invoiceVisitor);
            item.accept(shippingCostVisitor);
        }
    }
}