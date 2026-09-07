package DeadlockAndPrevention.DeadlockPreventionLockOrderingExample;

import java.util.*;
import java.util.concurrent.*;

public class LockOrdering {
    static class Resource{
        int id;
        int value;
        public Resource(int id, int value){
            this.id = id;
            this.value = value;
        }
    }

    public static void transfer(Resource a, Resource b, int amount) {
        Resource locks[] = new Resource[]{a,b};
        Arrays.sort(locks, Comparator.comparingInt(r -> r.id)); //Lock ordering

        synchronized (locks[0]) {
            System.out.println(Thread.currentThread().getName() + " locked " + locks[0].id);

            try{
                Thread.sleep(100);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            
            synchronized (locks[1]) {
                System.out.println(Thread.currentThread().getName() + " locked " + locks[1].id);
                System.out.println("Transfer from " + a.id + " to " + b.id + " amount " + amount);    
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Resource r1 = new Resource(1, 10);
        Resource r2 = new Resource(2, 20);

        Runnable task1 = () -> transfer(r1, r2, 50);
        Runnable task2 = () -> transfer(r2, r1, 30);

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
