package ooo.sansk.nativeplayground.movies;

import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.data.annotation.Id;

@RegisterReflectionForBinding(Director.class)
public record Director(
    @Id long id,
    String name
) {
}
