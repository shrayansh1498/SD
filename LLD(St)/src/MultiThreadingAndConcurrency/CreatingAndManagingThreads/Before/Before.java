package MultiThreadingAndConcurrency.CreatingAndManagingThreads.Before;

public class Before {
    private static void sendSMS()
    {
        try {
            Thread.sleep(2000); //Simulate Delay
            System.out.println("SMS sent");
        } catch (InterruptedException e) {
            e.printStackTrace();;
        }
    }

    private static void sendEmail()
    {
        try {
            Thread.sleep(2000); //Simulate Delay
            System.out.println("Email sent");
        } catch (InterruptedException e) {
            e.printStackTrace();;
        }
    }

    private static String calculateETA()
    {
        try {
            Thread.sleep(5000); //Simulate Delay
        } catch (InterruptedException e) {
            e.printStackTrace();;
        }
        return "25 minutes";
    }

    public static void main(String[] args) {
        System.out.println("Placing order..");
        sendSMS();
        System.out.println("Task 1 done");
        sendEmail();
        System.out.println("Task 2 done");
        String eta = calculateETA();
        System.out.println("Order placed. ETA: " + eta);
        System.out.println("Task 3 done");
    }
}
