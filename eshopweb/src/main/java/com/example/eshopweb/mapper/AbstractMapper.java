package com.example.eshopweb.mapper;

import com.example.eshopweb.dto.ItemDto;
import com.example.eshopweb.entity.Item;
import org.mapstruct.Mapper;

import java.util.List;

public interface AbstractMapper<ENTITY, DTO> {

    DTO toDto(ENTITY entity);

    List<DTO> toDto(List<ENTITY> entities);

    ENTITY toEntity(DTO entity);

    List<ENTITY> toEntity(List<DTO> entities);


}
