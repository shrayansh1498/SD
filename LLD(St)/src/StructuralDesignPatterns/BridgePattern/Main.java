package StructuralDesignPatterns.BridgePattern;
import java.util.*;

interface VideoQuality{
    void play(String title);
}

class SDQuality implements VideoQuality{
    @Override
    public void play(String title){
        System.out.println("Playing " + title + " in SD quality");
    }
}

class HDQuality implements VideoQuality{
    @Override
    public void play(String title){
        System.out.println("Playing " + title + " in HD quality");
    }
}

class UltraHDQuality implements VideoQuality{
    @Override
    public void play(String title){
        System.out.println("Playing " + title + " in Ultra HD quality");
    }
}

class K4Quality implements VideoQuality{
    @Override
    public void play(String title){
        System.out.println("Playing " + title + " in 4K quality");
    }
}

class K8Quality implements VideoQuality{
    @Override
    public void play(String title){
        System.out.println("Playing " + title + " in 8K quality");
    }
}

abstract class VideoPlayer {
    protected VideoQuality videoQuality;

    public VideoPlayer(VideoQuality videoQuality) {
        this.videoQuality = videoQuality;
    }

    public abstract void play(String title);
}

class WebPlayer extends VideoPlayer {
    public WebPlayer(VideoQuality videoQuality) {
        super(videoQuality);
    }

    @Override
    public void play(String title) {
        System.out.print("Web Player: ");
        videoQuality.play(title);
    }
}

class MobilePlayer extends VideoPlayer {
    public MobilePlayer(VideoQuality videoQuality) {
        super(videoQuality);
    }

    @Override
    public void play(String title) {
        System.out.print("Mobile Player: ");
        videoQuality.play(title);
    }
}

public class Main {
    public static void main(String[] args) {
        VideoPlayer videoPlayer = new WebPlayer(new HDQuality());
        videoPlayer.play("Movie 1");

        VideoPlayer mobileHDPlayer = new MobilePlayer(new HDQuality());
        mobileHDPlayer.play("Movie 2");

        VideoPlayer smartTVUltraHDPlayer = new WebPlayer(new UltraHDQuality());
        smartTVUltraHDPlayer.play("Movie 3");

        VideoPlayer web4KPlayer = new WebPlayer(new K4Quality());
        web4KPlayer.play("Movie 4");
    }
}
}
