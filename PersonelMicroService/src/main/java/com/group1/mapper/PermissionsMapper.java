package com.group1.mapper;


import com.group1.dto.request.PermissionRequestDto;
import com.group1.repository.entity.Permissions;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface PermissionsMapper {

  PermissionsMapper INSTANCE = Mappers.getMapper(PermissionsMapper.class);
    Permissions toPermissions(final PermissionRequestDto permissions);
}
