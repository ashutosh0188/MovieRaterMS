package movierater.moviecatalogservices.controller;

import movierater.moviecatalogservices.model.CatalogItem;
import movierater.moviecatalogservices.model.Movie;
import movierater.moviecatalogservices.model.Rating;
import movierater.moviecatalogservices.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/items/{userId}")
    public List<CatalogItem> catalogItem(@PathVariable String userId) {
        UserRating userRating = restTemplate.getForObject("http://rating-data-service/rating/user/"+userId, UserRating.class);
        List<CatalogItem> res = userRating.getRatings().stream().map(r-> {
            Movie movie = restTemplate.getForObject("http://movie-info-service/movie/"+r.getMovieId(), Movie.class);
            return new CatalogItem(movie.getName(), "An iternal love story", r.getRating());
        }).collect(Collectors.toList());
        System.out.println(res);
        return res;
    }
}
