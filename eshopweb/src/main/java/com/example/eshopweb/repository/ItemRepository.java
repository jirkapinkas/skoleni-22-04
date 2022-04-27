package com.example.eshopweb.repository;

import com.example.eshopweb.entity.Item;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    List<Item> findByName(String name);

    List<Item> findByName(String name, Sort sort);

    List<Item> findByName(String name, Pageable pageable);

    // HQL / JPQL
    @Transactional(readOnly = true)
    @Query("select i.name from Item i where lower(i.name) like :name")
    List<String> findAllNames(@Param("name") String name);

    // SQL
    @Transactional(readOnly = true)
    @Query(value = "select count(*) from item", nativeQuery = true)
    long countItems();

    @Transactional
    @Modifying
    @Query("update Item i set i.price = i.price * 1.1")
    void increasePricesBy10Percent();

}
