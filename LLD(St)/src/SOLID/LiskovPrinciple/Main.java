package SOLID.LiskovPrinciple;

class NotiificationService {
    public void sendNotification() {
        System.out.println("Sending notification");
    }
}

class EmailNotificationService extends NotiificationService {
    @Override
    public void sendNotification() {
        System.out.println("Sending email notification");
    }
}

class TextNotificationService extends NotiificationService {
    @Override
    public void sendNotification() {
        System.out.println("Sending text notification");
    }
}

class WhatsappNotificationService extends NotiificationService {
    @Override
    public void sendNotification() {
        System.out.println("Sending WhatsApp notification");
    }
}

public class Main {
    public static void main(String[] args) {
        NotiificationService notificationService = new WhatsappNotificationService();
        notificationService.sendNotification();
        System.out.println("Whatsapp Notification sent successfully");
    }
}
