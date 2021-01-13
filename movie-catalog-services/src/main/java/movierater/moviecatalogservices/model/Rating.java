package movierater.moviecatalogservices.model;

public class Rating {
    private String movieId;
    private double rating;

    public Rating() {
        //no args constructor for unmarshalling this
    }

    public Rating(String movieId, double rating) {
        this.movieId = movieId;
        this.rating = rating;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
