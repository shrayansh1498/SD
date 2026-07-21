package StructuralDesignPatterns.ProxyPattern;
import java.util.*;

interface videoDownloader {
    String downloadVideo(String videoURL);
}

class RealVideoDownloader implements videoDownloader {
    @Override
    public String downloadVideo(String videoURL) {
        //Caching, filtering, access
        return "Video content for " + videoURL;
    }
}

//Proxy with Cache
class cachedVideoDownloader implements videoDownloader {
    private RealVideoDownloader realVideoDownloader;
    private Map<String, String> cache;
    public cachedVideoDownloader() {
        this.realVideoDownloader = new RealVideoDownloader();
        this.cache = new HashMap<>();
    }
    @Override
    public String downloadVideo(String videoURL) {
        if (cache.containsKey(videoURL)) {
            System.out.println("Returning cached video content for URL: " + videoURL);
            return cache.get(videoURL);
        }
        System.out.println("Downloading video from URL: " + videoURL);
        String video = realVideoDownloader.downloadVideo(videoURL);
        cache.put(videoURL, video);
        return video;
    }
}

public class Main {
    public static void main(String[] args) {
        cachedVideoDownloader cachedVideoDownloader = new cachedVideoDownloader();
        String videoContent = cachedVideoDownloader.downloadVideo("https://example.com/video.mp4");
        String videoContent2 = cachedVideoDownloader.downloadVideo("https://example.com/video.mp4");
    }
}
