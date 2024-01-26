package com.group1.controller;

import com.group1.constants.RestApiUrls;
import com.group1.dto.request.PermissionRequestDto;
import com.group1.dto.request.SpendingRequestDto;
import com.group1.repository.entity.Permissions;
import com.group1.repository.entity.Spending;
import com.group1.service.PermissionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static com.group1.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(PERMISSIONS)
public class PermissionsController {
    private final PermissionsService permissionsService;

    @PostMapping(CREATE)
    public ResponseEntity<Optional<Permissions>> createPermissions(PermissionRequestDto dto){
        return ResponseEntity.ok(permissionsService.createPermissions(dto));
    }

}
