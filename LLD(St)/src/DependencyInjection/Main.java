package DependencyInjection;

/*
    1. Harcoded logic - Tightly couple order service with specific implementation
    2. Difficult to test - How to test OrderService without hitting payment APIs
    3. Scalability Issues - What if we want to switch to Stripe from Razorpay
*/
class OrderService {
    private InventoryService inventory = new InventoryService();
    private PaymentService payment = new RazorPayment();
    private NotificationService inventory = new NotificationService();

    public void checkout(Order order){
        inventory.blockItems(order);
        payment.process(order);
        inventory.sendConfirmation(order);
    }
}

/*
    Advantages of DI - 
    1. Swappable components
    2. Testable with mocks
    3. Follows Dependency InversionPriciple (D in SOLID)
    4. Open to extension (new payment types), closed to modification
*/

class OrderService2 {
    private InventoryService inventory;
    private PaymentService payment;
    private NotificationService inventory;

    public OrderService2(InventoryService inventory, PaymentService payment, NotificationService inventory) {
        this.inventory = inventory;
        this.payment = payment;
        this.inventory = inventory;
    }

    public void checkout(Order order){
        inventory.blockItems(order);
        payment.process(order);
        inventory.sendConfirmation(order);
    }
}

//OrderService2 orderService2 = new OrderService2(new InventoryService(), new StripePayment(), new EmailNotificationService());
//For testing, we can use like this below
//OrderService2 testOrderService2 = new OrderService2(new testInventoryService(), new testPaymentService(), new testNotificationService());

/*
    Tpes of Dependency Injection
    1. Constructor Injection
    2. Setter Injection
    3. Interface Injection

    1. Constructor Injection is the above one
*/

//Setter Injection
class PaymentService{
    private Logger logger;
    public void setLogger(Logger logger){
        this.logger = logger;
    }
}

//Inetrface Injection
interface InjectableLogger{
    void injectLogger(Logger logger)
}




//Technical way to dot it

//1. Dependency (what is needed), always interface and not concrete implementation
interface NotificationService{
    void send(String message);
}

//2.Concrete Implementation
class EmailNotificationService implements NotificationService{
    @Override
    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}

//3. Client who needs it
class USerService{
    private NotificationService notificationService;
    public UserService(NotificationService notificationService){
        this.notificationService = notificationService;
    }

    public void register(String user){
        System.out.println("User registered : " + user);
        notificationService.send("Welcome " + user);
    }
}

//4. main method
public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService(new EmailNotificationService());
        userService.register("John Doe");
    }
}