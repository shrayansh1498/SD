package BehaviouralDesignPatterns.StatePattern.Before;

class Order{
    private String state;
    public void setState(String state){
        this.state = "Order_Placed";
    }

    public void cancelOrder(){
        if(state.equals("Order_Placed") || state.equals("Preparing")){
            this.state = "Cancelled";
            System.out.println("Order Cancelled");
        }
        else{
            System.out.println("Order cannot be cancelled");
        }
    }

    public void nextState(){
        switch(state){
            case "Order_Placed": 
                this.state = "Preparing";
                break;
            case "Preparing": 
                this.state = "Out_For_delivery"; 
                break;
            case "Out_For_delivery": 
                this.state = "Delivered"; 
                break;
            default:
                System.out.println("No next State");
        }
        System.out.println("Order moved to: " + state);
    }
    public String getState(){
        return state;
    }
}
public class Before {
    
}
