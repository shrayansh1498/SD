package ProducerConsumerProblem.MultipleProducerConsumer;

import java.util.*;
class Submission{
    private static int idCounter = 1;
    private final int submissionId;
    private final String userName;

    public Submission(String userName) {
        this.userName = userName;
        this.submissionId = idCounter++;
    }
    public int getSubmissionId() {
        return submissionId;
    }
    public String getUserName() {
        return userName;
    }
}

class SubmissionQueue{
    private final Queue<Submission> queue = new LinkedList<Submission>();
    private final int MAX_CAPACITY = 5;
    
    //Producer
    public synchronized void submit(Submission submission) throws InterruptedException {
        while(queue.size() == MAX_CAPACITY){
            System.out.println("Queue is full." + submission.getUserName() + " is waiting...");
            wait();
        }
        queue.add(submission);
        System.out.println("Submission added: " + submission.getSubmissionId() + " by " + submission.getUserName());
        notifyAll(); // Notify consumers that a new submission is available
    }

    //Consumer
    public synchronized Submission consume(String judgeName) throws InterruptedException {
        while(queue.isEmpty()){
            System.out.println("Queue is empty. " + judgeName + " is waiting...");
            wait();
        }
        Submission submission = queue.poll();
        System.out.println(judgeName + " is processing submission: " + submission.getSubmissionId() + " by " + submission.getUserName());
        notifyAll(); // Notify producers that space is available
        return submission;
    }

}
public class Main {
    public static void main(String[] args) throws InterruptedException {
        SubmissionQueue queue = new SubmissionQueue();
        Thread producerThread = new Thread(() -> {
            try {
                queue.submit(new Submission("User 1"));
                queue.submit(new Submission("User 2"));
                queue.submit(new Submission("User 3"));
                queue.submit(new Submission("User 4"));
                queue.submit(new Submission("User 5"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Producer Thread");
        Thread consumerThread = new Thread(() -> {
            try {
                queue.consume("Judge 1");
                queue.consume("Judge 2");
                queue.consume("Judge 3");
                queue.consume("Judge 4");
                queue.consume("Judge 5");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Consumer Thread");
        producerThread.start();
        consumerThread.start();
        producerThread.join();
        consumerThread.join();
        System.out.println("All submissions have been processed."); // Output: All submissions have been processed.
    }
}
