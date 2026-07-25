package BehaviouralDesignPatterns.IteratorPattern;
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

interface PlayListIterator{
    boolean hasNext();
    Video next();
}

class YoutubePlaylistIterator implements PlayListIterator{
    private List<Video> videos;
    private int position;
    public YoutubePlaylistIterator(List<Video> videos){
        this.videos = videos;
        this.position = 0;
    }
    @Override
    public boolean hasNext(){
        return position < videos.size();
    }
    @Override
    public Video next(){
        return hasNext() ? videos.get(position++) : null;
    }
}
class YoutubePlaylistCopyRightIterator implements PlayListIterator{
    private List<Video> videos;
    private int position;
    public YoutubePlaylistCopyRightIterator(List<Video> videos){
        this.videos = videos;
        this.position = 0;
    }
    @Override
    public boolean hasNext(){
        return position < videos.size();
    }
    @Override
    public Video next(){
        //copy right logic
        return hasNext() ? videos.get(position++) : null;
    }
}

//Iterable Interface
interface Playlist{
    PlayListIterator createIterator();
}
//Iterable Class
class YoutubePlaylist implements Playlist{
    private List<Video> videos = new ArrayList<>();
    public void addVideo(Video video){
        videos.add(video);
    }
    @Override
    public PlayListIterator createIterator(){
        return new YoutubePlaylistIterator(videos);
    }
}

public class Main {
    public static void main(String[] args) {
        YoutubePlaylist playlist = new YoutubePlaylist();
        playlist.addVideo(new Video("Video 1"));
        playlist.addVideo(new Video("Video 2"));

        PlayListIterator iterator = playlist.createIterator();
        while(iterator.hasNext()){
            Video video = iterator.next();
            System.out.println(video.getTitle());
        }
        
    }
}
