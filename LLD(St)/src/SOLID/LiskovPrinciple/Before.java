package SOLID.LiskovPrinciple;

class NotiificationService {
    public void sendNotification() {
        System.out.println("Sending notification");
    }
}

public class Before {
    public static void main(String[] args) {
        NotiificationService notificationService = new NotiificationService();
        notificationService.sendNotification();
        System.out.println("Notification sent successfully");
    }
}
