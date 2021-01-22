package movierater.moviecatalogservices.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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

    @HystrixCommand(fallbackMethod = "catalogItemFromCache", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "6"), //no of request which needs to be measured for tripping circuit
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "70"), //the percentage of failed request on the basis threshold defined
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"), //sleep thread to further call to the failed service, after circuit trips
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000") //time duration to wait for response before failing that request
    })
    public CatalogItem catalogItem(Rating rating) {
        Movie movie = restTemplate.getForObject("http://movie-info-service/movie/"+rating.getMovieId(), Movie.class);
        return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
    }

    public CatalogItem catalogItemFromCache(Rating rating) {
        return new CatalogItem("Unable to find movie name", "", rating.getRating());
    }
}
