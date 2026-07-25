package BehaviouralDesignPatterns.TemplateMethodPattern;

abstract class NotificationSender{
    //Final Template method
    public final void send(String to, String message){
        //Common
        rateLimiterCheck(to);
        validateRecipient(to);
        String formattedMessage = formatMessage(message);
        preSendAuditLog(to, formattedMessage);

        //Not common
        String composedMessage = composeMessage(formattedMessage);
        //Common
        sendMessage(to, composedMessage);
        postSendAnalytics(to);
    }

    //Commom Step 1
    private void rateLimiterCheck(String to){
        System.out.println("Checking rate limits for " + to);
    }
    //Commom Step 2
    private void validateRecipient(String to){
        System.out.println("Validating recipient: " + to);
    }
    //Commom Step 3
    private String formatMessage(String message){
        return message.trim();
    }
    //Commom Step 4
    private void preSendAuditLog(String to, String message){
        System.out.println("Logging before send: " + message + " to " + to);
    }

    //Hook for subclasses
    protected abstract String composeMessage(String formattedMessage);
    protected abstract void sendMessage(String to, String message);

    //Common Step 5 (Optoinal hook)
    protected void postSendAnalytics(String to){
        System.out.println("Analytics updated for: " + to);
    }
}

class EmailNotification extends NotificationSender{
    @Override
    protected String composeMessage(String formattedMessage) {
        return "<html><body><p>" + formattedMessage + "</p></body></html";
    }

    protected void sendMessage(String to, String message) {
        System.out.println("Sending email to " + to + " with message: " + message);
    }
}

class SMSNotification extends NotificationSender{
    @Override
    protected String composeMessage(String formattedMessage) {
        return "SMS " + formattedMessage;
    }

    @Override
    protected void sendMessage(String to, String message) {
        System.out.println("Sending SMS to " + to + " with message: " + message);
    }

    //Overriding optional hook
    @Override
    protected void postSendAnalytics(String to) {
        System.out.println("Custom SMS Analytics for: " + to);
    }
}
public class Main {
    public static void main(String[] args) {
        NotificationSender emailNotification = new EmailNotification();
        emailNotification.send("t3dX4@example.com", "Hello World!");

        NotificationSender smsNotification = new SMSNotification();
        smsNotification.send("t3dX4@example.com", "Hello World!");
    }
}
