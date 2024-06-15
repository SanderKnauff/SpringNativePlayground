package ooo.sansk.nativeplayground.movies;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class MovieJdbcConfiguration {
    @Bean("movieDataSourceProperties")
    @ConfigurationProperties("spring.datasource.movies")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean("movieDataSource")
    public DataSource dataSource(@Qualifier("movieDataSourceProperties") DataSourceProperties properties) {
        return properties
                .initializeDataSourceBuilder()
                .build();
    }

    @Bean("movieJdbcTemplate")
    public NamedParameterJdbcTemplate jdbcOperations(@Qualifier("movieDataSource") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
