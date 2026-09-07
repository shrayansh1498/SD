package MultiThreadingAndConcurrency.ThreadSafetyAndSynchronization.AtomicVariables;

import java.util.concurrent.atomic.AtomicInteger;

class PurchaseCounter{
    private AtomicInteger likes = new AtomicInteger(0);

    public void increment(){
        int prev, next;
        do{
            prev=likes.get();   //user1->prev=10, user2->prev=10
            next=prev+1;        //user1->next=11, user2->next=11
        } while(!likes.compareAndSet(prev, next));      //user1->prev=11, user2->prev=10
        //user1->prev=11, user2->prev=10. It is beacuse compareAndSet() is called ar hardware level and only one user can call it at a time
        //This prevents race condition without locking and has high performance
    }

    public int getCount(){
        return likes.get();
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

