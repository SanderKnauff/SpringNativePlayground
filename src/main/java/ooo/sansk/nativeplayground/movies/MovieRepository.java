package ooo.sansk.nativeplayground.movies;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepository {
    private final NamedParameterJdbcTemplate template;

    public MovieRepository(@Qualifier("movieJdbcTemplate") NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public List<Movie> findAll() {
        final var query = """
                SELECT
                    id,
                    title,
                    director AS director_id
                FROM Movie;
                """;

        return template.query(query, DataClassRowMapper.newInstance(Movie.class));
    }
}
