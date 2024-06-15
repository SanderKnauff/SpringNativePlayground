package ooo.sansk.nativeplayground.books;

import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.data.annotation.Id;

@RegisterReflectionForBinding(Author.class)
public record Author(
    @Id long id,
    String name,
    String bio
) {
}
