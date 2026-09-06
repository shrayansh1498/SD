package MultiThreadingAndConcurrency.ThreadpoolsAndExecutors.ThreadpoolsAndExecutors;

import java.util.concurrent.*;

class EmailService{
    private static final ExecutorService executor = Executors.newFixedThreadPool(8);
    //like newFixedThreadPool, we also have newScheduledThreadPool, newCachedThreadPool

    public static void sendEmail(String recipient){
        executor.execute(() -> {
            System.out.println("Sending Email to " + recipient + " on " + Thread.currentThread().getName());

            try{
                //Dummy work
                Thread.sleep(1000);
            }
            catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
            System.out.println("Email sent to " + recipient);
        });
    }

    public static void shutdown(){
        executor.shutdown();
    }
}

public class Main{
    public static void main(String []args){
        for(int i=0;i<25;i++){
            EmailService.sendEmail("user"+i+"@gmail.com");
        }
        EmailService.shutdown();
    }
}
