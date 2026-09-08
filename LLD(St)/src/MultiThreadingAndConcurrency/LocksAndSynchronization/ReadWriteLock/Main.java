package MultiThreadingAndConcurrency.LocksAndSynchronization.ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class StockData{
    private double price = 100.0;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    //ReadWriteLock is used for Read heavy operations

    public void updatePrice(double newPrice){
        lock.writeLock().lock(); 
        //block if lock is already held by another thread
        //writeLock() blocks both read and write for other threads
        try{
            System.out.println(Thread.currentThread().getName() + " is updating the price to " + newPrice);
            price = newPrice;
        }
        finally{
            lock.writeLock().unlock();
        }
    }

    public void readPrice(){
        lock.readLock().lock(); 
        //block if lock is already held by another thread
        //readLock() blocks only write for other threads, they can still read
        try{
            System.out.println(Thread.currentThread().getName() + " read price " + price);
        }
        finally{
            lock.readLock().unlock();
        }
    }
}
public class Main {
    public static void main(String[] args) throws InterruptedException {
        StockData stockData = new StockData();
        Thread t1 = new Thread(() -> stockData.updatePrice(200.0), "Thread 1");
        Thread t2 = new Thread(() -> stockData.readPrice(), "Thread 2");
        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
