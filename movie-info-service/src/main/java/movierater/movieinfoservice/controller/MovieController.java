package movierater.movieinfoservice.controller;

import movierater.movieinfoservice.model.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @GetMapping("/{movieId}")
    public Movie movie(@PathVariable("movieId") String movieId) {
        return new Movie(movieId, "Test movie name");
    }
}
