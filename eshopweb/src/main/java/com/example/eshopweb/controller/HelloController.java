package com.example.eshopweb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
public class HelloController {

    // http://localhost:8080/hello
    @GetMapping("/hello")
    public Message hello() {
        return new Message("Spring Boot Works! :-)");
    }

    // http://localhost:8080/dog
    @GetMapping(path = "/dog", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] dog() throws IOException {
        return Files.readAllBytes(Path.of("files", "dog.jpg"));
    }

    // http://localhost:8080/file?name=dog.jpg
    // http://localhost:8080/file?name=file.xml
    @GetMapping("/file")
    public ResponseEntity<Object> file(@RequestParam String name) throws IOException {
        Path path = Path.of("files", name);
        if(!Files.exists(path)) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(new Message("File '" + name + "' does not exist!"));
        }
        byte[] bytes = Files.readAllBytes(path);
        MediaType mediaType;
        if(name.endsWith(".jpg")) {
            mediaType = MediaType.IMAGE_JPEG;
        } else if(name.endsWith(".xml")) {
            mediaType = MediaType.APPLICATION_XML;
        } else {
            mediaType = MediaType.APPLICATION_JSON;
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(mediaType)
                .body(bytes);
    }


}
