package MultiThreadingAndConcurrency.LocksAndSynchronization.Semaphores;

import java.util.concurrent.Semaphore;

class PremiumAccount{
    private final Semaphore deviceSlots;

    public PremiumAccount(int maxDevice) {
        this.deviceSlots = new Semaphore(maxDevice);
    }

    public boolean login(String user){
        System.out.println(user + " is trying to login...");

        if(deviceSlots.tryAcquire()){
            System.out.println("Login successful for " + user);
            return true;
        }
        else
        {
            System.out.println("Login failed for " + user);
            return false;
        }
    }

    public void logout(String user){
        System.out.println(user + " is logging out...");
        deviceSlots.release();
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        PremiumAccount premiumAccount = new PremiumAccount(2);
        Thread t1 = new Thread(() -> premiumAccount.login("User 1"));
        Thread t2 = new Thread(() -> premiumAccount.login("User 2"));
        Thread t3 = new Thread(() -> premiumAccount.login("User 3"));
        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }
}
