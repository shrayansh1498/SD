package MultiThreadingAndConcurrency.CreatingAndManagingThreads.RunnableExample;

class SMSThread implements Runnable{
    @Override
    public void run(){
        try {
            Thread.sleep(2000); //Simulate Delay
            System.out.println("SMS sent using Thread");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class EmailThread implements Runnable{
    @Override
    public void run(){
        try {
            Thread.sleep(2000); //Simulate Delay
            System.out.println("Email sent using Thread");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Thread smsThread = new Thread(new SMSThread());
        Thread emailThread = new Thread(new EmailThread());
        System.out.println("Task started..");
        smsThread.start();
        System.out.println("Task 1 ongoing");
        emailThread.start();
        System.out.println("Task 2 ongoing");
        try {
            smsThread.join();
            emailThread.join();
        } catch (Exception e) {
        }
    }
}
