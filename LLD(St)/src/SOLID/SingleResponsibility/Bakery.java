// Class for baking bread
class BreadBaker {
 public
  void bakeBread() { System.out.println("Baking high-quality bread..."); }
}

// Class for managing inventory
class InventoryManager {
 public
  void manageInventory() { System.out.println("Managing inventory..."); }
}

// Class for ordering supplies
class SupplyOrder {
 public
  void orderSupplies() { System.out.println("Ordering supplies..."); }
}

// Class for serving customers
class CustomerService {
 public
  void serveCustomer() { System.out.println("Serving customers..."); }
}

// Class for cleaning the bakery
class BakeryCleaner {
 public
  void cleanBakery() { System.out.println("Cleaning the bakery..."); }
}

public class Bakery {
 public static void main(String[] args) {
    BreadBaker baker = new BreadBaker();
    InventoryManager inventoryManager = new InventoryManager();
    SupplyOrder supplyOrder = new SupplyOrder();
    CustomerService customerService = new CustomerService();
    BakeryCleaner cleaner = new BakeryCleaner();
    // Each class focuses on its specific responsibility
    baker.bakeBread();
    inventoryManager.manageInventory();
    supplyOrder.orderSupplies();
    customerService.serveCustomer();
    cleaner.cleanBakery();
  }
}