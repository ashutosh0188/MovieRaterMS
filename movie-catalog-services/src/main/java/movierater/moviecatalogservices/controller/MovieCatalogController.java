package movierater.moviecatalogservices.controller;

import movierater.moviecatalogservices.model.CatalogItem;
import movierater.moviecatalogservices.model.UserRating;
import movierater.moviecatalogservices.service.MovieInfoService;
import movierater.moviecatalogservices.service.RatingDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RatingDataService ratingDataService;

    @Autowired
    private MovieInfoService movieInfoService;

    @GetMapping("/items/{userId}")
    public List<CatalogItem> catalogItem(@PathVariable String userId) {
        UserRating userRating = ratingDataService.rating(userId);
        return userRating
                .getRatings()
                .stream()
                .map(r-> movieInfoService.catalogItem(r))
                .collect(Collectors.toList());
    }
}
