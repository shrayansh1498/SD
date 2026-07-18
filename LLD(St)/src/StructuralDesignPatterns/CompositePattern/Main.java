package StructuralDesignPatterns.CompositePattern;
import java.util.*;
interface CartItem{
    double getPrice();
    void display(String indent);
}
class Product implements CartItem{
    private String name;
    private double price;
    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }
    public double getPrice(){
        return price;
    }
    public void display(String indent){
        System.out.println(indent + "Product: " + name + ", Price: " + price);
    }
}
class ProductBundle implements CartItem{
    private String name;
    private List<CartItem> items = new ArrayList<>();;
    public ProductBundle(String bundleName){
        this.name = bundleName;
    }
    public void addProduct(CartItem item){
        items.add(item);
    }
    public double getPrice(){
        double totalPrice = 0;
        for(CartItem item : items){
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
    public void display(String indent){
        System.out.println(indent + "Product Bundle: " + name + ", Price: " + getPrice());
        for(CartItem item : items){
            item.display(indent + "  ");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        CartItem book = new Product("Atomic Habits", 499);
        CartItem phone = new Product("Iphone17", 149999);
        CartItem earbuds = new Product("Airpods", 15999);
        CartItem charger = new Product("20W Charger", 1999);

        ProductBundle iphonecombo = new ProductBundle("iPhone combo");
        iphonecombo.addProduct(book);
        iphonecombo.addProduct(phone);
        iphonecombo.addProduct(earbuds);
        iphonecombo.addProduct(charger);

        ProductBundle schoolKit = new ProductBundle("School Kit");
        schoolKit.addProduct(new Product("Notebook pack", 349));
        schoolKit.addProduct(new Product("Penset", 99));
        schoolKit.addProduct(new Product("Highlighter", 49));

        // SAdd to Cart - Problems begin
        // Like we have to use Object type in cart list, which is not type safe and we have to do type casting to get the price of each product. This is a problem because we are not able to treat both Product and ProductBundle uniformly.
        List<CartItem> cart = new ArrayList<>();
        cart.add(book);
        cart.add(iphonecombo);
        cart.add(schoolKit);

        //Display cart
        System.out.println("Cart with COmposite pattern");
        double totalPrice = 0;
        for(CartItem item : cart){
            item.display("");
            totalPrice += item.getPrice();
        }
        
        System.out.println("Total Price: " + totalPrice);
    }
}
