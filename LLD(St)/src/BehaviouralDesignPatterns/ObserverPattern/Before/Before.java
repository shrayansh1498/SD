package BehaviouralDesignPatterns.ObserverPattern.Before;
class YoutubeChannel{
    public void uploadNewVideo(String videoTitle){
        System.out.println("Uploading: " + videoTitle);

        //Manully notify subscribers
        System.out.println("Sending email to user1@email.com");
        System.out.println("Pushing in-app notification to user2@email.com");
    }
}
public class Before {
    public static void main(String[] args) {
        
    }
}
