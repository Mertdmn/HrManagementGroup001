package com.group1.mapper;

import com.group1.dto.request.PersonelSaveRequestDto;
import com.group1.dto.request.RegisterManagerRequestDto;
import com.group1.dto.request.RegisterRequestDto;
import com.group1.dto.response.ManagerResponseDto;
import com.group1.dto.response.RegisterResponseDto;
import com.group1.dto.response.ShowResponseDto;
import com.group1.rabbitmq.model.RegisterModel;
import com.group1.repository.entity.Manager;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ManagerMapper {
    ManagerMapper INSTANCE = Mappers.getMapper(ManagerMapper.class);
    ShowResponseDto toShow(final Manager manager);
    ManagerResponseDto toShowDetails(final Manager manager);
    RegisterRequestDto toRegister(final Manager manager);
    Manager fromRegisterRequestToManager(RegisterRequestDto dto);
//    @Mapping(source = "id", target ="managerId")
//    RegisterModel fromManagerToRegisterModel(Manager manager);

    RegisterResponseDto fromManagerToRegisterResponse(Manager manager);

    Manager fromDto(RegisterManagerRequestDto dto);
}
