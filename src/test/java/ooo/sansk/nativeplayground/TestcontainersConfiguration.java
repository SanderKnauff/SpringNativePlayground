package ooo.sansk.nativeplayground;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
public class TestcontainersConfiguration {
    @Bean
    PostgreSQLContainer<?> postgresContainer(DynamicPropertyRegistry dynamicPropertyRegistry) {
        final var container = new PostgreSQLContainer<>(DockerImageName.parse("postgres:latest"))
                .withUsername("Bookworm")
                .withPassword("Wormbook")
                .withInitScript("init-books.sql")
                .withReuse(true);

        dynamicPropertyRegistry.add("spring.datasource.books.url", container::getJdbcUrl);
        dynamicPropertyRegistry.add("spring.datasource.books.username", container::getUsername);
        dynamicPropertyRegistry.add("spring.datasource.books.password", container::getPassword);
        dynamicPropertyRegistry.add("spring.datasource.books.driver", container::getDriverClassName);

        return container;
    }

    @Bean
    PostgreSQLContainer<?> secondaryContainer(DynamicPropertyRegistry dynamicPropertyRegistry) {
        final var container = new PostgreSQLContainer<>(DockerImageName.parse("postgres:latest"))
                .withUsername("Siskel")
                .withPassword("Ebert")
                .withInitScript("init-movies.sql")
                .withReuse(true);

        dynamicPropertyRegistry.add("spring.datasource.movies.url", container::getJdbcUrl);
        dynamicPropertyRegistry.add("spring.datasource.movies.username", container::getUsername);
        dynamicPropertyRegistry.add("spring.datasource.movies.password", container::getPassword);
        dynamicPropertyRegistry.add("spring.datasource.movies.driver", container::getDriverClassName);

        return container;
    }
}
