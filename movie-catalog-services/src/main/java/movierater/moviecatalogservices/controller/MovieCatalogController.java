package movierater.moviecatalogservices.controller;

import movierater.moviecatalogservices.model.CatalogItem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @GetMapping("/items/{userId}")
    public List<CatalogItem> catalogItem(@PathVariable String userId) {
        return Collections.singletonList(new CatalogItem("Titanic", "An iternal love story", 4.0));
    }
}
