package movierater.moviecatalogservices.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import movierater.moviecatalogservices.model.Rating;
import movierater.moviecatalogservices.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class RatingDataService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "ratingFromCache")
    public UserRating rating(String userId) {
        UserRating userRating = restTemplate.getForObject("http://rating-data-service/rating/user/"+userId, UserRating.class);
        return userRating;
    }

    private UserRating ratingFromCache(String userId) {
        UserRating userRating = new UserRating();
        userRating.setRatings(Arrays.asList(new Rating("",0.0)));
        return userRating;
    }
}
