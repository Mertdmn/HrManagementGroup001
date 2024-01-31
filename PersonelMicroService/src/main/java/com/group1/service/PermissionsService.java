package com.group1.service;

import com.group1.dto.request.PermissionRequestDto;
import com.group1.exception.ErrorType;
import com.group1.exception.PersonelManagerException;
import com.group1.mapper.PermissionsMapper;
import com.group1.repository.PermissionsRepository;
import com.group1.repository.entity.Permissions;
import com.group1.repository.entity.Personel;
import com.group1.utility.JwtTokenManager;
import com.group1.utility.enums.EState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PermissionsService {
    private final PermissionsRepository permissionsRepository;
    private final PersonelService personelService;
    private final JwtTokenManager jwtTokenManager;

    public Optional<Permissions> createPermissions(PermissionRequestDto permissionRequestDto) {
        Optional<Long> personelId=jwtTokenManager.getIdFromToken(permissionRequestDto.getToken());
        if (personelId.isEmpty()) {
            throw new PersonelManagerException(ErrorType.INVALID_TOKEN);
        }
        Permissions permissions = PermissionsMapper.INSTANCE.toPermissions(permissionRequestDto);

        permissions.setState(EState.PENDING);

        Optional<Personel> personel = personelService.findOptionalById(personelId.get());
        if (personel == null) {
            throw new PersonelManagerException(ErrorType.PERSONEL_NOT_FOUND);
        }
        return Optional.of(permissionsRepository.save(permissions));
    }
}
