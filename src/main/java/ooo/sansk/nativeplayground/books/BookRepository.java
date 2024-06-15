package ooo.sansk.nativeplayground.books;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {
    private final NamedParameterJdbcTemplate template;

    public BookRepository(@Qualifier("bookJdbcTemplate") NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public List<Book> findAll() {
        final var query = """
                SELECT
                    isbn,
                    title,
                    author AS author_id
                FROM Book;
                """;
        return template.query(query, DataClassRowMapper.newInstance(Book.class));
    }
}
