package MultiThreadingAndConcurrency.CreatingAndManagingThreads.ThreadExample;

class SMSThread extends Thread{
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

class EmailThread extends Thread{
    @Override
    public void run(){
        try {
            Thread.sleep(2000); //Simulate Delay
            System.out.println("Email sent using Thread");
        } catch (InterruptedException e) {
            e.printStackTrace();;
        }
    }
}

public class Main {

    public static void main(String[] args) {
        SMSThread smsThread = new SMSThread();
        EmailThread emailThread = new EmailThread();
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
