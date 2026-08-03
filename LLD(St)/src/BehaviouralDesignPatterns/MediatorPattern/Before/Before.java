package BehaviouralDesignPatterns.MediatorPattern.Before;

import java.util.*;
class User{
    private String name;
    private List<User> others;

    public User(String name) {
        this.name = name;
        this.others = new ArrayList<>();
    }

    public void addCollaborator(User user){
        others.add(user);
    }

    public void makeChange(String change){
        System.out.println(name + "made a change: " + change);
        for(User u : others){
            u.receiveChange(change, this);
        }
    }

    public void receiveChange(String change, User from){
        System.out.println(name + "received change: " + change + " from " + from.name);
    }
}

// Each user has referencesto every other users
// Adding/removing a user breaks the structure
// Hard to orchestrate roles (editor/viewers/admin)
// Difficult to manage permissions, states and notifications

public class Before {
    
}
