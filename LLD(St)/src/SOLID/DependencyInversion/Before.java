package SOLID.DependencyInversion;
class TrendingRecommendation {
    public void recommend() {
        System.out.println("Trending recommendation");
    }
}
class GenreRecommendation {
    public void recommend() {
        System.out.println("Genre recommendation");
    }
}
class RecentRecommendation {
    public void recommend() {
        System.out.println("Recent recommendation");
    }
}

public class Before {
    public static void main(String[] args) {
        TrendingRecommendation trendingRecommendation = new TrendingRecommendation();
        trendingRecommendation.recommend();
        GenreRecommendation genreRecommendation = new GenreRecommendation();
        genreRecommendation.recommend();
        RecentRecommendation recentRecommendation = new RecentRecommendation();
        recentRecommendation.recommend();
    }
}
