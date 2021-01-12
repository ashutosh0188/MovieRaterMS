package movierater.moviecatalogservices.model;

public class CatalogItem {
    private String movie;
    private String description;
    private double ratings;

    public CatalogItem(String movie, String description, double ratings) {
        this.movie = movie;
        this.description = description;
        this.ratings = ratings;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRatings() {
        return ratings;
    }

    public void setRatings(double ratings) {
        this.ratings = ratings;
    }
}
