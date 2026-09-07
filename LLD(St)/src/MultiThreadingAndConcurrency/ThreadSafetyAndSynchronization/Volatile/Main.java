package MultiThreadingAndConcurrency.ThreadSafetyAndSynchronization.Volatile;

class PurchaseCounter{
    private volatile int count=0;
    // Volatile keyword is when one thread writes and other threads only read.
    // It is not thread safe i.e. it is not atomic.
    // Volatile always reads and writes to main memory, not cached copy in register
    public void increment(){
        count++;
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


        Thread t1=new Thread(task);
        Thread t2=new Thread(task);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Count: " + counter.getCount());
    }
}
