package BehaviouralDesignPatterns.ChainOfResponsibility.Before;

//In customer support system for ecommerce like amazon, etc., users raise tickets
//General inquiries
//Refund requests
//Technical issues
//Complaints about delivery

class SupportService {
    public void handleRequest(String type){
        if(type.equals("general"))
            System.out.println("Handled by general support");
        else if(type.equals("refund"))
            System.out.println("Handled by billing support");
        else if(type.equals("technical"))
            System.out.println("Handled by technical support");
        else if(type.equals("delivery"))
            System.out.println("Handled by delivery support");
        else
            System.out.println("Invalid request");
    }
}
public class Before {
    
}
