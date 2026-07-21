package StructuralDesignPatterns.BridgePattern.Before;

interface PlayQuality{
    void play(String title);
}

class WebHDPlayer implements PlayQuality{
    @Override
    public void play(String title){
        System.out.println("Web Player: Playing " + title + " in HD quality");
    }
}

class MobileHDPlayer implements PlayQuality{
    @Override
    public void play(String title){
        System.out.println("Mobile Player: Playing " + title + " in HD quality");
    }
}

class SmartTVUltraHDPlayer implements PlayQuality{
    @Override
    public void play(String title){
        System.out.println("Smart TV Player: Playing " + title + " in Ultra HD quality");
    }
}

class Web4KPlayer implements PlayQuality{
    @Override
    public void play(String title){
        System.out.println("Web Player: Playing " + title + " in 4K quality");
    }
}

public class Before {
    public static void main(String[] args) {
        PlayQuality webHDPlayer = new WebHDPlayer();
        webHDPlayer.play("Movie 1");

        PlayQuality mobileHDPlayer = new MobileHDPlayer();
        mobileHDPlayer.play("Movie 2");

        PlayQuality smartTVUltraHDPlayer = new SmartTVUltraHDPlayer();
        smartTVUltraHDPlayer.play("Movie 3");

        PlayQuality web4KPlayer = new Web4KPlayer();
        web4KPlayer.play("Movie 4");
    }
}
