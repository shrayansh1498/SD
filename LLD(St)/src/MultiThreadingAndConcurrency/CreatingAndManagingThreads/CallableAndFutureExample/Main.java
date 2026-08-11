package MultiThreadingAndConcurrency.CreatingAndManagingThreads.CallableAndFutureExample;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

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

class ETACalculator implements Callable<String>{
    private final String location;
    public ETACalculator(String location)
    {
        this.location = location;
    }

    @Override
    public String call() throws Exception{
        try {
            Thread.sleep(3000); //Simulate API or DB call
            System.out.println(Thread.currentThread().getName() + " : Calculating ETA to : " + location);
            return "ETA to : " + location + " : 20 minutes";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "ETA to : " + location + " : 20 minutes";
    }
}

public class Main {

    public static void main(String[] args) {
        Thread smsThread = new Thread(new SMSThread());
        Thread emailThread = new Thread(new EmailThread());
        FutureTask<String> etaThreadRunnable = new FutureTask<>(new ETACalculator("Delhi"));
        Thread etaThread = new Thread(etaThreadRunnable);
        System.out.println("Task started..");
        smsThread.start();
        System.out.println("Task 1 ongoing");
        emailThread.start();
        System.out.println("Task 2 ongoing");
        etaThread.start();
        try {
            smsThread.join();
            emailThread.join();
            String eta = etaThreadRunnable.get();
            // etaThread.join();
            System.out.println("ETA: " + eta);
            System.out.println("Task done");
        } catch (Exception e) {
        }
    }
}
