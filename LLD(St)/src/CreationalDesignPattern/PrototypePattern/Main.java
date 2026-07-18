package CreationalDesignPattern.PrototypePattern;
import java.util.*;
interface EmailTemplate extends Cloneable {
    EmailTemplate clone();
    void sendContent(String content);
    void send(String to);
    String getContent();
}
class WelcomeEmail implements EmailTemplate {
    private String subject;
    private String content;
    public WelcomeEmail() {
        this.subject = "Thank you for signing up";
        this.content = "Welcome to Our Plus Service!";
    }
    @Override
    public WelcomeEmail clone() {
        try {
            return (WelcomeEmail) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone failed"); 
        }
    }
    public void sendContent(String content) {
        if(content != null) {
            this.content = content;
        }
    }
    @Override
    public void send(String to) {
        System.out.println("Sending Welcome Email to: " + to + " [ " + subject + " ] " + content);
    }
    public String getContent() {
        return content;
    }
}
class EmailTemplateRegistry {
    private static final Map<String, EmailTemplate> templates = new HashMap<>();
    static {
        templates.put("WelcomeEmail", new WelcomeEmail());
    }
    public static EmailTemplate getEmailTemplate(String type) { 
        return templates.get(type).clone();
    }
}
public class Main {
    public static void main(String[] args) {
        EmailTemplate welcomeEmail = EmailTemplateRegistry.getEmailTemplate("WelcomeEmail");
        welcomeEmail.sendContent("Welcome to our service!");
        welcomeEmail.send("john.doe@example.com");
        System.out.println("welcomeEmail: " + welcomeEmail.getContent());
        EmailTemplate welcomeEmailPremium = EmailTemplateRegistry.getEmailTemplate("WelcomeEmail");
        welcomeEmailPremium.sendContent(null);
        System.out.println("welcomeEmailPremium: " + welcomeEmailPremium.getContent());
        welcomeEmailPremium.send("jane.doe@example.com");
        System.out.println("welcomeEmail: " + welcomeEmail.getContent());
        System.out.println("welcomeEmailPremium: " + welcomeEmailPremium.getContent());
    }
}
