package zy.springbootdemo.database.databasedemo.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource(Environment ev) {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(ev.getProperty("spring.datasource.url"));
        ds.setUsername(ev.getProperty("spring.datasource.username"));
        ds.setPassword(ev.getProperty("spring.datasource.password"));
        ds.setDriverClassName(ev.getProperty("spring.datasource.driver-class-name"));
        return ds;
    }
}
