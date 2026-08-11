package MultiThreadingAndConcurrency.CreatingAndManagingThreads.ThreadUsingLambda;


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
        Thread smsThread = new Thread(() -> {
            try {
                Thread.sleep(2000); //Simulate Delay
                System.out.println("SMS sent using Thread");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
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
