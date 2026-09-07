package DeadlockAndPrevention.DeadlockExample;

import java.util.concurrent.*;
import java.util.*;

class BankAccount{
    private final String name;
    private int balance;

    public BankAccount(String name, int balance){
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public synchronized void deposit(int amount) {
        balance += amount;
    }

    public synchronized void withdraw(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}   

class TransferTask implements Runnable{
    private BankAccount from;
    private BankAccount to;
    private int amount;

    public TransferTask(BankAccount from, BankAccount to, int amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public void run() {
        synchronized (from) {
            System.out.println(Thread.currentThread().getName() + " locked " + from.getName());

            try{
                Thread.sleep(100);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            

            synchronized (to) {
                System.out.println(Thread.currentThread().getName() + " locked " + to.getName());
                from.withdraw(amount);
                to.deposit(amount);
                System.out.println("Transfer from " + from.getName() + " to " + to.getName() + " amount " + amount);    
            }
        }
    }
}

public class DeadlokExample {
    public static void main(String[] args) throws InterruptedException{
        BankAccount accountA = new BankAccount("Account-A", 1000); 
        BankAccount accountB = new BankAccount("Account-B", 1000);

        //Thread 1 : A->B
        Thread t1 = new Thread(new TransferTask(accountA, accountB, 200), "t1");
        //Thread 2 : B->A
        Thread t2 = new Thread(new TransferTask(accountB, accountA, 300), "t2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Finished");     //This never runs because of deadlock
    }
}
