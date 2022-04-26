package com.example.eshopweb.service;

import com.example.eshopweb.entity.Item;
import com.example.eshopweb.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final String serverPort;

    public ItemService(ItemRepository itemRepository, @Value("${server.port}") String serverPort) {
        this.itemRepository = itemRepository;
        this.serverPort = serverPort;
    }

//    @PostConstruct
//    public void init() {
//        System.out.println("**********************************");
//        System.out.println(serverPort);
//        System.out.println("**********************************");
//    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Optional<Item> findById(int id) {
        return itemRepository.findById(id);
    }

}
