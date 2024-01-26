package com.group1.mapper;


import com.group1.dto.request.ItemsRequestDto;
import com.group1.dto.response.ItemsResponseDto;
import com.group1.repository.entity.Items;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface ItemsMapper {
    ItemsMapper INSTANCE = Mappers.getMapper(ItemsMapper.class);
    Items fromCreateItemsRequestDto(ItemsRequestDto dto);
    ItemsResponseDto fromItemsToCreateItemsResponse(Items items);
}
