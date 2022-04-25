package com.test.app;

import com.test.app.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Main.class);

        ItemService itemService = applicationContext.getBean(ItemService.class);

        System.out.println(itemService.getCount());

        applicationContext.close();
    }

}
