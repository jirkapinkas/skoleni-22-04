package com.test.app;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Profile("jdbc")
@Configuration
public class JdbcConfiguration {

    @Bean
    public DataSource dataSource() {
        System.out.println("data source constructed!");
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:hsqldb:hsql://localhost/eshop");
        ds.setUsername("sa");
        ds.setPassword("");
        return ds;
    }

    // Pozor! Toto funguje pouze kdyz je u tridy @Configuration
//    @Bean
//    public JdbcTemplate jdbcTemplate() {
//        return new JdbcTemplate(dataSource());
//    }

    // NEBO:
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
