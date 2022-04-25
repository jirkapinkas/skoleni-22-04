package com.test.app;

import com.test.app.service.ItemService;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Configuration
@ComponentScan
public class Main {

    public static void main(String[] args) {
        // Tohle funguje s nastavenim profilu:
        // -Dspring.profiles.active=dummy
        // -Dspring.profiles.active=jdbc
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Main.class);

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.getEnvironment().setActiveProfiles("dummy");
        applicationContext.register(Main.class);
        applicationContext.refresh();

        ItemService itemService = applicationContext.getBean(ItemService.class);

        System.out.println(itemService.getCount());

        applicationContext.close();
    }

}
