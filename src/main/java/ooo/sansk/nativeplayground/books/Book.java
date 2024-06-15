package ooo.sansk.nativeplayground.books;

import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.data.annotation.Id;

@RegisterReflectionForBinding(Book.class)
public record Book(
    @Id String isbn,
    String title,
    long authorId
) {
}
