package MultiThreadingAndConcurrency.LocksAndSynchronization.ExpiringReentrantLock;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class TicketBooking{
    private final ReentrantLock lock=new ReentrantLock();
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    // ReentrantLock is a mutex lock
    private volatile boolean isLocked = false;

    public void unlockSafely() {
        if (lock.isHeldByCurrentThread() || isLocked) {
            isLocked = false;
            if(lock.isHeldByCurrentThread())
            {
                lock.unlock();
                System.out.println("Lock released");
            }
        }
    }

    public boolean tryLockWithExpiry(long timeOutMillis){
        boolean acquired = lock.tryLock();
        //trylock() does not keep waiting when lock is not available, while lock() keeps waiting when lock is not available
        if(acquired){
            isLocked=true;

            //Schedule unlock after timeout
            scheduler.schedule(() -> {
                if(lock.isHeldByCurrentThread() || isLocked){
                    System.out.println("Auto releasing lock after timeout");
                    unlockSafely();
                }
            }, timeOutMillis, TimeUnit.MILLISECONDS);
        }
        //logic for user
        return acquired;
    }
}
