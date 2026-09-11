package ProducerConsumerProblem.SingleProducerConsumer;

class CoffeeMachine{
    private boolean isCoffeeReady = false;

    public synchronized void makeCoffee() throws InterruptedException{
        //while is being used instead of if block because of spurious wakeups
        //Spurious wakeups happen when a thread is woken up by a spurious interrupt
        //Java threads can sometime wake up from wait() without a call to notify() due to spurious wakeups
        while(isCoffeeReady){
            wait(); 
        }

        System.out.println("Making coffee...");
        Thread.sleep(1000);
        isCoffeeReady = true;
        System.out.println("Coffee is ready");
        notify();   //Notify consumer
    }

    public synchronized void drinkCoffee() throws InterruptedException{
        //while is being used instead of if block because of spurious wakeups
        //Spurious wakeups happen when a thread is woken up by a spurious interrupt
        //Java threads can sometime wake up from wait() without a call to notify() due to spurious wakeups
        while(!isCoffeeReady){
            wait(); 
        }

        System.out.println("Consuming coffee...");
        Thread.sleep(1000);
        isCoffeeReady = false;
        System.out.println("Ready for next cup");
        notify();   //Notify producer
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException{
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Thread producer = new Thread(() -> {
            while(true)
            {
                try {
                    coffeeMachine.makeCoffee();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Producer");
        Thread consumer = new Thread(() -> {
            while(true)
            {
                try {
                    coffeeMachine.drinkCoffee();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
        }, "Consumer");
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }
}
