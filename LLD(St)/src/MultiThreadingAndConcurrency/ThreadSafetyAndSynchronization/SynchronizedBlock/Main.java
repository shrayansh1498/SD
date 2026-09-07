package MultiThreadingAndConcurrency.ThreadSafetyAndSynchronization.SynchronizedBlock;

class PurchaseCounter{
    private int count=0;
    public void increment(){
        // Code before synchronizationBlock
        synchronized (this){
            count++;
        }
        
        // Code after synchronizationBlock
    }

    public int getCount(){
        return count;
    }
}

public class Main{
    public static void main(String[] args) throws InterruptedException {
        PurchaseCounter counter=new PurchaseCounter();

        Runnable task = () -> {
            for(int i=0;i<1000;i++){
                counter.increment();
            }
        };

        //Anonymous method
        // Runnable task = new Runnable() {
        //     @Override
        //     public void run() {
        //        for (int i = 0; i < 1000; i++) {
        //              counter.increment();
        //         }
        //     }
        // };

        //Runnable method
        // public Runnable createTask() {
        //     return () -> {
        //         for (int i = 0; i < 1000; i++) {
        //             counter.increment();
        //         }
        //     };
        // }

        // Runnable task = createTask();
        // Thread thread = new Thread(task);
        // thread.start();



        //Runnable class inheritance
        // class CounterTask implements Runnable {
        //     @Override
        //     public void run() {
        //         for (int i = 0; i < 1000; i++) {
        //             counter.increment();
        //         }
        //     }
        // }
        // Runnable task = new CounterTask();
        // Thread thread = new Thread(task);
        // thread.start();


        Thread t1=new Thread(task);
        Thread t2=new Thread(task);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Count: " + counter.getCount());
    }
}
