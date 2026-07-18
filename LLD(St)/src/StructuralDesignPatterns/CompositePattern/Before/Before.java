package StructuralDesignPatterns.CompositePattern.Before;
import java.util.*;
class Product{
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
class ProductBundle{
    private String name;
    private List<Product> products = new ArrayList<>();;
    public ProductBundle(String bundleName){
        this.name = bundleName;
    }
    public void addProduct(Product product){
        products.add(product);
    }
    public double getPrice(){
        double totalPrice = 0;
        for(Product product : products){
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
    public void display(String indent){
        System.out.println(indent + "Product Bundle: " + name + ", Price: " + getPrice());
        for(Product product : products){
            product.display(indent + "  ");
        }
    }
}
public class Before {
    public static void main(String[] args) {
        Product book = new Product("Atomic Habits", 499);
        Product phone = new Product("Iphone17", 149999);
        Product earbuds = new Product("Airpods", 15999);
        Product charger = new Product("20W Charger", 1999);

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
        List<Object> cart = new ArrayList<>();
        cart.add(book);
        cart.add(iphonecombo);
        cart.add(schoolKit);

        //Display cart
        System.out.println("Cart without COmposite pattern");
        double totalPrice = 0;
        for(Object item : cart){
            if(item instanceof Product){
                Product product = (Product) item;
                product.display("");
                totalPrice += product.getPrice();
            } else if(item instanceof ProductBundle){
                ProductBundle bundle = (ProductBundle) item;
                bundle.display("");
                totalPrice += bundle.getPrice();
            }
        }
        
        System.out.println("Total Price: " + totalPrice);
    }
}
