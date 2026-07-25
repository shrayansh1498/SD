package BehaviouralDesignPatterns.IteratorPattern.Before;
import java.util.*;

class Video{
    String title;
    public Video(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
}
class YoutubePlaylist{
    private List<Video> videos = new ArrayList<>();
    public void addVideo(Video video){
        videos.add(video);
    }
    public List<Video> getVideos(){
        return videos;
    }
}

public class Before {
    public static void main(String[] args) {
        YoutubePlaylist playlist = new YoutubePlaylist();
        playlist.addVideo(new Video("Video 1"));
        playlist.addVideo(new Video("Video 2"));

        for(Video v : playlist.getVideos()){
            System.out.println(v.getTitle());
        }
    }
}
