package com.group1.controller;

import com.group1.dto.request.LoginAdminRequestDto;
import com.group1.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.group1.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(ADMIN)
public class AdminController {
    private final AdminService adminService;

    @PostMapping(LOGIN)
    public ResponseEntity<Boolean> login(@RequestBody LoginAdminRequestDto dto) {
        return ResponseEntity.ok(adminService.login(dto));
    }
}

