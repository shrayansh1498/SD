package MultiThreadingAndConcurrency.ThreadpoolsAndExecutors.FutureExampleThreadpoolAndExecutors;

import java.util.concurrent.*;

class Main{

    public static void main(String []args) throws InterruptedException, ExecutionException{
        ExecutorService executor = Executors.newFixedThreadPool(2);
        //like newFixedThreadPool, we also have newScheduledThreadPool, newCachedThreadPool

        //submit is used instead of execute

        Future<Integer> future = executor.submit(() -> {
            try {
                Thread.sleep(1000);
                return 0;
            } 
            catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
            return 1;
        });

        System.out.println("Doing other work...");

        Integer result = future.get();  //blocks until result is ready
        System.out.println("Result : " + result);
        executor.shutdown();

    }
}
