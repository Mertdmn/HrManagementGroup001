package com.group1.mapper;

import com.group1.dto.response.ShowResponseDto;
import com.group1.repository.entity.Manager;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ManagerMapper {
    ManagerMapper INSTANCE = Mappers.getMapper(ManagerMapper.class);
    ShowResponseDto toShow(final Manager manager);
    Manager toShowDetails(final Manager manager);

}
