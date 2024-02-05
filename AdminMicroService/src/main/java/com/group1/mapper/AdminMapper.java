package com.group1.mapper;

import com.group1.dto.response.AdminResponseDto;
import com.group1.dto.response.ShowResponseDto;
import com.group1.repository.entity.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AdminMapper {
    AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);


    ShowResponseDto toShow(Admin admin);

    AdminResponseDto toShowDetails(Admin admin);
}
