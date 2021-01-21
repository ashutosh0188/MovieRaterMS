package movierater.moviecatalogservices.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import movierater.moviecatalogservices.model.CatalogItem;
import movierater.moviecatalogservices.model.Movie;
import movierater.moviecatalogservices.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieInfoService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "catalogItemFromCache")
    public CatalogItem catalogItem(Rating rating) {
        Movie movie = restTemplate.getForObject("http://movie-info-service/movie/"+rating.getMovieId(), Movie.class);
        return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
    }

    private CatalogItem catalogItemFromCache(Rating rating) {
        return new CatalogItem("Unable to find movie name", "", rating.getRating());
    }
}
