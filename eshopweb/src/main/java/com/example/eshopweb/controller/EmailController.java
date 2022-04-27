package com.example.eshopweb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.IntStream;

@Slf4j
@RestController
public class EmailController {

    @Lazy // nebo jeste lepe aby posilani emailu bylo v EmailService
    @Autowired
    private EmailController self;

    @GetMapping("/sendEmails") // Toto by melo byt POST, GET by mel byt idempotent!!!
    public void sendEmails() {
        IntStream.range(0, 100)
                .forEach(self::sendEmail);
    }

    @Async
    public void sendEmail(int i) {
        log.info("sending email {}", i);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
