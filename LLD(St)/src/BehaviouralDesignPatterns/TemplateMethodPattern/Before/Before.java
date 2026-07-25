package BehaviouralDesignPatterns.TemplateMethodPattern.Before;

class EmailNotification{
    public void send(String to, String message) {
        System.out.println("Checking rate limits for " + to);
        System.out.println("Validating email recipient: " + to);
        String formatted = message.trim();
        System.out.println("Logging bfore send: " + formatted + " to " + to);

        //Compose email
        String composedMessage = "<html><body><p>" + formatted + "</p></body></html>";
        //Send email
        System.out.println("Sending email to " + to + " with message: " + composedMessage);
        // Analytics
        System.out.println("Analytics updated for: " + to);
    }
}
class SMSNotification{
    public void send(String to, String message) {
        System.out.println("Checking rate limits for " + to);
        System.out.println("Validating email recipient: " + to);
        String formatted = message.trim();
        System.out.println("Logging bfore send: " + formatted + " to " + to);

        //Compose email
        String composedMessage = "SMS " + formatted ;
        //Send email
        System.out.println("Sending SMS to " + to + " with message: " + composedMessage);
        // Analytics
        System.out.println("Custom SMS Analytics for: " + to);
    }
}
public class Before {
    
}
