package ooo.sansk.nativeplayground.books;

import ooo.sansk.nativeplayground.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@IntegrationTest
class BookResourceTest {
    @Autowired
    private BookResource resource;

    @Test
    void listBooks() {
        final var result = resource.getAll();

        final var expected = List.of(
                new Book("1", "Percy Jackson and the Lightning Thief", 1L),
                new Book("2", "Clean Code", 2L)
        );
        assertEquals(expected, result);
    }
}