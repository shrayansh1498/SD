package BehaviouralDesignPatterns.MediatorPattern;
import java.util.*;

interface DocumentSessionMediator{
    void broadcastChange(String change, User Sender);
    void join(User user);
}

class CollaborativeDocument implements DocumentSessionMediator{
    private List<User> users = new ArrayList<>();
    @Override
    public void join(User user){
        users.add(user);
    }
    @Override
    public void broadcastChange(String change, User Sender){
        for(User u : users){
            if(u != Sender){
                u.receiveChange(change, Sender);
            }
        }
    }
    
}

class User{
    protected String name;
    protected DocumentSessionMediator mediator;
    public User(String name, DocumentSessionMediator mediator){
        this.name = name;
        this.mediator = mediator;
    }

    public void makeChange(String change){
        System.out.println(name + " made a change: " + change);
        mediator.broadcastChange(change, this);
    }

    public void receiveChange(String change, User sender){
        System.out.println(name + " received change: " + change + " from " + sender.name);
    }

}

public class Main {
    public static void main(String[] args) {
        CollaborativeDocument document = new CollaborativeDocument();
        User alice = new User("Alice", document);
        User bob = new User("Bob", document);
        User charlie = new User("Charlie", document);
        document.join(alice);
        document.join(bob);
        document.join(charlie);
        alice.makeChange("Added project title");
        bob.makeChange("added project description");
    }
}
