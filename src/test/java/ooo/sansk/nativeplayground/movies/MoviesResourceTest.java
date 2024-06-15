package ooo.sansk.nativeplayground.movies;

import ooo.sansk.nativeplayground.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@IntegrationTest
class MoviesResourceTest {
    @Autowired
    private MovieResource resource;

    @Test
    void listMovies() {
        final var result = resource.getAll();

        final var expected = List.of(
                new Movie(1L, "Pulp Fiction", 1L),
                new Movie(2L, "Home Alone", 2L)
        );
        assertEquals(expected, result);
    }
}