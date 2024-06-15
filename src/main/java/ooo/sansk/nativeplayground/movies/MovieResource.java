package ooo.sansk.nativeplayground.movies;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieResource {
    private MovieRepository repository;

    public MovieResource(MovieRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Movie> getAll() {
        return this.repository.findAll();
    }
}
