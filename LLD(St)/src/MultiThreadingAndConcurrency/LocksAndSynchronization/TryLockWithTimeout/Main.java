package MultiThreadingAndConcurrency.LocksAndSynchronization.TryLockWithTimeout;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class TicketBookingTryLock{
    private int availableSeats=1;
    private final ReentrantLock lock=new ReentrantLock();
    // ReentrantLock is a mutex lock

    public void bookTickets(String user){
        System.out.println(user + " is trying to book...");

        boolean lockAcquired = false;
       

        try{
            //
            lockAcquired = lock.tryLock(2, TimeUnit.SECONDS); 
            //trylock() does not keep waiting when lock is not available, while lock() keeps waiting when lock is not availablelock(); 
            //trylock() with timeout does however waits for the specidfied timeout
            
            if(lockAcquired)
            {
                System.out.println("Lock acquired for " + user);
                if(availableSeats>0){
                    availableSeats--;
                    System.out.println("Tickets Booked Successfully for " + user);
                }
                else{
                    System.out.println("Tickets Unavailable for " + user);
                }
            }
            else{
                System.out.println("Could not acquire lock, try again later");
            }
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        finally{
            if(lockAcquired)
            {
                System.out.println(user + " is releasing the lock");
                lock.unlock(); 
            }
        }
    }
}
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TicketBookingTryLock ticketBooking=new TicketBookingTryLock();
        Thread t1=new Thread(() -> ticketBooking.bookTickets("User 1"));
        Thread t2=new Thread(() -> ticketBooking.bookTickets("User 2"));
        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}

