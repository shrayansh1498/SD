package MultiThreadingAndConcurrency.LocksAndSynchronization.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

class TicketBooking{
    private int availableSeats=1;
    private final ReentrantLock lock=new ReentrantLock();
    // ReentrantLock is a mutex lock

    public void bookTickets(String user){
        System.out.println(user + " is trying to book...");
        lock.lock();    //block if lock is already held by another thread

        try{
            System.out.println("Lock acquired");
            if(availableSeats>0){
                availableSeats--;
                System.out.println("Tickets Booked Successfully for " + user);
            }
            else{
                System.out.println("Tickets Unavailable for " + user);
            }
        }
        finally{
            System.out.println(user + " is releasing the lock");
            lock.unlock();  
        }
    }
}
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TicketBooking ticketBooking=new TicketBooking();
        Thread t1=new Thread(() -> ticketBooking.bookTickets("User 1"));
        Thread t2=new Thread(() -> ticketBooking.bookTickets("User 2"));
        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
