package BehaviouralDesignPatterns.ObserverPattern;
import java.util.*;
//Observer interface
interface Subscriber{
    void update(String videoTitle);
}

//concrete observer
class EmailSubscriber implements Subscriber{
    private String email;

    public EmailSubscriber(String email){
        this.email = email;
    }

    @Override
    public void update(String videoTitle){
        System.out.println("Email sent to " + email + " for video: " + videoTitle);
    }
}
class MobileAppSubscriber implements Subscriber{
    private String username;

    public MobileAppSubscriber(String username){
        this.username = username;
    }

    @Override
    public void update(String videoTitle){
        System.out.println("In-app notification for " + username + " for video: " + videoTitle);
    }
}

//Subject interface
interface Channel{
    void Subscribe(Subscriber subscriber);
    void Unsubscribe(Subscriber subscriber);
    void notifySubscribers(String videoTitle);
}

//Notify subscriber
class YoutubeChannel implements Channel{
    private List<Subscriber> subscribers = new ArrayList<>();
    private String channelName;

    public YoutubeChannel(String channelName){
        this.channelName = channelName;
    }
    @Override
    public void Subscribe(Subscriber subscriber){
        subscribers.add(subscriber);
    }
    @Override
    public void Unsubscribe(Subscriber subscriber){
        subscribers.remove(subscriber);
    }
    @Override
    public void notifySubscribers(String videoTitle){
        for(Subscriber subscriber : subscribers){
            subscriber.update(videoTitle);
        }
    }
    public void uploadVideo(String videoTitle){
        System.out.println(channelName + " Uploaded: " + videoTitle);
        notifySubscribers(videoTitle);
    }
}
public class Main {
    public static void main(String[] args) {
        YoutubeChannel youtubeChannel = new YoutubeChannel("ShrayanshTech");
        EmailSubscriber emailSubscriber = new EmailSubscriber("user1@email.com");
        MobileAppSubscriber mobileAppSubscriber = new MobileAppSubscriber("user2@email.com");
        youtubeChannel.Subscribe(emailSubscriber);
        youtubeChannel.Subscribe(mobileAppSubscriber);
        youtubeChannel.uploadVideo("Java Tutorial");
    }
}
