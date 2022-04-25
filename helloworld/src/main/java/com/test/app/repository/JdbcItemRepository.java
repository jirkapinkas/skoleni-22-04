package com.test.app.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Profile("jdbc")
@Repository
@RequiredArgsConstructor
public class JdbcItemRepository implements ItemRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public long count() {
        return jdbcTemplate.queryForObject("select count(*) from item", Long.class);
    }

}
