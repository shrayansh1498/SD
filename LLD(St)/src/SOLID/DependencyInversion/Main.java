package SOLID.DependencyInversion;

interface Recommendation {
    void recommend();
}
class TrendingRecommendation implements Recommendation {
    public void recommend() {
        System.out.println("Trending recommendation");
    }
}
class GenreRecommendation implements Recommendation {
    public void recommend() {
        System.out.println("Genre recommendation");
    }
}
class RecentRecommendation implements Recommendation {
    public void recommend() {
        System.out.println("Recent recommendation");
    }
}
class RecommendationAlgorithm {
    private Recommendation recommendation;
    public RecommendationAlgorithm(Recommendation recommendation) {
        this.recommendation = recommendation;
    }
    public void recommend() {
        recommendation.recommend();
    }
}

public class Main {
    public static void main(String[] args) {
        RecommendationAlgorithm recommendationAlgorithm = new RecommendationAlgorithm(new TrendingRecommendation());
        recommendationAlgorithm.recommend();
    }
}
