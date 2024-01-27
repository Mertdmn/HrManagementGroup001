package com.group1.service;

import com.group1.dto.request.AdvanceRequestDto;
import com.group1.dto.request.PermissionRequestDto;
import com.group1.exception.ErrorType;
import com.group1.exception.PersonelManagerException;
import com.group1.mapper.AdvanceMapper;
import com.group1.mapper.PermissionsMapper;
import com.group1.repository.PermissionsRepository;
import com.group1.repository.entity.Advance;
import com.group1.repository.entity.Permissions;
import com.group1.repository.entity.Personel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.group1.service.PersonelService.loginUser;

@Service
@RequiredArgsConstructor
public class PermissionsService {
    private final PermissionsRepository permissionsRepository;
    private final PersonelService personelService;

    public Optional<Permissions> createPermissions(PermissionRequestDto permissionRequestDto) {

        Permissions permissions = PermissionsMapper.INSTANCE.toPermissions(permissionRequestDto);

        Optional<Personel> personel = personelService.findById(loginUser);
        if (personel == null) {
            throw new PersonelManagerException(ErrorType.PERSONEL_NOT_FOUND);
        }
        return Optional.of(permissionsRepository.save(permissions));
    }
}
