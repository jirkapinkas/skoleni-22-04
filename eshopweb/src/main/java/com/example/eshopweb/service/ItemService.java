package com.example.eshopweb.service;

import com.example.eshopweb.dto.ItemDto;
import com.example.eshopweb.entity.Item;
import com.example.eshopweb.mapper.ItemMapper;
import com.example.eshopweb.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    private final ItemMapper itemMapper;

    private final String serverPort;

    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper, @Value("${server.port}") String serverPort) {
        this.itemRepository = itemRepository;
        this.serverPort = serverPort;
        this.itemMapper = itemMapper;
    }

//    @PostConstruct
//    public void init() {
//        System.out.println("**********************************");
//        System.out.println(serverPort);
//        System.out.println("**********************************");
//    }

    public List<ItemDto> findAll() {
        return itemMapper.toDto(itemRepository.findAll());
    }

    @Transactional
    public Optional<ItemDto> findById(int id) {
        return itemRepository.findById(id)
                .map(itemMapper::toDto);
//        // POZOR!!! "item" je v managed stavu!!! Tzn. pred ukoncenim metody se provede UPDATE do databaze!!!
//        Optional<Item> optional = itemRepository.findById(id);
//        optional.ifPresent(item -> {
//            item.setName(item.getName().toUpperCase());
//        });
//        return optional.map(itemMapper::toDto);
    }

}
