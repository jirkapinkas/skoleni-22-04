package com.example.eshopweb.controller;

import com.example.eshopweb.dto.ItemDto;
import com.example.eshopweb.entity.Item;
import com.example.eshopweb.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping("/item")
@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    // http://localhost:8080/item
    @GetMapping
    public List<ItemDto> items() {
        return itemService.findAll();
    }

    // http://localhost:8080/item/1
    @GetMapping("/{id}")
    public Optional<ItemDto> item(@PathVariable int id) {
        return itemService.findById(id);
    }

}
