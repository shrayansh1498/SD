package BehaviouralDesignPatterns.StatePattern;

class OrderContext{
    private OrderState currentState;
    public OrderContext(){
        this.currentState = new OrderPlacedState();
    }

    public void setState(OrderState state){
        this.currentState = state;
    }
    public void next(){
        currentState.next(this);
    }
    public void cancel(){
        currentState.cancel(this);
    }
    public String getCurrentState(){
        return currentState.getStateName();
    }
}

interface OrderState{
    void next(OrderContext context);
    void cancel(OrderContext context);
    String getStateName();
}
class OrderPlacedState implements OrderState{
    @Override
    public void next(OrderContext context) {
        context.setState(new PreparingState());   
        System.out.println("Order moved to Preparing state");     
    }
    @Override
    public void cancel(OrderContext context) {
        context.setState(new CancelledState());     
        System.out.println("Order has been Cancelled");   
    }
    @Override
    public String getStateName() {
        return "Order_Placed";        
    }
}
class PreparingState implements OrderState{
    @Override
    public void next(OrderContext context) {
        context.setState(new OutForDeliveryState());     
        System.out.println("Order moved to Out for Delivery state");   
    }
    @Override
    public void cancel(OrderContext context) {
        context.setState(new CancelledState());     
        System.out.println("Order has been Cancelled");   
    }
    @Override
    public String getStateName() {
        return "Preparing";        
    }
}

class OutForDeliveryState implements OrderState{
    @Override
    public void next(OrderContext context) {
        context.setState(new DeliveredState());     
        System.out.println("Order moved to Delivered state");   
    }
    @Override
    public void cancel(OrderContext context) {    
        System.out.println("Cannot cancel Order, it is out for delivery");   
    }
    @Override
    public String getStateName() {
        return "Out_For_delivery";        
    }
}

class DeliveredState implements OrderState{
    @Override
    public void next(OrderContext context) {
        System.out.println("Order is already delivered");   
    }
    @Override
    public void cancel(OrderContext context) {   
        System.out.println("Cannot Cancel a delivered order");   
    }
    @Override
    public String getStateName() {
        return "Delivered";        
    }
}
class CancelledState implements OrderState{
    @Override
    public void next(OrderContext context) {
        System.out.println("Order is already Cancelled");   
    }
    @Override
    public void cancel(OrderContext context) {
        System.out.println("Order is already Cancelled");   
    }
    @Override
    public String getStateName() {
        return "Cancelled";        
    }
}
public class Main {
    public static void main(String[] args) {
        OrderContext context = new OrderContext();
        System.out.println("Current state:" + context.getCurrentState());
        context.next(); //Preparing
        context.next(); //Out For Delivery
        context.cancel(); //cannot cancel
        context.next(); //Delivered
        context.cancel(); //cannot cancel
    }
}
