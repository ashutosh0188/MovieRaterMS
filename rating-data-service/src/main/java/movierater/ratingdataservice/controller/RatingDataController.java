package movierater.ratingdataservice.controller;

import movierater.ratingdataservice.model.Rating;
import movierater.ratingdataservice.model.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingDataController {

    @GetMapping("/{movieId}")
    public Rating rating(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 4.0);
    }

    @GetMapping("/user/{userId}")
    public UserRating userMovieRating(@PathVariable("userId") String userId) {
        List<Rating> ratings = Arrays.asList(new Rating("1234", 4.0), new Rating("5467", 3.0));
        UserRating ur = new UserRating();
        ur.setRatings(ratings);
        return ur;
    }
}
