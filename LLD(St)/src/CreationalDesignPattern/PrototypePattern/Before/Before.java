package CreationalDesignPattern.PrototypePattern.Before;
interface EmailTemplate {
    void sendContent(String content);
    void send(String to);
}
class WelcomeEmail implements EmailTemplate {
    private String subject;
    private String content;
    public WelcomeEmail() {
        this.subject = "Thank you for signing up";
        this.content = "Welcome to Our Plus Service!";
    }
    @Override
    public void sendContent(String content) {
        if(content != null) {
            this.content = content;
        }
    }
    @Override
    public void send(String to) {
        System.out.println("Sending Welcome Email to: " + to + " [ " + subject + " ] " + content);
    }
}
public class Before {
    public static void main(String[] args) {
        WelcomeEmail welcomeEmail = new WelcomeEmail();
        welcomeEmail.sendContent("Welcome to our service!");
        welcomeEmail.send("john.doe@example.com");
        WelcomeEmail welcomeEmailPremium = new WelcomeEmail();
        welcomeEmailPremium.sendContent(null);
        welcomeEmailPremium.send("jane.doe@example.com");
    }
}
