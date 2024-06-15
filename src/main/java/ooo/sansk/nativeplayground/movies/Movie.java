package ooo.sansk.nativeplayground.movies;

import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.data.annotation.Id;

@RegisterReflectionForBinding(Movie.class)
public record Movie(
    @Id Long id,
    String title,
    Long directorId
) {
}
