package ooo.sansk.nativeplayground.books;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class BookJdbcConfiguration {
    @Bean("bookDataSourceProperties")
    @ConfigurationProperties("spring.datasource.books")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean("bookDataSource")
    public DataSource dataSource(@Qualifier("bookDataSourceProperties") DataSourceProperties properties) {
        return properties
                .initializeDataSourceBuilder()
                .build();
    }

    @Bean("bookJdbcTemplate")
    public NamedParameterJdbcTemplate jdbcOperations(@Qualifier("bookDataSource") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
