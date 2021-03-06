package com.test.app.service;

import com.test.app.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

//    public ItemService(@Lazy ItemRepository itemRepository) {
//        this.itemRepository = itemRepository;
//    }

    @PostConstruct
    public void init() {
        System.out.println("ItemService constructed!");
    }

    public String getCount() {
        return "items count = " + itemRepository.count();
    }

}
