package StructuralDesignPatterns.ProxyPattern.Before;
class RealVideoDownloader {
    public String downloadVideo(String videoURL) {
        //Caching, filtering, access
        System.out.println("Downloading video from URL: " + videoURL);
        return "Video content for " + videoURL;
    }
}

public class Before {
    public static void main(String[] args) {
        RealVideoDownloader realVideoDownloader = new RealVideoDownloader();
        String videoContent = realVideoDownloader.downloadVideo("https://example.com/video.mp4");
        RealVideoDownloader realVideoDownloader2 = new RealVideoDownloader();
        String videoContent2 = realVideoDownloader2.downloadVideo("https://example.com/video.mp4");
    }
}
